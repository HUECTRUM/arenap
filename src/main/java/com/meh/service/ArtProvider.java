package com.meh.service;

import java.util.function.Function;

public interface ArtProvider {
    Integer getCardArtId(Integer cardId);

    Function<Integer, String> artReplacer();
}
