package com.meh.dto.internal.resources.art;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtData {
    public Map<String, CardArtDataDto> cards;
}
