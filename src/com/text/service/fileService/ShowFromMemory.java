package com.text.service.fileService;

import com.text.model.FileLineModel;
import com.text.repository.memory.InMemoryStatisticStorage;
import com.text.service.ProcessingServise;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.text.CLIController.getReader;

public class ShowFromMemory implements ProcessingServise {
    private boolean notAll;

    public ShowFromMemory() {
    }

    public ShowFromMemory(boolean notAll) {
        this.notAll = notAll;
    }

    @Override
    public void process() {
        Map<String, List<FileLineModel>> map = InMemoryStatisticStorage.getInMemoryStorage();
        if (notAll) {
            try {
                System.out.println("Input required filename :");
                String filename = getReader().readLine();
                if (map.get(filename) == null) {
                    System.out.println("Filename don't find in storage");
                } else {
                    printEntry(filename, map.get(filename));
                }
            } catch (IOException e) {

            }
        } else {
            if(map.size()>0) {
                map.entrySet().forEach(entry -> {
                    printEntry(entry.getKey(), entry.getValue());
                });
            }else{
                System.out.println("Storage is empty");
            }
        }
    }

    private void printEntry(String filename, List<FileLineModel> entry) {
        System.out.println(filename + " contains " + entry.size() + "  lines");
        System.out.println("Show lines statistics:");
        entry.forEach(System.out::println);
        System.out.println("---------------------------------");
    }
}
