package com.meh.dto.internal.draftdata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DraftDataImportDto {
    private List<SinglePickDataImportDto> pickData;
}
