package com.text.view;

import com.text.service.repositoryServise.DataStoreService;

import java.util.LinkedList;
import java.util.List;

import static com.text.view.MenuHelper.getViewServise;

public class DataBaseViewMenu implements ViewServise {
    List<MenuItem> items = new LinkedList<>();
    public DataBaseViewMenu(ViewServise previous) {
        items.add(new MenuItem("Save file statistic to database", 1, new DataStoreService()));
        items.add(new MenuItem("Back to main menu", 2, previous));
    }
    @Override
    public void showMenu() {
        MenuHelper.showMenu(items);
    }
    @Override
    public ViewServise action(int choose) {
        ViewServise servise = getViewServise(choose, items,this);
        if (servise != null) return servise;
        return this;
    }
}
