package com.meh.parser;

import com.meh.dto.jsonimport.DraftPickImportDto;
import com.meh.dto.jsonimport.DraftSelectionImportDto;
import com.meh.reader.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

import static com.meh.utils.JsonUtils.deserlialize;
import static com.meh.utils.ParsingUtils.nextValidJson;
import static com.meh.utils.StreamUtils.mapList;

@Component
public class DraftDataParser {
    @Autowired
    private FileParser fileParser;
    @Autowired
    private FileReader reader;

    public List<DraftSelectionImportDto> getSelectionDtos(String path) {
        Function<List<String>, List<Integer>> indSelection = lines -> fileParser.selectionLines(lines);
        return parseJsonDataFromFile(path, indSelection, DraftSelectionImportDto.class);
    }

    public List<DraftPickImportDto> getPickDtos(String path) {
        Function<List<String>, List<Integer>> indSelection = lines -> fileParser.pickLines(lines);
        return parseJsonDataFromFile(path, indSelection, DraftPickImportDto.class);
    }

    private <T> List<T> parseJsonDataFromFile(String path, Function<List<String>, List<Integer>> indSelection, Class<T> clazz) {
        List<String> lines = reader.readFile(path);

        return mapList(mapList(
                indSelection.apply(lines),
                line -> nextValidJson(lines, line)),
                json -> deserlialize(json, clazz));
    }
}
