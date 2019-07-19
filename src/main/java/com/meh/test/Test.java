package com.meh.test;

import com.meh.dto.jsonimport.DraftPickImportDto;
import com.meh.dto.jsonimport.DraftSelectionImportDto;
import com.meh.parser.DraftDataParser;
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
    private DraftDataParser parser;


    @EventListener(ApplicationReadyEvent.class)
    public void test() {
        List<DraftSelectionImportDto> selectionImportDtos = parser.getSelectionDtos("E:\\UTC_Log - 7-12-2019 10.07.54 PM - 1.htm");
        log.info("Selection dtos {}", selectionImportDtos);
        List<DraftPickImportDto> pickImportDtos = parser.getPickDtos("E:\\UTC_Log - 7-12-2019 10.07.54 PM - 1.htm");
        log.info("Pick dtos {}", pickImportDtos);
    }
}
