package com.meh.service;

import com.meh.entity.SingleDraftPick;

public interface ArtProvider {
    Integer getCardArtId(Integer cardId);

    void replacePickArts(SingleDraftPick pick);
}
