package com.toms.less.server;

import io.grpc.stub.StreamObserver;

/**
 * Service of runtime, which implements the service of 'runtime.proto' file
 * defined.
 * 
 * @author dujingbing
 */
public class RuntimeService extends RuntimeServiceGrpc.RuntimeServiceImplBase {

    @Override
    public void call(RuntimeRequest request, StreamObserver<RuntimeResponse> responseObserver) {
    }
}