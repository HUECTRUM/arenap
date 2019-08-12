package com.meh.dto.response.art;

import com.meh.dto.response.draft.DraftDataResponse;
import com.meh.entity.DraftData;
import com.meh.service.ArtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.meh.dto.response.draft.DraftDataWithArtDetails.fromData;
import static com.meh.utils.StreamUtils.mapList;

@Component
public class ArtReplacer {
    @Autowired
    private ArtProvider artProvider;

    public DraftDataResponse replaceIdsWithArts(List<DraftData> data) {
        return new DraftDataResponse(
                mapList(
                        data,
                        draftData -> fromData(draftData, artProvider.artReplacer())
                )
        );
    }
}
