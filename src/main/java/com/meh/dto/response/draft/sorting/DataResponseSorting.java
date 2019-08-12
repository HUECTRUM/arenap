package com.meh.dto.response.draft.sorting;

import com.meh.entity.DraftData;

import java.util.List;

public interface DataResponseSorting {
    List<DraftData> sort(List<DraftData> data);
}
