package com.meh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DraftData {
    private String draftId;
    private List<SingleDraftPick> picks;
}
