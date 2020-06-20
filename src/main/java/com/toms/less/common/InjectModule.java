package com.toms.less.common;

import com.google.inject.AbstractModule;

/**
 * Inject module manager by guice.
 * 
 * @author dujingbing
 */
public class InjectModule extends AbstractModule {

    @Override
    protected void configure() {
        // bind(IHelloPrinter.class).to(SimpleHelloPrinter.class);
    }
}