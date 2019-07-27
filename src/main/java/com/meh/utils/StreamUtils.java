package com.meh.utils;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;

public class StreamUtils {
    public static <R, T> List<R> mapList(Collection<T> list, Function<? super T, ? extends R> mapper) {
        return list
                .stream()
                .map(mapper)
                .collect(toList());
    }

    public static <T> List<T> filterList(Collection<T> list, Predicate<? super T> predicate) {
        return list
                .stream()
                .filter(predicate)
                .collect(toList());
    }

    public static <T> List<T> concatLists(Collection<T> firstColl, Collection<T> secondColl) {
        return concat(firstColl.stream(), secondColl.stream()).collect(toList());
    }
}
