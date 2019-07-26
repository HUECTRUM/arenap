package com.meh.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtils {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @SneakyThrows
    public static  <T> T deserialize(String str, Class<T> clazz) {
        return MAPPER.readValue(str, clazz);
    }
}
