package com.meh.parser.internalparsing;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

import static com.meh.utils.StreamUtils.concatLists;
import static java.util.stream.Collectors.toList;

@Component
public class StartingLinesSelector {
    private static final String DRAFT_SELECTION_START = "<== Draft.DraftStatus";
    private static final String SELECTION_START = "<== Draft.MakePick";
    private static final String PICK_START = "==> Draft.MakePick";

    //TODO: can be slightly optimized
    public List<Integer> selectionLines(List<String> lines) {
        return concatLists(startIndexes(lines, DRAFT_SELECTION_START), startIndexes(lines, SELECTION_START));
    }

    public List<Integer> pickLines(List<String> lines) {
        return startIndexes(lines, PICK_START);
    }

    private List<Integer> startIndexes(List<String> lines, String lineStart) {
        return IntStream
                .range(0, lines.size() - 1)
                .filter(i -> lines.get(i).startsWith(lineStart))
                .boxed()
                .collect(toList());
    }
}
