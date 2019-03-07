package com.text.view.utils;

import com.text.service.ProcessingServise;
import com.text.view.ViewServise;
import com.text.view.item.MenuItem;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MenuHelper {
    public static void showMenu(List<MenuItem> items) {
        items.forEach(item -> System.out.println(String.format("Input %d for : %s", item.getKeyboardNumber(), item.getTitle())));
    }
    public static ViewServise getAction(int choose, List<MenuItem> items) {
        Map<Integer, ViewServise> serviceMap = items.stream().filter(item->item.getNext()!=null).collect(Collectors.toMap(item -> item.getKeyboardNumber(), item -> item.getNext()));
        return serviceMap.get(choose);
    }
    public static ProcessingServise getProcess(int choose, List<MenuItem> items) {
        Map<Integer, ProcessingServise> serviceMap = items.stream().filter(item->item.getProcess()!=null).collect(Collectors.toMap(item -> item.getKeyboardNumber(), item -> item.getProcess()));
        return serviceMap.get(choose);
    }

    public static ViewServise getViewServise(int choose, List<MenuItem> items, ViewServise current) {
        ViewServise servise = MenuHelper.getAction(choose, items);
        if (servise != null) {
            return servise;
        }
        ProcessingServise processingServise = MenuHelper.getProcess(choose, items);
        if (processingServise != null) {
            processingServise.process();
        }else{
            System.out.println("You input wrong symbol");
        }
        return current;
    }
}
