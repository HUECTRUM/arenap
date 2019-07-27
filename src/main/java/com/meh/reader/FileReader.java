package com.meh.reader;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.toList;

@Component
public class FileReader {
    @SneakyThrows
    public List<String> readFile(MultipartFile file) {
        return new BufferedReader(new InputStreamReader(file.getInputStream(), UTF_8)).lines().collect(toList());
    }
}
