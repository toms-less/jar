package com.toms.less.exception;

import com.toms.less.error.ErrorManager;
import com.toms.less.utils.SerializeUtil;

/**
 * Basic exception.
 * 
 * @author dujingbing
 */
public class TomsException extends Exception {

    private static final long serialVersionUID = -1828823315929928434L;

    /**
     * exception key for getting detail message.
     * 
     */
    private String key = "unknown.error";

    public TomsException(Throwable e) {
        super(e);
    }

    public TomsException(String key) {
        this.key = key;
    }

    public TomsException(String key, Throwable e) {
        super(e);
        this.key = key;
    }

    @Override
    public String toString() {
        return "{'local': " + SerializeUtil.toJsonString(ErrorManager.get(key)) + ", 'message': "
                + this.getCause() != null ? this.getCause().getMessage() : "" + "}";
    }
}