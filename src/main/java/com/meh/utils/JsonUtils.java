package com.meh.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class JsonUtils {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> T deserlialize(String str, Class<T> clazz) {
        try {
            return MAPPER.readValue(str, clazz);
        } catch (IOException e) {
            log.error("Failed to parse json data {} to {}", str, clazz, e);
            throw new RuntimeException(e);
        }
    }
}
