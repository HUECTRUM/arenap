package com.meh.datacombiner.draftid;

import com.meh.dto.jsonimport.DraftPickImportDto;
import com.meh.dto.jsonimport.DraftSelectionImportDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class DataByUniqueKey {
    private Map<PackPickKey, DraftPickImportDto> picks;
    private Map<PackPickKey, DraftSelectionImportDto> selections;
}
