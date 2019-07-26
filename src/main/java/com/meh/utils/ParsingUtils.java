package com.meh.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParsingUtils {
    public static String nextValidJson(List<String> lines, Integer startIndex) {
        StringBuilder res = new StringBuilder();

        IntStream
                .range(startIndex + 1, lines.size())
                .sequential()
                .takeWhile(i -> !lines.get(i).startsWith("}"))
                .forEach(q -> res.append(lines.get(q)));

        return res.toString() + "}";
    }
}
