package com.meh.datacombiner.pickselectioncombiner;

import com.meh.datacombiner.draftid.DataByUniqueKey;
import com.meh.datacombiner.draftid.DraftIdCombiner;
import com.meh.dto.internal.parserobjects.PlainParsedDraftData;
import com.meh.entity.SingleDraftPick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.collect.Multimaps.index;
import static com.meh.entity.SingleDraftPick.fromJsonData;
import static com.meh.utils.StreamUtils.mapList;

@Component
public class DraftPickSelectionCombiner {
    @Autowired
    private DraftIdCombiner draftIdCombiner;

    public PicksByDraftId toPicks(PlainParsedDraftData data) {
        DataByUniqueKey dataByKey = draftIdCombiner.sortByDraftKey(data);
        return new PicksByDraftId(index(toEntityPick(dataByKey), SingleDraftPick::getDraftId));
    }

    private List<SingleDraftPick> toEntityPick(DataByUniqueKey data) {
        return mapList(
                data.getSelections().keySet(),
                key -> fromJsonData(data.getPicks().get(key), data.getSelections().get(key))
        );
    }
}
