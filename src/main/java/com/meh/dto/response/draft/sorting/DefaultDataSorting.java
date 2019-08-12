package com.meh.dto.response.draft.sorting;

import com.meh.entity.DraftData;
import com.meh.entity.SingleDraftPick;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

@Component
public class DefaultDataSorting implements DataResponseSorting {
    private static final Comparator<SingleDraftPick> DEFAULT_SORT_ORDER =
            comparing(SingleDraftPick::getPackNumber).thenComparing(SingleDraftPick::getPickNumber);

    public List<DraftData> sort(List<DraftData> data) {
        data.forEach(draft -> draft.getPicks().sort(DEFAULT_SORT_ORDER));
        return data;
    }
}
