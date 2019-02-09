package com.text.model;

public class FileLineModel extends AbstractBase{
//Calculate statistic for each line: longest word(symbols between 2 spaces), shortest word, line length, average word length.
    private Integer lineNumber;
    private Integer fileId;
    private Integer longestWord;
    private Integer shortersWord;
    private Integer length;
    private Double averageWordLength;

    public FileLineModel(Integer lineNumber, Integer fileId, Integer longestWord, Integer shortersWord, Integer length, Double averageWordLength) {
        this.lineNumber = lineNumber;
        this.fileId = fileId;
        this.longestWord = longestWord;
        this.shortersWord = shortersWord;
        this.length = length;
        this.averageWordLength = averageWordLength;
    }

    public FileLineModel(Integer id, Integer lineNumber, Integer fileId, Integer longestWord, Integer shortersWord, Integer length, Double averageWordLength) {
        super(id);
        this.lineNumber = lineNumber;
        this.fileId = fileId;
        this.longestWord = longestWord;
        this.shortersWord = shortersWord;
        this.length = length;
        this.averageWordLength = averageWordLength;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
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

    @Override
    public String toString() {
        return "{" +
                "lineNumber=" + lineNumber +
//                ", fileId=" + fileId +
                ", longestWord=" + longestWord +
                ", shortersWord=" + shortersWord +
                ", length=" + length +
                ", averageWordLength=" + averageWordLength +
//                ", id=" + id +
                '}';
    }
}
