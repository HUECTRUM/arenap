package com.meh.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParsingUtils {


    public static String nextValidJson(List<String> lines, Integer startIndex) {
        StringBuilder res = new StringBuilder();

        for (int index = startIndex + 1; !lines.get(index).startsWith("}"); ++index) {
            res.append(lines.get(index));
        }

        return res.toString() + "}";
    }
}
