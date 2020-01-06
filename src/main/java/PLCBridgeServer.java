/*
 * Copyright 2015 The gRPC Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.alibaba.fastjson.JSONObject;
import com.liu.proto.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Server that manages startup/shutdown of a {@code Greeter} server.
 */
public class PLCBridgeServer extends GrpcServer {
    public  static Map<String, List<Integer>> readMap = new HashMap<>();
    public  static Map<String, List<Integer>> writeMap = new HashMap<>();
    private static final Logger logger = Logger.getLogger(PLCBridgeServer.class.getName());
    private static PLC plc;
    private Server server;

    private static void analyzeRange(String range){
        JSONObject object = JSONObject.parseObject(range);
        for (Map.Entry<String, Object> entry : object.entrySet()) {
            String key = entry.getKey();
            String numStr = entry.getValue().toString();
            String type = key.substring(0,1);
            String begin = key.substring(1);
            int num = Integer.parseInt(numStr);
            int numBegin = Integer.parseInt(begin);
            if(readMap.containsKey(type)){
                for(int j=numBegin;j<numBegin+num;j++){
                    if(!readMap.get(type).contains(j)){
                        readMap.get(type).add(j);
                    }
                }
            }else{
                List<Integer> arr = new ArrayList<>();
                for(int j=numBegin;j<numBegin+num;j++){
                    arr.add(j);
                }
                readMap.put(type,arr);
            }
        }
        for (String key : readMap.keySet()) {
            Collections.sort(readMap.get(key));
        }
    }
    private static int getOffset(String name){
        String type = name.substring(0,1);
        String numStr = name.substring(1);
        List<Integer> list = readMap.get(type);
        int num = Integer.parseInt(numStr);
        int first = list.get(0);
        int offset=num-first;
        if(offset>=0){
            return offset;
        }else{
            return -1;
        }
    }
    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 50051;
        server = ServerBuilder.forPort(port)
                .addService(new PlcImpl())
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    PLCBridgeServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final PLCBridgeServer server = new PLCBridgeServer();
        server.start();
        server.blockUntilShutdown();
    }

    static class PlcImpl extends PlcCommuGrpc.PlcCommuImplBase {

        private PlcBridge pb;

        @Override
        public void setConnect(PlcConnectRequest req, StreamObserver<PlcGeneralReply> observer) {
            String ip = req.getIp();
            int port = req.getPort();
            int slaveId = req.getSlaveId();
            boolean isKeepingAlive = req.getIsKeepingAlive();
            boolean openAutoIncrementTransactionId = req.getOpenAutoIncrementTransactionId();
            String range = req.getRange();

            try {
                this.pb = PlcBridge.getPlc(ip, port, slaveId, isKeepingAlive, openAutoIncrementTransactionId);
                pb.setRange(range);
                PlcGeneralReply reply = PlcGeneralReply.newBuilder().setResult(true).build();
            } catch (Exception e) {
                PlcGeneralReply reply = PlcGeneralReply.newBuilder().setResult(false).build();
                observer.onNext(reply);
                observer.onCompleted();
            }
        }

        @Override
        public void readOne(PlcReadOneRequest request, StreamObserver<PlcReadOneReply> responseObserver){
            String range = "{\"Y21\":\"2\",\"Y23\":\"3\",\"D21\":\"2\",\"M300\":\"2\",\"X20\":\"2\",\"Y22\":\"6\"}";
            analyzeRange(range);
            String dest = request.getDestination();
            int value = getOffset(dest);
            PlcReadOneReply reply = PlcReadOneReply.newBuilder().setValue(value).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void readMany(PlcReadManyRequest request, StreamObserver<PlcReadManyReply> responseObserver) {
            //readMany(request, responseObserver);
            String dest = request.getStartDestination();
            String type = dest.substring(0,1);
            String beginstr = dest.substring(1);
            int begin = Integer.parseInt(beginstr);
            int num = request.getDestinationNumbers();
            List<String> list = new ArrayList<>();
            for(int i=0;i<num;i++){
                list.add(type+(begin+i));
            }
            PlcReadManyReply reply = PlcReadManyReply.newBuilder().setValuesJsonArray(list.toString()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void writeOne(PlcWriteOneRequest request, StreamObserver<PlcGeneralReply> responseObserver) {
            //writeOne(request, responseObserver);
            String dest = request.getDestination();
        }

        @Override
        public void writeMany(PlcWriteManyRequest request, StreamObserver<PlcGeneralReply> responseObserver) {
            //writeMany(request, responseObserver);
            String dest = request.getStartDestination();
            String beginstr = dest.substring(1);
            String type = dest.substring(0,1);
            int begin = Integer.parseInt(beginstr);
            int num = request.getDestinationNumbers();
            if(writeMap.containsKey(type)){
                for(int j=begin;j<begin+num;j++){
                    if(!writeMap.get(type).contains(j)){
                        writeMap.get(type).add(j);
                    }
                }
            }else{
                List<Integer> arr = new ArrayList<>();
                for(int j=begin;j<begin+num;j++){
                    arr.add(j);
                }
                writeMap.put(type,arr);
            }
            for (String key : writeMap.keySet()) {
                Collections.sort(writeMap.get(key));
            }
            PlcGeneralReply reply = PlcGeneralReply.newBuilder().setResult(true).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}
