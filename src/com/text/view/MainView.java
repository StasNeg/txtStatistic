package com.text.view;

import java.util.LinkedList;
import java.util.List;

import static com.text.view.MenuHelper.getViewServise;

public class MainView implements ViewServise {
    List<MenuItem> items = new LinkedList<>();

    {
        items.add(new MenuItem("Work with database", 1, new DataBaseViewMenu(this)));
        items.add(new MenuItem("Work with file", 2, new FileViewMenu(this)));
    }

    @Override
    public void showMenu() {
        MenuHelper.showMenu(items);
    }

    @Override
    public ViewServise action(int choose) {
        ViewServise servise = getViewServise(choose,items,this);
        if (servise != null) return servise;
        return this;
    }


}
