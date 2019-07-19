package com.meh.utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamUtils {
    public static <R, T> List<R> mapList(List<T> list, Function<? super T, ? extends R> mapper) {
        return list
                .stream()
                .map(mapper)
                .collect(Collectors.toList());
    }
}
