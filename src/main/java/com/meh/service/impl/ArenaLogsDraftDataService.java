package com.meh.service.impl;

import com.meh.datacombiner.DraftDataCombiner;
import com.meh.entity.DraftData;
import com.meh.parser.JsonArenaDraftDataParser;
import com.meh.service.DraftDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArenaLogsDraftDataService implements DraftDataService {
    @Autowired
    private JsonArenaDraftDataParser parser;
    @Autowired
    private DraftDataCombiner combiner;

    @Override
    public List<DraftData> toDraftData(String path) {
        return combiner.toDraftData(parser.getParsedData(path));
    }
}
