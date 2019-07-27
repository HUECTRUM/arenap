package com.meh.parser.internalparsing;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class JsonFileParser {
    public String nextValidJson(List<String> lines, Integer startIndex) {
        return String.format("%s}",
                IntStream
                        .range(startIndex + 1, lines.size())
                        .sequential()
                        .takeWhile(i -> !lines.get(i).startsWith("}")) //end of json input criteria
                        .mapToObj(lines::get)
                        .collect(Collectors.joining(""))
        );
    }
}
