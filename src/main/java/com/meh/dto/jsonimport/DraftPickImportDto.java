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
    public String jsonrpc;
    public String method;
    public DraftPickParamsDto params;
    public String id;

    public PackPickKey getPackPickKey() {
        return new PackPickKey(
                params.draftId,
                Integer.parseInt(params.packNumber),
                Integer.parseInt(params.pickNumber)
        );
    }
}
