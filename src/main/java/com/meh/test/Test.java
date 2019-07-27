package com.meh.test;

import com.meh.entity.DraftData;
import com.meh.parser.JsonArenaDraftDataParser;
import com.meh.service.DraftDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class Test {
    @Autowired
    private DraftDataService draftDataService;
    @Autowired
    private JsonArenaDraftDataParser parser;

    @EventListener(ApplicationReadyEvent.class)
    public void test() {
        List<DraftData> data = draftDataService.toDraftData("D:\\UTC_Log - 26.07.2019 22.23.21 - 1.htm");
        //PlainParsedDraftData data = parser.getParsedData("D:\\UTC_Log - 26.07.2019 22.23.21 - 1.htm");
        log.info("Parsed data {}", data);
    }
}
