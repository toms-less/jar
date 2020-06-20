package com.toms.less.config;

import java.io.FileReader;
import java.io.IOException;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.toms.less.common.Component;
import com.toms.less.exception.TomsException;

/**
 * Configuration manager.
 * 
 * @author dujingbing
 */
@Singleton
public class ConfigManager implements Component {

    @Inject
    private GlobalConfig config;

    @Override
    public String name() {
        return "config_manager";
    }

    /**
     * Read configurations from 'config/config.yaml', and set them to 'GlobalConfig'
     * class.
     * 
     */
    @Override
    public void start() throws TomsException {
        YamlReader reader = null;
        try {
            reader = new YamlReader(new FileReader("config/config.yaml"));
            GlobalConfig current = reader.read(GlobalConfig.class);

            // copy.
            config.setServer(current.getServer());
        } catch (Exception e) {
            throw new TomsException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new TomsException(e);
                }
            }
        }
    }

    @Override
    public void stop() throws TomsException {
    }

}