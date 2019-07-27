package com.meh.service;

import com.meh.entity.DraftData;

import java.util.List;

public interface DraftDataService {
    List<DraftData> toDraftData(String path);
}
