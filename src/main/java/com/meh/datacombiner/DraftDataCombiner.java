package com.meh.datacombiner;

import com.meh.dto.jsonimport.DraftPickImportDto;
import com.meh.dto.jsonimport.DraftSelectionImportDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DraftDataCombiner {

    private DataByDraftId sortByDraftId(List<DraftSelectionImportDto> selections, List<DraftPickImportDto> picks) {
        return null;
    }

    @Data
    @AllArgsConstructor
    private class DataByDraftId {
        private Map<String, DraftPickImportDto> picks;
        private Map<String, DraftSelectionImportDto> selections;
    }
}
