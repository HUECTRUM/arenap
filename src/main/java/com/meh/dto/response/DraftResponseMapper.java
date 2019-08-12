package com.meh.dto.response;

import com.meh.dto.response.art.ArtReplacer;
import com.meh.dto.response.draft.DraftDataResponse;
import com.meh.dto.response.draft.sorting.DataResponseSorting;
import com.meh.entity.DraftData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DraftResponseMapper {
   @Autowired
   private ArtReplacer artReplacer;
   @Autowired
   private DataResponseSorting dataSorting;

    public DraftDataResponse toResponse(List<DraftData> data) {
        return artReplacer.replaceIdsWithArts(dataSorting.sort(data));
    }
}
