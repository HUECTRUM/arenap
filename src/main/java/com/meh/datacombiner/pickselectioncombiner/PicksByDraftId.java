package com.meh.datacombiner.pickselectioncombiner;

import com.google.common.collect.Multimap;
import com.meh.entity.SingleDraftPick;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PicksByDraftId {
    private Multimap<String, SingleDraftPick> picksByDraftId;
}
