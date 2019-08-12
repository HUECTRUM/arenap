package com.meh.service.impl;

import com.meh.datacombiner.DraftDataCombiner;
import com.meh.dto.response.DraftResponseMapper;
import com.meh.dto.response.draft.DraftDataResponse;
import com.meh.entity.DraftData;
import com.meh.parser.JsonArenaDraftDataParser;
import com.meh.service.DraftDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ArenaLogsDraftDataService implements DraftDataService {
    @Autowired
    private JsonArenaDraftDataParser parser;
    @Autowired
    private DraftDataCombiner combiner;
    @Autowired
    private DraftResponseMapper responseMapper;

    @Override
    public List<DraftData> toDraftData(MultipartFile file) {
        return combiner.toDraftData(parser.getParsedData(file));
    }

    @Override
    public DraftDataResponse getDraftData(MultipartFile file) {
        return responseMapper.toResponse(toDraftData(file));
    }
}
