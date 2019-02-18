package com.text.web.textWebAplication.controller;

import com.text.web.textWebAplication.service.FileLineService;
import com.text.web.textWebAplication.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class FileStatisticController {

    private FileService fileService;
    private FileLineService fileLineService;

    @Autowired
    public FileStatisticController(FileService fileService, FileLineService fileLineService) {
        this.fileService = fileService;
        this.fileLineService = fileLineService;
    }

    @RequestMapping(path = "/user/parking")
    public String welcome(Map<String, Object> model) {
        return "files";
    }
}
