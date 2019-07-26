package com.meh.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class JsonUtils {
    private final ObjectMapper MAPPER = new ObjectMapper();

    @SneakyThrows
    public <T> T deserialize(String str, Class<T> clazz) {
        return MAPPER.readValue(str, clazz);
    }
}
