package com.meh.dto.response;

import com.meh.dto.response.art.ArtReplacer;
import com.meh.entity.DraftData;
import com.meh.entity.SingleDraftPick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Comparator.comparing;

@Component
public class DraftResponseMapper {
   @Autowired
   private ArtReplacer artReplacer;

    public DraftDataResponse toResponse(List<DraftData> data) {
        data.forEach(draft -> draft.getPicks().sort(
                comparing(SingleDraftPick::getPackNumber).thenComparing(SingleDraftPick::getPickNumber)
        ));
        return artReplacer.replaceIdsWithArts(new DraftDataResponse(data));
    }
}
