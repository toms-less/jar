package com.toms.less.utils;

import com.google.gson.Gson;

/**
 * Object serialize tool.
 * 
 * @author dujingbing
 */
public class SerializeUtil {

    private static Gson gson = new Gson();

    public static String toJsonString(Object object) {
        if (object == null) {
            return null;
        }
        return gson.toJson(object);
    }
}