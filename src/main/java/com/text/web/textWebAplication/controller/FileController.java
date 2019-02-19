package com.text.web.textWebAplication.controller;

import com.text.web.textWebAplication.model.file.FileLineModel;
import com.text.web.textWebAplication.model.file.FileModel;
import com.text.web.textWebAplication.service.FileLineService;
import com.text.web.textWebAplication.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class FileController {

    private FileService service;
    private FileLineService lineService;

    @Autowired
    public FileController(FileService service, FileLineService lineService) {
        this.service = service;
        this.lineService = lineService;
    }

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        return "files";
    }


    @GetMapping(path = "/files")
    public @ResponseBody
    List<FileModel> getAllFiles() {
        return service.getAll();
    }

    @GetMapping(path = "/files/statistic/{id}")
    public @ResponseBody
    List<FileLineModel> getStatistic(@PathVariable("id") String id) {
        return lineService.getAllByFileId(Long.parseLong(id));
    }


}
