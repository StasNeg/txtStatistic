package com.text.view.file;

import com.text.service.fileService.FileLoader;
import com.text.service.fileService.ShowFromMemory;
import com.text.view.AbstractMenu;
import com.text.view.item.MenuItem;
import com.text.view.ViewServise;

public class FileViewMenu extends AbstractMenu {


    public FileViewMenu(ViewServise previous) {
        items.add(new MenuItem("Load data from file", 1, new FileLoader()));
        items.add(new MenuItem("Load data from folder", 2, new FileLoader(true)));
        items.add(new MenuItem("Get statistic all saved statistic", 3, new ShowFromMemory()));
        items.add(new MenuItem("Get statistic by filename", 4, new ShowFromMemory(true)));
        items.add(new MenuItem("Back to main menu", 5, previous));
    }

}
