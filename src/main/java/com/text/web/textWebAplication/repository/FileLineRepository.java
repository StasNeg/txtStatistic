package com.text.web.textWebAplication.repository;

import com.text.web.textWebAplication.model.file.FileLineModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileLineRepository extends CrudRepository<FileLineModel, Long> {

}
