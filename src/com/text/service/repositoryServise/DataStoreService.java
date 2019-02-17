package com.text.service.repositoryServise;

import com.text.model.FileModel;
import com.text.repository.jdbcRepository.FileModelRepository;
import com.text.repository.jdbcRepository.LineModelRepository;
import com.text.service.ProcessingServise;

import static com.text.repository.memory.InMemoryStatisticStorage.getInMemoryStorage;


public class DataStoreService implements ProcessingServise {
    private final FileModelRepository fileRepository = new FileModelRepository();
    private final LineModelRepository lineModelRepository = new LineModelRepository();

    @Override
    public void process() {
        if (getInMemoryStorage().isEmpty()) {
            System.out.println("Storage is empty");
            return;
        }
        getInMemoryStorage().entrySet().forEach(entry -> {
            FileModel byName = fileRepository.getByName(entry.getKey());
            if (byName == null) {
                byName = new FileModel(entry.getKey());
                fileRepository.saveOrUpdate(byName);
                byName = fileRepository.getByName(entry.getKey());
            }
            final FileModel model = byName;
            if (entry.getValue().size() > 0 &&
                    lineModelRepository.hasByFileIdAndLineNumber(model.getId(), entry.getValue().get(0).getLineNumber())) {
                lineModelRepository.deleteByFileId(model.getId());
            }
            entry.getValue().forEach(line -> lineModelRepository.saveOrUpdate(model.getId(), line));
        });
        System.out.println("Data successfully saved");
    }
}
