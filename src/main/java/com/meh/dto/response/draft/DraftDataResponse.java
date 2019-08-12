package com.meh.dto.response.draft;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DraftDataResponse {
    public List<DraftDataWithArtDetails> draftData;
}
