package com.text.view;

import com.text.service.fileService.FileLoader;
import com.text.service.fileService.ShowFromMemory;

import java.util.LinkedList;
import java.util.List;

import static com.text.view.MenuHelper.getViewServise;

public class FileViewMenu implements ViewServise {
    private List<MenuItem> items = new LinkedList<>();

    FileViewMenu(ViewServise previous) {
        items.add(new MenuItem("Load data from file", 1, new FileLoader()));
        items.add(new MenuItem("Load data from folder", 2, new FileLoader(true)));
        items.add(new MenuItem("Get statistic all saved statistic", 3, new ShowFromMemory()));
        items.add(new MenuItem("Get statistic by filename", 4, new ShowFromMemory(true)));
        items.add(new MenuItem("Back to main menu", 5, previous));
    }

    @Override
    public void showMenu() {
        MenuHelper.showMenu(items);

    }

    @Override
    public ViewServise action(int choose) {
        ViewServise servise = getViewServise(choose, items, this);
        if (servise != null) return servise;
        return this;
    }
}
