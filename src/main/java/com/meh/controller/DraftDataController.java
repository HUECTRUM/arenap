package com.meh.controller;

import com.meh.dto.response.DraftDataResponse;
import com.meh.service.DraftDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class DraftDataController {
    @Autowired
    private DraftDataService service;

    @RequestMapping(path = "/draft", method = POST)
    public DraftDataResponse getDraftData(@RequestParam("file")MultipartFile file) {
        return service.getDraftData(file);
    }
}
