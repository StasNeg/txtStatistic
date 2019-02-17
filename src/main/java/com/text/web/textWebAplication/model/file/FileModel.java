package com.text.web.textWebAplication.model.file;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.text.web.textWebAplication.model.AbstractBaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "file", uniqueConstraints = {@UniqueConstraint(columnNames = {"filename"},
        name = "filename_unique_idx")})
public class FileModel extends AbstractBaseEntity {

    @Column(name = "filename", nullable = false)
    @NotNull
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fileId", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    private List<FileLineModel> lines;

    public FileModel() {
    }

    public FileModel(Long id) {
        super(id);
    }

    public FileModel(@NotNull String name, List<FileLineModel> lines) {
        this.name = name;
        this.lines = lines;
    }

    public FileModel(Long id, @NotNull String name, List<FileLineModel> lines) {
        super(id);
        this.name = name;
        this.lines = lines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FileLineModel> getLines() {
        return lines;
    }

    public void setLines(List<FileLineModel> lines) {
        this.lines = lines;
    }
}
