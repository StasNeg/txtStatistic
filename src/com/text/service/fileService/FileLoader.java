package com.text.service.fileService;

import com.text.model.FileLineModel;
import com.text.model.FileModel;
import com.text.repository.memory.InMemoryStatisticStorage;
import com.text.service.ProcessingServise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static com.text.CLIController.getReader;
import static java.util.stream.Collectors.toList;


public class FileLoader implements ProcessingServise {
    private InMemoryStatisticStorage storage = new InMemoryStatisticStorage();
    boolean isFromDirectory;

    public FileLoader() {
    }

    public FileLoader(boolean isFromDirectory) {
        this.isFromDirectory = isFromDirectory;
    }

    @Override
    public void process() {
        String fileName = "";
        try {
            System.out.println("input path to folder or to file : ");
            fileName = getReader().readLine();
            if (isFromDirectory) {
                Files.walk(Paths.get(fileName))
                        .filter(s -> s.toString().endsWith(".txt"))
                        .map(path -> path.toAbsolutePath().toString())
                        .sorted()
                        .forEach(file -> {
                            try {
                                saveToMemory(file, String.format("file %s was successfully processed and save in Memory", file));
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                        });
            } else {
                saveToMemory(fileName, "file was successfully processed and save in Memory");
            }
        } catch (Exception e) {
            System.out.println("You have to input new path :" + e.getLocalizedMessage());
        }
    }

    private void saveToMemory(String file, String format) throws IOException {
        List<FileLineModel> statisticFromFile = getStatisticFromFile(new FileModel(file));
        storage.getInMemoryStorage().put(file, statisticFromFile);
        System.out.println(format);
    }

    public List<FileLineModel> getStatisticFromFile(FileModel fileModel) throws IOException {
        List<String> lines = Files.lines(Paths.get(fileModel.getName())).collect(toList());
        List<FileLineModel> lineModels = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            String[] splitted = lines.get(i).split("\\s+");
            int max = Stream.of(splitted).max(Comparator.comparingInt(String::length)).orElse("").length();
            int min = Stream.of(splitted).min(Comparator.comparingInt(String::length)).orElse("").length();
            double average = Stream.of(splitted).mapToInt(String::length).average().orElse(0d);
            lineModels.add(new FileLineModel(i, fileModel.getId() == null ? 0 : fileModel.getId(), max, min, lines.get(i).length(), average));
        }
        return lineModels;
    }

    public List<FileLineModel> getStatisticFromFileWithoutStream(FileModel fileModel) throws IOException {
        List<String> lines = Files.lines(Paths.get(fileModel.getName())).collect(toList());
        List<FileLineModel> lineModels = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            String[] splitted = lines.get(i).split("\\s+");
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            double average = 0;
            for (int j = 0; j < splitted.length; j++) {

                if (max < splitted[j].length()) {
                    max = splitted[j].length();
                }
                if (min > splitted[j].length()) {
                    min = splitted[j].length();
                }
                average += splitted[j].length();
            }
            lineModels.add(new FileLineModel(i, fileModel.getId() == null ? 0 : fileModel.getId(), max, min, lines.get(i).length(), average/splitted.length));
        }
        return lineModels;
    }
}
