package com.text.model;

import java.util.List;

public class FileModel extends AbstractBase {
    private String name;
    private List<FileLineModel> fileLines;

    public FileModel(String name) {
        this.name = name;
    }

    public FileModel(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FileLineModel> getFileLines() {
        return fileLines;
    }

    public void setFileLines(List<FileLineModel> fileLines) {
        this.fileLines = fileLines;
    }
}
