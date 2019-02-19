package com.text.web.textWebAplication.service;

import com.text.web.textWebAplication.model.file.FileLineModel;
import com.text.web.textWebAplication.model.file.FileModel;
import com.text.web.textWebAplication.repository.FileLineRepository;
import com.text.web.textWebAplication.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FileLineService {
    private FileLineRepository repository;
    private FileRepository fileRepository;

    @Autowired
    public FileLineService(FileLineRepository repository, FileRepository fileRepository) {
        this.repository = repository;
        this.fileRepository = fileRepository;
    }

    public List<FileLineModel> getAllByFileId(Long fileId) {
        FileModel file = fileRepository.findById(fileId).orElse(null);
        return Objects.isNull(file)?new ArrayList<>():repository.findAllByFileId(file);
    }
}
