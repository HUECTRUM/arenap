package com.meh.dto.jsonimport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.meh.datacombiner.draftid.PackPickKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DraftSelectionImportDto {
    public String playerId;
    public String eventName;
    public String draftId;
    public String draftStatus;

    public int packNumber;
    public int pickNumber;

    public List<Integer> draftPack;
    public List<Integer> pickedCards;

    public double requestUnits;

    public PackPickKey getPackPickKey() {
        return new PackPickKey(draftId, packNumber, pickNumber);
    }
}
