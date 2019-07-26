package com.meh.reader;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;

@Component
public class FileReader {
    @SneakyThrows
    public List<String> readFile(String path) {
        return readAllLines(get(path));
    }
}
