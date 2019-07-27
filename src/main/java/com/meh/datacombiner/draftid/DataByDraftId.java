package com.meh.datacombiner.draftid;

import com.meh.dto.jsonimport.DraftPickImportDto;
import com.meh.dto.jsonimport.DraftSelectionImportDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class DataByDraftId {
    private Map<String, DraftPickImportDto> picks;
    private Map<String, DraftSelectionImportDto> selections;
}
