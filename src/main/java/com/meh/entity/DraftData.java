package com.meh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DraftData {
    public String draftId;
    public List<SingleDraftPick> picks;
}
