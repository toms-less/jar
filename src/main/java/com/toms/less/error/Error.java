package com.toms.less.error;

import java.io.Serializable;

/**
 * Error model.
 * 
 * @author dujingbing
 */
public class Error implements Serializable {

    private static final long serialVersionUID = 8079220822605593402L;

    /**
     * Error key defined in exceptions, like 'system.component.bind.error'.
     * 
     */
    private String key;

    /**
     * Error type.
     * 
     */
    private ErrorType type;

    /**
     * Error code.
     * 
     */
    private long code;

    /**
     * Error message.
     * 
     */
    private String message;

    public Error() {
    }

    public Error(String key, ErrorType type, long code, String message) {
        this.key = key;
        this.type = type;
        this.code = code;
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ErrorType getType() {
        return type;
    }

    public void setType(ErrorType type) {
        this.type = type;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}