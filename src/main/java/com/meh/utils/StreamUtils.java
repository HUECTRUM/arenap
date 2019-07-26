package com.meh.utils;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@UtilityClass
public class StreamUtils {
    public <R, T> List<R> mapList(List<T> list, Function<? super T, ? extends R> mapper) {
        return list
                .stream()
                .map(mapper)
                .collect(toList());
    }
}
