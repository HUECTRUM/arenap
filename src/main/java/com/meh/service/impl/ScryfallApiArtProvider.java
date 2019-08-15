package com.meh.service.impl;

import com.google.common.io.Resources;
import com.meh.dto.internal.resources.art.ArtData;
import com.meh.service.ArtProvider;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.function.Function;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.io.Resources.getResource;
import static com.meh.dto.internal.resources.art.CardArtDataDto.empty;
import static com.meh.utils.JsonUtils.deserialize;
import static java.lang.String.valueOf;

@Service
@Slf4j
public class ScryfallApiArtProvider implements ArtProvider {
    private static final String CARD_INFO_DB_PATH = "card_collection.json";

    private static ArtData artData;

    @Override
    public Integer getCardArtId(Integer cardId) {
        return artData.cards
                .getOrDefault(valueOf(cardId), empty())
                .artid;
    }

    @Override
    public Function<Integer, String> artReplacer() {
        return id -> artData.cards.getOrDefault(valueOf(id), empty()).images.normal;
    }

    @PostConstruct
    @SneakyThrows
    private void readResource() {
        artData = deserialize(
                Resources.toString(getResource(CARD_INFO_DB_PATH), UTF_8),
                ArtData.class
        );
    }
}
