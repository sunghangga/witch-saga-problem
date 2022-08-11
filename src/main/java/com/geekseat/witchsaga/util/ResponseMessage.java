package com.geekseat.witchsaga.util;

import java.util.HashMap;
import java.util.Map;

public class ResponseMessage {

    public static Map<String, Object> exceptionErrorJson(int status, Object message) {
        return new HashMap<String, Object>() {{
            put("status", status);
            put("message", message);
        }};
    }

    public static Map<String, Object> retrieveDataJson(int status, String message, Object response) {
        return new HashMap<String, Object>() {{
            put("status", status);
            put("message", message);
            put("data", response);
        }};
    }
}
