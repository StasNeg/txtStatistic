package com.text.repository.memory;

import com.text.model.FileLineModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryStatisticStorage {
    private static final Map<String, List<FileLineModel>> inMemoryStorage = new HashMap<>();
    public static Map<String, List<FileLineModel>> getInMemoryStorage() {
        return inMemoryStorage;
    }
}
