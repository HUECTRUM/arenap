package com.meh.dto.response;

import com.meh.entity.DraftData;
import com.meh.service.ArtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ArtReplacer {
    @Autowired
    private ArtProvider artProvider;

    public DraftDataResponse replaceIdsWithArts(DraftDataResponse data) {
        data
                .draftData
                .stream()
                .map(DraftData::getPicks)
                .flatMap(Collection::stream)
                .forEach(x -> artProvider.replacePickArts(x));

        return data;
    }
}
