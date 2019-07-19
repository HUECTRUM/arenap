package com.meh.dto.jsonimport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DraftPickImportDto {
    private String jsonrpc;
    private String method;
    private DraftPickParamsDto params;
    private String id;
}
