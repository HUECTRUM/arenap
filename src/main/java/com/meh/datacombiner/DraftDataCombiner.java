package com.meh.datacombiner;

import com.meh.dto.jsonimport.DraftPickImportDto;
import com.meh.dto.jsonimport.DraftSelectionImportDto;
import com.meh.utils.StreamUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.meh.utils.StreamUtils.toIdentityValuesMap;
import static java.util.stream.Collectors.toMap;

@Component
public class DraftDataCombiner {

    private DataByDraftId sortByDraftId(List<DraftSelectionImportDto> selections, List<DraftPickImportDto> picks) {
        return new DataByDraftId(
                toIdentityValuesMap(picks, DraftPickImportDto::getDraftId),
                toIdentityValuesMap(selections, DraftSelectionImportDto::getDraftId)
        );
    }

    @Data
    @AllArgsConstructor
    private class DataByDraftId {
        private Map<String, DraftPickImportDto> picks;
        private Map<String, DraftSelectionImportDto> selections;
    }
}
