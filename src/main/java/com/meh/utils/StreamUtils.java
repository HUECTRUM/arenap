package com.meh.utils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class StreamUtils {
    public static <R, T> List<R> mapList(List<T> list, Function<? super T, ? extends R> mapper) {
        return list
                .stream()
                .map(mapper)
                .collect(toList());
    }

    public static <T, R> Map<T, R> toIdentityValuesMap(List<R> list, Function<? super R, ? extends T> keyMapper) {
        return list
                .stream()
                .collect(toMap(keyMapper, identity()));
    }
}
