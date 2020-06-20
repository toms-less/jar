package com.toms.less.server;

import java.util.concurrent.TimeUnit;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.toms.less.common.Component;
import com.toms.less.config.GlobalConfig;
import com.toms.less.config.ServerConfig;
import com.toms.less.exception.TomsException;
import com.toms.less.utils.TomsLog;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * Runtime server.
 * 
 * @author dujingbing
 */
@Singleton
public class Runtime implements Component {

    @Inject
    private GlobalConfig config;

    private Server server;

    @Override
    public String name() {
        return "runtime";
    }

    @Override
    public void start() throws TomsException {
        try {
            ServerConfig serverConfig = config.getServer();
            if (serverConfig == null) {
                throw new TomsException("system.runtime.start.error");
            }

            int port = serverConfig.getPort();
            if (port <= 1024 || port > 65536) {
                throw new TomsException("system.runtime.start.error");
            }

            server = ServerBuilder.forPort(port).addService(new RuntimeService()).build();
            server.start();
            TomsLog.SERVER_LOG.info("Server started, listenning on '" + port + "'.");

            // Await termination on the main thread since the grpc library uses daemon
            // threads.
            server.awaitTermination();
        } catch (Exception e) {
            TomsLog.SERVER_LOG.error("Server start error.", e);
            hook();
            throw new TomsException(e);
        } catch (Throwable e) {
            TomsLog.SERVER_LOG.error("Server start error.", e);
            hook();
            throw new TomsException(e);
        }
    }

    @Override
    public void stop() throws TomsException {
        if (server != null) {
            try {
                server.shutdown().awaitTermination(10, TimeUnit.SECONDS);
            } catch (Exception e) {
                TomsLog.SERVER_LOG.error("Server stop error.", e);
            }
        }
        TomsLog.SERVER_LOG.error("Server has been stopped.");
    }

    private void hook() {
        java.lang.Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    Runtime.this.stop();
                } catch (TomsException e) {
                }
            }
        });
    }
}