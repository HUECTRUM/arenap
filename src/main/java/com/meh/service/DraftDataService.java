package com.meh.service;

import com.meh.dto.response.draft.DraftDataResponse;
import com.meh.entity.DraftData;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DraftDataService {
    List<DraftData> toDraftData(MultipartFile file);

    DraftDataResponse getDraftData(MultipartFile file);
}
