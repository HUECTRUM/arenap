package com.meh.dto.response.draft;

import com.meh.entity.DraftData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Function;

import static com.meh.dto.response.draft.SinglePickWithArtData.from;
import static com.meh.utils.StreamUtils.mapList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DraftDataWithArtDetails {
    private String draftId;
    private List<SinglePickWithArtData> picks;

    public static DraftDataWithArtDetails fromData(DraftData data, Function<Integer, String> artReplacer) {
        return new DraftDataWithArtDetails(
                data.draftId,
                mapList(data.picks, pick -> from(pick, artReplacer))
        );
    }
}
