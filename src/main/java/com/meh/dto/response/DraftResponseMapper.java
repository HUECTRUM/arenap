package com.meh.dto.response;

import com.meh.entity.DraftData;
import com.meh.entity.SingleDraftPick;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Comparator.comparing;

@Component
public class DraftResponseMapper {
    public DraftDataResponse toResponse(List<DraftData> data) {
        data.forEach(draft -> draft.getPicks().sort(
                comparing(SingleDraftPick::getPackNumber).thenComparing(SingleDraftPick::getPickNumber)
        ));
        return new DraftDataResponse(data);
    }
}
