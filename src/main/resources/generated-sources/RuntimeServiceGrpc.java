package com.toms.less.server;

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
    value = "by gRPC proto compiler",
    comments = "Source: src/main/java/com/toms/less/protos/runtime.proto")
public final class RuntimeServiceGrpc {

  private RuntimeServiceGrpc() {}

  public static final String SERVICE_NAME = "server.RuntimeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.toms.less.server.RuntimeRequest,
      com.toms.less.server.RuntimeResponse> getCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Call",
      requestType = com.toms.less.server.RuntimeRequest.class,
      responseType = com.toms.less.server.RuntimeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.toms.less.server.RuntimeRequest,
      com.toms.less.server.RuntimeResponse> getCallMethod() {
    io.grpc.MethodDescriptor<com.toms.less.server.RuntimeRequest, com.toms.less.server.RuntimeResponse> getCallMethod;
    if ((getCallMethod = RuntimeServiceGrpc.getCallMethod) == null) {
      synchronized (RuntimeServiceGrpc.class) {
        if ((getCallMethod = RuntimeServiceGrpc.getCallMethod) == null) {
          RuntimeServiceGrpc.getCallMethod = getCallMethod =
              io.grpc.MethodDescriptor.<com.toms.less.server.RuntimeRequest, com.toms.less.server.RuntimeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Call"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.toms.less.server.RuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.toms.less.server.RuntimeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RuntimeServiceMethodDescriptorSupplier("Call"))
              .build();
        }
      }
    }
    return getCallMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RuntimeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RuntimeServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RuntimeServiceStub>() {
        @java.lang.Override
        public RuntimeServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RuntimeServiceStub(channel, callOptions);
        }
      };
    return RuntimeServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RuntimeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RuntimeServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RuntimeServiceBlockingStub>() {
        @java.lang.Override
        public RuntimeServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RuntimeServiceBlockingStub(channel, callOptions);
        }
      };
    return RuntimeServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RuntimeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RuntimeServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RuntimeServiceFutureStub>() {
        @java.lang.Override
        public RuntimeServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RuntimeServiceFutureStub(channel, callOptions);
        }
      };
    return RuntimeServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RuntimeServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void call(com.toms.less.server.RuntimeRequest request,
        io.grpc.stub.StreamObserver<com.toms.less.server.RuntimeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCallMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCallMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.toms.less.server.RuntimeRequest,
                com.toms.less.server.RuntimeResponse>(
                  this, METHODID_CALL)))
          .build();
    }
  }

  /**
   */
  public static final class RuntimeServiceStub extends io.grpc.stub.AbstractAsyncStub<RuntimeServiceStub> {
    private RuntimeServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RuntimeServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RuntimeServiceStub(channel, callOptions);
    }

    /**
     */
    public void call(com.toms.less.server.RuntimeRequest request,
        io.grpc.stub.StreamObserver<com.toms.less.server.RuntimeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCallMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RuntimeServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RuntimeServiceBlockingStub> {
    private RuntimeServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RuntimeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RuntimeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.toms.less.server.RuntimeResponse call(com.toms.less.server.RuntimeRequest request) {
      return blockingUnaryCall(
          getChannel(), getCallMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RuntimeServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RuntimeServiceFutureStub> {
    private RuntimeServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RuntimeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RuntimeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.toms.less.server.RuntimeResponse> call(
        com.toms.less.server.RuntimeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCallMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CALL = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RuntimeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RuntimeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALL:
          serviceImpl.call((com.toms.less.server.RuntimeRequest) request,
              (io.grpc.stub.StreamObserver<com.toms.less.server.RuntimeResponse>) responseObserver);
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

  private static abstract class RuntimeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RuntimeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.toms.less.server.RuntimeProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RuntimeService");
    }
  }

  private static final class RuntimeServiceFileDescriptorSupplier
      extends RuntimeServiceBaseDescriptorSupplier {
    RuntimeServiceFileDescriptorSupplier() {}
  }

  private static final class RuntimeServiceMethodDescriptorSupplier
      extends RuntimeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RuntimeServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RuntimeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RuntimeServiceFileDescriptorSupplier())
              .addMethod(getCallMethod())
              .build();
        }
      }
    }
    return result;
  }
}
