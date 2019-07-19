package com.meh.dto.jsonimport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DraftSelectionImportDto {
    private String playerId;
    private String eventName;
    private String draftId;
    private String draftStatus;

    private int packNumber;
    private int pickNumber;

    private List<Integer> draftPack;
    private List<Integer> pickedCards;

    private double requestUnits;
}
