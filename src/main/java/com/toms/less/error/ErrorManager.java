package com.toms.less.error;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.google.inject.Singleton;
import com.toms.less.common.Component;
import com.toms.less.exception.TomsException;

import org.apache.commons.lang3.StringUtils;

/**
 * Error manager for system and user.
 * 
 * @author dujingbing
 */
@Singleton
public class ErrorManager implements Component {

    private static final Map<String, Error> ERROR_MAP = new HashMap<String, Error>();

    private static final Error DEFAULT_ERROR = new Error("unknown.error", ErrorType.UNKNOWN, 30000000l,
            "unknown error.");

    /**
     * Get error by key.
     * 
     */
    public static Error get(String key) {
        if (StringUtils.isBlank(key)) {
            return DEFAULT_ERROR;
        }

        Error current = ERROR_MAP.get(key);
        if (current == null) {
            return DEFAULT_ERROR;
        }

        return current;
    }

    @Override
    public String name() {
        return "massage_manager";
    }

    @Override
    public void start() throws TomsException {
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(ErrorManager.class.getResourceAsStream("/error.properties"), "UTF-8");
            Properties properties = new Properties();
            properties.load(reader);

            for (Object propertyKey : properties.keySet()) {
                if (propertyKey == null || !(propertyKey instanceof String)) {
                    continue;
                }
                String key = (String) propertyKey;

                Object propertyValue = properties.get(key);
                if (propertyValue == null || !(propertyValue instanceof String)) {
                    continue;
                }
                String value = (String) propertyValue;

                String[] splitedValue = value.split("$");
                if (splitedValue.length != 3) {
                    continue;
                }

                ErrorType errorType = null;
                try {
                    errorType = ErrorType.of(Integer.valueOf(splitedValue[0]));
                } catch (Exception e) {
                    continue;
                }

                Long code = null;
                try {
                    code = Long.valueOf(splitedValue[1]);
                } catch (Exception e) {
                    continue;
                }

                String message = splitedValue[2];
                ERROR_MAP.put(key, new Error(key, errorType, code, message));
            }
        } catch (Exception e) {
            throw new TomsException(e);
        } catch (Throwable e) {
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