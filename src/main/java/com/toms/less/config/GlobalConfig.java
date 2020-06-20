package com.toms.less.config;

import com.google.inject.Singleton;

/**
 * Default configuration of runtime.
 * 
 * @author dujingbing
 */
@Singleton
public class GlobalConfig {

    /**
     * server configurations.
     * 
     */
    private ServerConfig server;

    public ServerConfig getServer() {
        return server;
    }

    public void setServer(ServerConfig server) {
        this.server = server;
    }
}