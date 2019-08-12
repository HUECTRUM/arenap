package com.meh.dto.internal.resources.art;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardArtDataDto {
    public Integer id;
    public Integer artid;

    public static CardArtDataDto empty() {
        return new CardArtDataDto();
    }
}
