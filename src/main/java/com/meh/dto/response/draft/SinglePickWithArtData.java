package com.meh.dto.response.draft;

import com.meh.entity.SingleDraftPick;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Function;

import static com.meh.utils.StreamUtils.mapList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SinglePickWithArtData {
    public String draftId;
    public int packNumber;
    public int pickNumber;
    public List<String> alreadyPicked;
    public List<String> options;
    public String pickedCard;

    public static SinglePickWithArtData from(SingleDraftPick pick, Function<Integer, String> artReplacer) {
        return SinglePickWithArtData
                .builder()
                .draftId(pick.draftId)
                .packNumber(pick.packNumber)
                .pickNumber(pick.pickNumber)
                .alreadyPicked(mapList(pick.alreadyPicked, artReplacer))
                .options(mapList(pick.options, artReplacer))
                .pickedCard(artReplacer.apply(pick.pickedCard))
                .build();
    }
}
