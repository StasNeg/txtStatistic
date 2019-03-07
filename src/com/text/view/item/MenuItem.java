package com.text.view.item;

import com.text.service.ProcessingServise;
import com.text.view.ViewServise;

public class MenuItem {
    private final String title;
    private final int keyboardNumber;
    private ViewServise next;
    private ProcessingServise process;

    public MenuItem(String title, int keyboardNumber, ViewServise next) {
        this.title = title;
        this.keyboardNumber = keyboardNumber;
        this.next = next;
    }

    public MenuItem(String title, int keyboardNumber, ProcessingServise process) {
        this.title = title;
        this.keyboardNumber = keyboardNumber;
        this.process = process;
    }

    public String getTitle() {
        return title;
    }

    public int getKeyboardNumber() {
        return keyboardNumber;
    }

    public ViewServise getNext() {
        return next;
    }

    public void setNext(ViewServise next) {
        this.next = next;
    }

    public ProcessingServise getProcess() {
        return process;
    }

    public void setProcess(ProcessingServise process) {
        this.process = process;
    }
}
