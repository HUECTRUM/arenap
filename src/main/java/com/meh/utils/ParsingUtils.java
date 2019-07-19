package com.meh.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParsingUtils {
    public static List<Integer> startIndexes(List<String> lines, String lineStart) {
        return IntStream
                .range(0, lines.size() - 1)
                .filter(i -> lines.get(i).startsWith(lineStart))
                .boxed()
                .collect(Collectors.toList());
    }

    public static String nextValidJson(List<String> lines, Integer startIndex) {
        StringBuilder res = new StringBuilder();

        for (int index = startIndex + 1; !lines.get(index).startsWith("}"); ++index) {
            res.append(lines.get(index));
        }

        return res.toString() + "}";
    }
}
