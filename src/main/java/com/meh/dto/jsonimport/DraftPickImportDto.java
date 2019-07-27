package com.meh.dto.jsonimport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.meh.datacombiner.draftid.PackPickKey;
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

    public PackPickKey getPackPickKey() {
        return new PackPickKey(
                params.getDraftId(),
                Integer.parseInt(params.getPackNumber()),
                Integer.parseInt(params.getPickNumber())
        );
    }
}
