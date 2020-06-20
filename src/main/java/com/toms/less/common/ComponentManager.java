package com.toms.less.common;

import java.util.List;
import java.util.ArrayList;

import com.toms.less.exception.TomsException;

import org.apache.commons.lang3.StringUtils;

/**
 * Manager all the componenet of runtime.
 * 
 * @author dujingbing
 */
public class ComponentManager {

    /**
     * component list of runtime.
     * 
     */
    private List<Component> components = new ArrayList<Component>();

    /**
     * bind the specific component.
     * 
     */
    public void bind(Component component) throws TomsException {
        if (component == null) {
            throw new TomsException("system.component.bind.error");
        }

        for (Component current : components) {
            String name = current.name();
            if (StringUtils.isBlank(name)) {
                throw new TomsException("system.component.bind.error");
            }
            if (name.equals(component.name())) {
                throw new TomsException("system.component.bind.error");
            }
        }
        components.add(component);
    }

    /**
     * start all the components of runtime.
     * 
     */
    public void startAll() throws TomsException {
        if (components.size() == 0) {
            throw new TomsException("system.component.start.error");
        }

        for (Component current : components) {
            current.start();
        }
    }

    /**
     * stop all the components of runtime.
     * 
     */
    public void stopAll() throws TomsException {
        if (components.size() == 0) {
            throw new TomsException("system.component.stop.error");
        }

        for (Component current : components) {
            current.stop();
        }
    }
}