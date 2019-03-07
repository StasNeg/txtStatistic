package com.text.view;

import com.text.view.db.DataBaseViewMenu;
import com.text.view.file.FileViewMenu;
import com.text.view.item.MenuItem;

public class MainView extends AbstractMenu {

    public MainView() {
        items.add(new MenuItem("Work with database", 1, new DataBaseViewMenu(this)));
        items.add(new MenuItem("Work with file", 2, new FileViewMenu(this)));
    }
}
