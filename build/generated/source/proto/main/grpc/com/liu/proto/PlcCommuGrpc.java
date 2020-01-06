package com.liu.proto;

import exception.PLCCommunicationException;
import io.grpc.ManagedChannel;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.26.0)",
    comments = "Source: mitsubishifx5u.proto")
public final class PlcCommuGrpc {

  private PlcCommuGrpc() {}

  public static final String SERVICE_NAME = "plc.PlcCommu";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.liu.proto.PlcConnectRequest,
      com.liu.proto.PlcGeneralReply> getSetConnectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setConnect",
      requestType = com.liu.proto.PlcConnectRequest.class,
      responseType = com.liu.proto.PlcGeneralReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.liu.proto.PlcConnectRequest,
      com.liu.proto.PlcGeneralReply> getSetConnectMethod() {
    io.grpc.MethodDescriptor<com.liu.proto.PlcConnectRequest, com.liu.proto.PlcGeneralReply> getSetConnectMethod;
    if ((getSetConnectMethod = PlcCommuGrpc.getSetConnectMethod) == null) {
      synchronized (PlcCommuGrpc.class) {
        if ((getSetConnectMethod = PlcCommuGrpc.getSetConnectMethod) == null) {
          PlcCommuGrpc.getSetConnectMethod = getSetConnectMethod =
              io.grpc.MethodDescriptor.<com.liu.proto.PlcConnectRequest, com.liu.proto.PlcGeneralReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setConnect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.liu.proto.PlcConnectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.liu.proto.PlcGeneralReply.getDefaultInstance()))
              .setSchemaDescriptor(new PlcCommuMethodDescriptorSupplier("setConnect"))
              .build();
        }
      }
    }
    return getSetConnectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.liu.proto.PlcReadOneRequest,
      com.liu.proto.PlcReadOneReply> getReadOneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "readOne",
      requestType = com.liu.proto.PlcReadOneRequest.class,
      responseType = com.liu.proto.PlcReadOneReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.liu.proto.PlcReadOneRequest,
      com.liu.proto.PlcReadOneReply> getReadOneMethod() {
    io.grpc.MethodDescriptor<com.liu.proto.PlcReadOneRequest, com.liu.proto.PlcReadOneReply> getReadOneMethod;
    if ((getReadOneMethod = PlcCommuGrpc.getReadOneMethod) == null) {
      synchronized (PlcCommuGrpc.class) {
        if ((getReadOneMethod = PlcCommuGrpc.getReadOneMethod) == null) {
          PlcCommuGrpc.getReadOneMethod = getReadOneMethod =
              io.grpc.MethodDescriptor.<com.liu.proto.PlcReadOneRequest, com.liu.proto.PlcReadOneReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "readOne"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.liu.proto.PlcReadOneRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.liu.proto.PlcReadOneReply.getDefaultInstance()))
              .setSchemaDescriptor(new PlcCommuMethodDescriptorSupplier("readOne"))
              .build();
        }
      }
    }
    return getReadOneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.liu.proto.PlcReadManyRequest,
      com.liu.proto.PlcReadManyReply> getReadManyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "readMany",
      requestType = com.liu.proto.PlcReadManyRequest.class,
      responseType = com.liu.proto.PlcReadManyReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.liu.proto.PlcReadManyRequest,
      com.liu.proto.PlcReadManyReply> getReadManyMethod() {
    io.grpc.MethodDescriptor<com.liu.proto.PlcReadManyRequest, com.liu.proto.PlcReadManyReply> getReadManyMethod;
    if ((getReadManyMethod = PlcCommuGrpc.getReadManyMethod) == null) {
      synchronized (PlcCommuGrpc.class) {
        if ((getReadManyMethod = PlcCommuGrpc.getReadManyMethod) == null) {
          PlcCommuGrpc.getReadManyMethod = getReadManyMethod =
              io.grpc.MethodDescriptor.<com.liu.proto.PlcReadManyRequest, com.liu.proto.PlcReadManyReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "readMany"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.liu.proto.PlcReadManyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.liu.proto.PlcReadManyReply.getDefaultInstance()))
              .setSchemaDescriptor(new PlcCommuMethodDescriptorSupplier("readMany"))
              .build();
        }
      }
    }
    return getReadManyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.liu.proto.PlcWriteOneRequest,
      com.liu.proto.PlcGeneralReply> getWriteOneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "writeOne",
      requestType = com.liu.proto.PlcWriteOneRequest.class,
      responseType = com.liu.proto.PlcGeneralReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.liu.proto.PlcWriteOneRequest,
      com.liu.proto.PlcGeneralReply> getWriteOneMethod() {
    io.grpc.MethodDescriptor<com.liu.proto.PlcWriteOneRequest, com.liu.proto.PlcGeneralReply> getWriteOneMethod;
    if ((getWriteOneMethod = PlcCommuGrpc.getWriteOneMethod) == null) {
      synchronized (PlcCommuGrpc.class) {
        if ((getWriteOneMethod = PlcCommuGrpc.getWriteOneMethod) == null) {
          PlcCommuGrpc.getWriteOneMethod = getWriteOneMethod =
              io.grpc.MethodDescriptor.<com.liu.proto.PlcWriteOneRequest, com.liu.proto.PlcGeneralReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "writeOne"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.liu.proto.PlcWriteOneRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.liu.proto.PlcGeneralReply.getDefaultInstance()))
              .setSchemaDescriptor(new PlcCommuMethodDescriptorSupplier("writeOne"))
              .build();
        }
      }
    }
    return getWriteOneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.liu.proto.PlcWriteManyRequest,
      com.liu.proto.PlcGeneralReply> getWriteManyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "writeMany",
      requestType = com.liu.proto.PlcWriteManyRequest.class,
      responseType = com.liu.proto.PlcGeneralReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.liu.proto.PlcWriteManyRequest,
      com.liu.proto.PlcGeneralReply> getWriteManyMethod() {
    io.grpc.MethodDescriptor<com.liu.proto.PlcWriteManyRequest, com.liu.proto.PlcGeneralReply> getWriteManyMethod;
    if ((getWriteManyMethod = PlcCommuGrpc.getWriteManyMethod) == null) {
      synchronized (PlcCommuGrpc.class) {
        if ((getWriteManyMethod = PlcCommuGrpc.getWriteManyMethod) == null) {
          PlcCommuGrpc.getWriteManyMethod = getWriteManyMethod =
              io.grpc.MethodDescriptor.<com.liu.proto.PlcWriteManyRequest, com.liu.proto.PlcGeneralReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "writeMany"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.liu.proto.PlcWriteManyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.liu.proto.PlcGeneralReply.getDefaultInstance()))
              .setSchemaDescriptor(new PlcCommuMethodDescriptorSupplier("writeMany"))
              .build();
        }
      }
    }
    return getWriteManyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PlcCommuStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlcCommuStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PlcCommuStub>() {
        @java.lang.Override
        public PlcCommuStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PlcCommuStub(channel, callOptions);
        }
      };
    return PlcCommuStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PlcCommuBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlcCommuBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PlcCommuBlockingStub>() {
        @java.lang.Override
        public PlcCommuBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PlcCommuBlockingStub(channel, callOptions);
        }
      };
    return PlcCommuBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PlcCommuFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlcCommuFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PlcCommuFutureStub>() {
        @java.lang.Override
        public PlcCommuFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PlcCommuFutureStub(channel, callOptions);
        }
      };
    return PlcCommuFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PlcCommuImplBase implements io.grpc.BindableService {

    /**
     */
    public void setConnect(com.liu.proto.PlcConnectRequest request,
        io.grpc.stub.StreamObserver<com.liu.proto.PlcGeneralReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSetConnectMethod(), responseObserver);
    }

    /**
     */
    public void readOne(com.liu.proto.PlcReadOneRequest request,
        io.grpc.stub.StreamObserver<com.liu.proto.PlcReadOneReply> responseObserver) throws PLCCommunicationException {
      asyncUnimplementedUnaryCall(getReadOneMethod(), responseObserver);
    }

    /**
     */
    public void readMany(com.liu.proto.PlcReadManyRequest request,
        io.grpc.stub.StreamObserver<com.liu.proto.PlcReadManyReply> responseObserver) {
      asyncUnimplementedUnaryCall(getReadManyMethod(), responseObserver);
    }

    /**
     */
    public void writeOne(com.liu.proto.PlcWriteOneRequest request,
        io.grpc.stub.StreamObserver<com.liu.proto.PlcGeneralReply> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteOneMethod(), responseObserver);
    }

    /**
     */
    public void writeMany(com.liu.proto.PlcWriteManyRequest request,
        io.grpc.stub.StreamObserver<com.liu.proto.PlcGeneralReply> responseObserver) {
      asyncUnimplementedUnaryCall(getWriteManyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetConnectMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.liu.proto.PlcConnectRequest,
                com.liu.proto.PlcGeneralReply>(
                  this, METHODID_SET_CONNECT)))
          .addMethod(
            getReadOneMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.liu.proto.PlcReadOneRequest,
                com.liu.proto.PlcReadOneReply>(
                  this, METHODID_READ_ONE)))
          .addMethod(
            getReadManyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.liu.proto.PlcReadManyRequest,
                com.liu.proto.PlcReadManyReply>(
                  this, METHODID_READ_MANY)))
          .addMethod(
            getWriteOneMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.liu.proto.PlcWriteOneRequest,
                com.liu.proto.PlcGeneralReply>(
                  this, METHODID_WRITE_ONE)))
          .addMethod(
            getWriteManyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.liu.proto.PlcWriteManyRequest,
                com.liu.proto.PlcGeneralReply>(
                  this, METHODID_WRITE_MANY)))
          .build();
    }
  }

  /**
   */
  public static final class PlcCommuStub extends io.grpc.stub.AbstractAsyncStub<PlcCommuStub> {
    private PlcCommuStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlcCommuStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlcCommuStub(channel, callOptions);
    }

    /**
     */
    public void setConnect(com.liu.proto.PlcConnectRequest request,
        io.grpc.stub.StreamObserver<com.liu.proto.PlcGeneralReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetConnectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readOne(com.liu.proto.PlcReadOneRequest request,
        io.grpc.stub.StreamObserver<com.liu.proto.PlcReadOneReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadOneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readMany(com.liu.proto.PlcReadManyRequest request,
        io.grpc.stub.StreamObserver<com.liu.proto.PlcReadManyReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadManyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeOne(com.liu.proto.PlcWriteOneRequest request,
        io.grpc.stub.StreamObserver<com.liu.proto.PlcGeneralReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteOneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void writeMany(com.liu.proto.PlcWriteManyRequest request,
        io.grpc.stub.StreamObserver<com.liu.proto.PlcGeneralReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWriteManyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PlcCommuBlockingStub extends io.grpc.stub.AbstractBlockingStub<PlcCommuBlockingStub> {
    public PlcCommuBlockingStub(
            io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }
    @java.lang.Override
    protected PlcCommuBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlcCommuBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.liu.proto.PlcGeneralReply setConnect(com.liu.proto.PlcConnectRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetConnectMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.liu.proto.PlcReadOneReply readOne(com.liu.proto.PlcReadOneRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadOneMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.liu.proto.PlcReadManyReply readMany(com.liu.proto.PlcReadManyRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadManyMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.liu.proto.PlcGeneralReply writeOne(com.liu.proto.PlcWriteOneRequest request) {
      return blockingUnaryCall(
          getChannel(), getWriteOneMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.liu.proto.PlcGeneralReply writeMany(com.liu.proto.PlcWriteManyRequest request) {
      return blockingUnaryCall(
          getChannel(), getWriteManyMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PlcCommuFutureStub extends io.grpc.stub.AbstractFutureStub<PlcCommuFutureStub> {
    private PlcCommuFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlcCommuFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlcCommuFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.liu.proto.PlcGeneralReply> setConnect(
        com.liu.proto.PlcConnectRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetConnectMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.liu.proto.PlcReadOneReply> readOne(
        com.liu.proto.PlcReadOneRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadOneMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.liu.proto.PlcReadManyReply> readMany(
        com.liu.proto.PlcReadManyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadManyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.liu.proto.PlcGeneralReply> writeOne(
        com.liu.proto.PlcWriteOneRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteOneMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.liu.proto.PlcGeneralReply> writeMany(
        com.liu.proto.PlcWriteManyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getWriteManyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_CONNECT = 0;
  private static final int METHODID_READ_ONE = 1;
  private static final int METHODID_READ_MANY = 2;
  private static final int METHODID_WRITE_ONE = 3;
  private static final int METHODID_WRITE_MANY = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PlcCommuImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PlcCommuImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_CONNECT:
          serviceImpl.setConnect((com.liu.proto.PlcConnectRequest) request,
              (io.grpc.stub.StreamObserver<com.liu.proto.PlcGeneralReply>) responseObserver);
          break;
        case METHODID_READ_ONE:
          try {
            serviceImpl.readOne((PlcReadOneRequest) request,
                (io.grpc.stub.StreamObserver<PlcReadOneReply>) responseObserver);
          } catch (PLCCommunicationException e) {
            e.printStackTrace();
          }
          break;
        case METHODID_READ_MANY:
          serviceImpl.readMany((com.liu.proto.PlcReadManyRequest) request,
              (io.grpc.stub.StreamObserver<com.liu.proto.PlcReadManyReply>) responseObserver);
          break;
        case METHODID_WRITE_ONE:
          serviceImpl.writeOne((com.liu.proto.PlcWriteOneRequest) request,
              (io.grpc.stub.StreamObserver<com.liu.proto.PlcGeneralReply>) responseObserver);
          break;
        case METHODID_WRITE_MANY:
          serviceImpl.writeMany((com.liu.proto.PlcWriteManyRequest) request,
              (io.grpc.stub.StreamObserver<com.liu.proto.PlcGeneralReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PlcCommuBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PlcCommuBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.liu.proto.MitsubishiFx5uProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PlcCommu");
    }
  }

  private static final class PlcCommuFileDescriptorSupplier
      extends PlcCommuBaseDescriptorSupplier {
    PlcCommuFileDescriptorSupplier() {}
  }

  private static final class PlcCommuMethodDescriptorSupplier
      extends PlcCommuBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PlcCommuMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PlcCommuGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PlcCommuFileDescriptorSupplier())
              .addMethod(getSetConnectMethod())
              .addMethod(getReadOneMethod())
              .addMethod(getReadManyMethod())
              .addMethod(getWriteOneMethod())
              .addMethod(getWriteManyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
