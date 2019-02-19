package com.text.web.textWebAplication.repository;

import com.text.web.textWebAplication.model.file.FileLineModel;
import com.text.web.textWebAplication.model.file.FileModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileLineRepository extends CrudRepository<FileLineModel, Long> {

    List<FileLineModel> findAllByFileId(FileModel fileId);
}
