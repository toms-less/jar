package com.toms.less.common;

import com.toms.less.exception.TomsException;

/**
 * Component interface for all modules.
 * 
 * @author dujingbing
 */
public interface Component {

    /**
     * component name.
     * 
     */
    public String name();

    /**
     * start current component.
     * 
     * @throws TomsException
     */
    public void start() throws TomsException;

    /**
     * stop current component.
     * 
     * @throws TomsException
     */
    public void stop() throws TomsException;
}