package com.meh.dto.internal.parserobjects;

import com.meh.dto.jsonimport.DraftPickImportDto;
import com.meh.dto.jsonimport.DraftSelectionImportDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PlainParsedDraftData {
    public List<DraftSelectionImportDto> selections;
    public List<DraftPickImportDto> picks;
}
