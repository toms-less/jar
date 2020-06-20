package com.toms.less;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.toms.less.common.ComponentManager;
import com.toms.less.common.InjectModule;
import com.toms.less.config.ConfigManager;
import com.toms.less.error.ErrorManager;
import com.toms.less.exception.TomsException;
import com.toms.less.server.Runtime;
import com.toms.less.utils.TomsLog;

/**
 * 'toms-java' runtime.
 * 
 * @author dujingbing
 */
public class App {
    public static void main(String[] args) {
        try {
            Injector injector = Guice.createInjector(new InjectModule());

            // build components.
            ErrorManager errorManager = injector.getInstance(ErrorManager.class);
            ConfigManager configManager = injector.getInstance(ConfigManager.class);
            Runtime runtime = injector.getInstance(Runtime.class);

            // bind components.
            ComponentManager manager = new ComponentManager();
            manager.bind(errorManager);
            manager.bind(configManager);
            manager.bind(runtime);

            // start all the components.
            manager.startAll();
        } catch (TomsException e) {
            TomsLog.SERVER_LOG.error("Runtime running error.", e);
        } catch (Throwable e) {
            TomsLog.SERVER_LOG.error("Runtime running error.", e);
        }
    }
}
