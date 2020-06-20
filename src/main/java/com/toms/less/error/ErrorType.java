package com.toms.less.error;

/**
 * Error type.
 * 
 * @author dujingbing
 */
public enum ErrorType {
    SYSTEM(0), USER(1), UNKNOWN(-1);

    private int type;

    ErrorType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public static ErrorType of(int type) {
        if (SYSTEM.type == type) {
            return SYSTEM;
        } else if (USER.type == type) {
            return USER;
        } else {
            return UNKNOWN;
        }
    }
}