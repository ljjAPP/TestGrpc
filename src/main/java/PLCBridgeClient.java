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

import com.liu.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.logging.Logger;

/**
 * A simple client that requests a greeting from the {@link PLCBridgeServer}.
 */
public class PLCBridgeClient extends GrpcClient {
    private static final Logger logger = Logger.getLogger(PLCBridgeClient.class.getName());
    private final ManagedChannel channel;
   // private CallOptions options = CallOptions.DEFAULT.withAuthority("fe");
    /* blockingStub = GreeterGrpc.newBlockingStub(channel);
        cbs = CalculateGrpc.newBlockingStub(channel);*/
    private final PlcCommuGrpc.PlcCommuBlockingStub pbs;
    /*private final GreeterGrpc.GreeterBlockingStub blockingStub;
    private final CalculateGrpc.CalculateBlockingStub cbs;*/

    /**
     * Construct client connecting to HelloWorld server at {@code host:port}.
     */
    public PLCBridgeClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
        //this.pbs = new PlcCommuGrpc.PlcCommuBlockingStub(channel,options);
    }

    /**
     * Construct client for accessing HelloWorld server using the existing channel.
     */
    PLCBridgeClient(ManagedChannel channel) {
        this.channel = channel;
        this.pbs = PlcCommuGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        //channel.shutdown().awaitTermination(0, TimeUnit.NANOSECONDS);
    }
    public void readOne(){
        PlcReadOneRequest request = PlcReadOneRequest.newBuilder().setDestination("Y21").build();
        PlcReadOneReply value=pbs.readOne(request);
        System.out.println(value.getValue());
    }
    public void readMany(){
        PlcReadManyRequest request =
                PlcReadManyRequest.newBuilder().setStartDestination("Y20").setDestinationNumbers(3).build();
        PlcReadManyReply value = pbs.readMany(request);
        System.out.println(value.getValuesJsonArray());
    }
    public void writeMany(){
        PlcWriteManyRequest request =
                PlcWriteManyRequest.newBuilder().setStartDestination("D20").setDestinationNumbers(5).build();
        PlcGeneralReply reply = pbs.writeMany(request);
        System.out.println(reply.getResult());
    }

    /**
     * Greet server. If provided, the first element of {@code args} is the name to use in the
     * greeting.
     */
    public static void main(String[] args) throws Exception {
        // Access a service running on the local machine on port 50051
        PLCBridgeClient client = new PLCBridgeClient("localhost", 50051);
        try {
//      String user = "world";
//      // Use the arg as the name to greet if provided
//      if (args.length > 0) {
//        user = args[0];
//      }
            //client.calc(3, 5);
            client.readOne();
            client.readMany();
            client.writeMany();
        }catch (Exception e){
            System.out.println(e.toString());
        }finally {
            client.shutdown();
        }
        /*ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",50051).usePlaintext().build();
        CallOptions options = CallOptions.DEFAULT.withAuthority("fe");
        PlcCommuGrpc.PlcCommuBlockingStub pbs = new PlcCommuGrpc.PlcCommuBlockingStub(channel,options);
        PlcReadOneRequest request = PlcReadOneRequest.newBuilder().setDestination("Y20").build();
        PlcReadOneReply value=pbs.readOne(request);
        System.out.println(value.getValue());*/
    }
}
