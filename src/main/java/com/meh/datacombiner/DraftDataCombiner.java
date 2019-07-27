package com.meh.datacombiner;

import com.google.common.collect.Multimap;
import com.meh.datacombiner.pickselectioncombiner.DraftPickSelectionCombiner;
import com.meh.dto.internal.parserobjects.PlainParsedDraftData;
import com.meh.entity.DraftData;
import com.meh.entity.SingleDraftPick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.meh.utils.StreamUtils.mapList;

@Component
public class DraftDataCombiner {
    @Autowired
    private DraftPickSelectionCombiner pickSelectionCombiner;

    public List<DraftData> toDraftData(PlainParsedDraftData plainData) {
        Multimap<String, SingleDraftPick> picksByDraftId = pickSelectionCombiner.toPicks(plainData).getPicksByDraftId();
        return mapList(
                picksByDraftId.keySet(),
                draftId -> new DraftData(draftId, new ArrayList<>(picksByDraftId.get(draftId)))
        );
    }
}
