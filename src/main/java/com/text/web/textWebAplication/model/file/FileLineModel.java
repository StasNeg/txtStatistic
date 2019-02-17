package com.text.web.textWebAplication.model.file;

import com.text.web.textWebAplication.model.AbstractBaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "line_stat", uniqueConstraints = {@UniqueConstraint(columnNames = {"file_id","line_number"},
        name = "filename_line_number_unique_idx")})

public class FileLineModel extends AbstractBaseEntity {
//Calculate statistic for each line: longest word(symbols between 2 spaces), shortest word, line length, average word length.

    @Column(name = "line_number", nullable = false)
    @NotNull
    private Integer lineNumber;

    @Column(name = "longest_word", nullable = false)
    @NotNull
    private Integer longestWord;
    @Column(name = "horters_word", nullable = false)
    @NotNull
    private Integer shortersWord;
    @Column(name = "line_length", nullable = false)
    @NotNull
    private Integer length;

    @Column(name = "average_word_length", nullable = false)
    @NotNull
    private Double averageWordLength;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id", nullable = false)
    @NotNull
    private FileModel fileId;

    public FileLineModel() {
    }

    public FileLineModel(Long id) {
        super(id);
    }

    public FileLineModel(@NotNull Integer lineNumber, @NotNull Integer longestWord, @NotNull Integer shortersWord, @NotNull Integer length, @NotNull Double averageWordLength, @NotNull FileModel fileId) {
        this.lineNumber = lineNumber;
        this.longestWord = longestWord;
        this.shortersWord = shortersWord;
        this.length = length;
        this.averageWordLength = averageWordLength;
        this.fileId = fileId;
    }

    public FileLineModel(Long id, @NotNull Integer lineNumber, @NotNull Integer longestWord, @NotNull Integer shortersWord, @NotNull Integer length, @NotNull Double averageWordLength, @NotNull FileModel fileId) {
        super(id);
        this.lineNumber = lineNumber;
        this.longestWord = longestWord;
        this.shortersWord = shortersWord;
        this.length = length;
        this.averageWordLength = averageWordLength;
        this.fileId = fileId;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Integer getLongestWord() {
        return longestWord;
    }

    public void setLongestWord(Integer longestWord) {
        this.longestWord = longestWord;
    }

    public Integer getShortersWord() {
        return shortersWord;
    }

    public void setShortersWord(Integer shortersWord) {
        this.shortersWord = shortersWord;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Double getAverageWordLength() {
        return averageWordLength;
    }

    public void setAverageWordLength(Double averageWordLength) {
        this.averageWordLength = averageWordLength;
    }

    public FileModel getFileId() {
        return fileId;
    }

    public void setFileId(FileModel fileId) {
        this.fileId = fileId;
    }
}
