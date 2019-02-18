package com.text.web.textWebAplication.service;

import com.text.web.textWebAplication.model.file.FileModel;
import com.text.web.textWebAplication.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private FileRepository repository;

    @Autowired
    public FileService(FileRepository repository) {
        this.repository = repository;
    }

    public List<FileModel> getAll() {
        return repository.findAll();
    }
}
