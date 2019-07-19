package com.meh.reader;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
@Data
@Slf4j
public class FileReader {
    public List<String> readFile(String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            log.error("Unable to read file at {}", path, e);
            throw new RuntimeException(e);
        }
    }
}
