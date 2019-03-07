package com.text.view;

import com.text.view.item.MenuItem;
import com.text.view.utils.MenuHelper;

import java.util.LinkedList;
import java.util.List;

import static com.text.view.utils.MenuHelper.getViewServise;

public abstract class AbstractMenu implements ViewServise {
    protected List<MenuItem> items = new LinkedList<>();

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
