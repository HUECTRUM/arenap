package com.meh.datacombiner.draftid;

import com.meh.dto.jsonimport.DraftPickImportDto;
import com.meh.dto.jsonimport.DraftSelectionImportDto;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.meh.utils.StreamUtils.toIdentityValuesMap;

@Component
public class DraftIdCombinaer {
    public DataByDraftId sortByDraftId(List<DraftSelectionImportDto> selections, List<DraftPickImportDto> picks) {
        return new DataByDraftId(
                toIdentityValuesMap(picks, DraftPickImportDto::getDraftId),
                toIdentityValuesMap(selections, DraftSelectionImportDto::getDraftId)
        );
    }
}
