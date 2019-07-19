package com.meh.parser;

import com.meh.utils.ParsingUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FileParser {
    private static final String SELECTION_START = "<== Draft.MakePick";
    private static final String PICK_START = "==> Draft.MakePick";

    public List<Integer> selectionLines(List<String> lines) {
        return ParsingUtils.startIndexes(lines, SELECTION_START);
    }

    public List<Integer> pickLines(List<String> lines) {
        return ParsingUtils.startIndexes(lines, PICK_START);
    }
}
