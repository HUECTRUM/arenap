package com.meh.parser;

import com.meh.dto.internal.parserobjects.PlainParsedDraftData;
import com.meh.dto.jsonimport.DraftPickImportDto;
import com.meh.dto.jsonimport.DraftSelectionImportDto;
import com.meh.parser.internalparsing.JsonFileParser;
import com.meh.parser.internalparsing.StartingLinesSelector;
import com.meh.reader.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.function.Function;

import static com.meh.utils.JsonUtils.deserialize;
import static com.meh.utils.StreamUtils.filterList;
import static com.meh.utils.StreamUtils.mapList;

@Component
public class JsonArenaDraftDataParser implements DraftDataParser {
    private static final String DRAFT_COMPLETE_STATUS = "Draft.Complete";

    @Autowired
    private StartingLinesSelector startingLinesSelector;
    @Autowired
    private FileReader reader;
    @Autowired
    private JsonFileParser fileParser;

    @Override
    public PlainParsedDraftData getParsedData(MultipartFile file) {
        return new PlainParsedDraftData(
                filterList(getSelectionDtos(file), s -> !s.getDraftStatus().equals(DRAFT_COMPLETE_STATUS)),
                getPickDtos(file)
        );
    }

    private List<DraftSelectionImportDto> getSelectionDtos(MultipartFile file) {
        return parseJsonDataFromFile(
                file,
                lines -> startingLinesSelector.selectionLines(lines),
                DraftSelectionImportDto.class
        );
    }

    private List<DraftPickImportDto> getPickDtos(MultipartFile file) {
        return parseJsonDataFromFile(
                file,
                lines -> startingLinesSelector.pickLines(lines),
                DraftPickImportDto.class
        );
    }

    private <T> List<T> parseJsonDataFromFile(
            MultipartFile file, Function<List<String>, List<Integer>> indSelection, Class<T> clazz) {
        List<String> lines = reader.readFile(file);

        return mapList(mapList(
                indSelection.apply(lines),
                line -> fileParser.nextValidJson(lines, line)),
                json -> deserialize(json, clazz));
    }
}
