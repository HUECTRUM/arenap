package com.meh.parser;

import com.meh.dto.internal.parserobjects.PlainParsedDraftData;

public interface DraftDataParser {
    PlainParsedDraftData getParsedData(String path);
}
