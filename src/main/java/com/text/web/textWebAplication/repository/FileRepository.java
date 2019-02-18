package com.text.web.textWebAplication.repository;

import com.text.web.textWebAplication.model.file.FileModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends CrudRepository<FileModel, Long> {
    @Override
    List<FileModel> findAll();
}
