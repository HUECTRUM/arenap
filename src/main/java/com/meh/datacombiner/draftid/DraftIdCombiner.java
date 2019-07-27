package com.meh.datacombiner.draftid;

import com.meh.dto.internal.parserobjects.PlainParsedDraftData;
import com.meh.dto.jsonimport.DraftPickImportDto;
import com.meh.dto.jsonimport.DraftSelectionImportDto;
import org.springframework.stereotype.Component;

import static com.google.common.collect.Maps.uniqueIndex;

@Component
public class DraftIdCombiner {
    public DataByUniqueKey sortByDraftKey(PlainParsedDraftData data) {
        return new DataByUniqueKey(
                uniqueIndex(data.getPicks(), DraftPickImportDto::getPackPickKey),
                uniqueIndex(data.getSelections(), DraftSelectionImportDto::getPackPickKey)
        );
    }
}
