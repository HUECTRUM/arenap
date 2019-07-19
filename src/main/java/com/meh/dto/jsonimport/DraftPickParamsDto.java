package com.meh.dto.jsonimport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DraftPickParamsDto {
    private String draftId;
    private String cardId;
    private String packNumber;
    private String pickNumber;
}
