package com.text.view.db;

import com.text.service.repositoryServise.DataStoreService;
import com.text.view.AbstractMenu;
import com.text.view.item.MenuItem;
import com.text.view.ViewServise;

public class DataBaseViewMenu extends AbstractMenu {

    public DataBaseViewMenu(ViewServise previous) {
        items.add(new MenuItem("Save file statistic to database", 1, new DataStoreService()));
        items.add(new MenuItem("Back to main menu", 2, previous));
    }
}
