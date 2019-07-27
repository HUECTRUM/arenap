package com.meh.parser;

import com.meh.dto.internal.parserobjects.PlainParsedDraftData;
import org.springframework.web.multipart.MultipartFile;

public interface DraftDataParser {
    PlainParsedDraftData getParsedData(MultipartFile file);
}
