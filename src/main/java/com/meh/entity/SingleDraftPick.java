package com.meh.entity;

import com.meh.dto.jsonimport.DraftPickImportDto;
import com.meh.dto.jsonimport.DraftSelectionImportDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class SingleDraftPick {
    private String draftId;
    private int packNumber;
    private int pickNumber;
    private List<Integer> alreadyPicked;
    private List<Integer> options;
    private Integer pickedCard;

    public static SingleDraftPick fromJsonData(DraftPickImportDto pick, DraftSelectionImportDto selection) {
        return SingleDraftPick
                .builder()
                .draftId(selection.draftId)
                .packNumber(selection.packNumber)
                .pickNumber(selection.pickNumber)
                .alreadyPicked(selection.pickedCards)
                .options(selection.draftPack)
                .pickedCard(Integer.parseInt(pick.params.cardId))
                .build();
    }
}
