package com.meh.dto.internal.draftdata;

import com.meh.dto.jsonimport.DraftPickImportDto;
import com.meh.dto.jsonimport.DraftSelectionImportDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SinglePickDataImportDto {
    private DraftSelectionImportDto selectionInfo;
    private DraftPickImportDto pickInfo;
    private PickDataKey key;
}
