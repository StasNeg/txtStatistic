package com.text.web.textWebAplication.controller;

import com.text.web.textWebAplication.model.dto.TableDto;
import com.text.web.textWebAplication.model.file.FileModel;
import com.text.web.textWebAplication.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class DefaultController {

    private FileService service;

    @Autowired
    public DefaultController(FileService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        return "files";
    }


    @PostMapping(path = "/files")
    public @ResponseBody
    TableDto<FileModel> getAllFiles() {
        // This returns a JSON or XML with the users
        List<FileModel> files = service.getAll();
        return new TableDto<>("1", 1, 1, files);
    }


}
