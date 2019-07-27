package com.meh.dto.response;

import com.meh.entity.DraftData;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DraftDataResponse {
    List<DraftData> draftData;
}
