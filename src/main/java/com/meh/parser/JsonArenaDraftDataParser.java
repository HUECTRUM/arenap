package com.meh.parser;

import com.meh.dto.internal.parserobjects.PlainParsedDraftData;
import com.meh.dto.jsonimport.DraftPickImportDto;
import com.meh.dto.jsonimport.DraftSelectionImportDto;
import com.meh.parser.internalparsing.JsonFileParser;
import com.meh.parser.internalparsing.StartingLinesSelector;
import com.meh.reader.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

import static com.meh.utils.JsonUtils.deserialize;
import static com.meh.utils.StreamUtils.mapList;

@Component
public class JsonArenaDraftDataParser implements DraftDataParser {
    @Autowired
    private StartingLinesSelector startingLinesSelector;
    @Autowired
    private FileReader reader;
    @Autowired
    private JsonFileParser fileParser;

    @Override
    public PlainParsedDraftData getParsedData(String path) {
        return new PlainParsedDraftData(getSelectionDtos(path), getPickDtos(path));
    }

    private List<DraftSelectionImportDto> getSelectionDtos(String path) {
        return parseJsonDataFromFile(
                path,
                lines -> startingLinesSelector.selectionLines(lines),
                DraftSelectionImportDto.class
        );
    }

    private List<DraftPickImportDto> getPickDtos(String path) {
        return parseJsonDataFromFile(
                path,
                lines -> startingLinesSelector.pickLines(lines),
                DraftPickImportDto.class
        );
    }

    private <T> List<T> parseJsonDataFromFile(String path, Function<List<String>, List<Integer>> indSelection, Class<T> clazz) {
        List<String> lines = reader.readFile(path);

        return mapList(mapList(
                indSelection.apply(lines),
                line -> fileParser.nextValidJson(lines, line)),
                json -> deserialize(json, clazz));
    }
}
