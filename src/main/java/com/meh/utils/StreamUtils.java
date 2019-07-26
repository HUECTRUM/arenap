package com.meh.utils;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class StreamUtils {
    public static  <R, T> List<R> mapList(List<T> list, Function<? super T, ? extends R> mapper) {
        return list
                .stream()
                .map(mapper)
                .collect(toList());
    }
}
