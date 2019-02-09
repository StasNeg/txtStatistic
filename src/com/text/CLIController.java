package com.text;

import com.text.view.MainView;
import com.text.view.ViewServise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLIController {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedReader getReader(){
        return reader;
    }

    public static void main(String[] args) throws IOException {
        String message = "";
        ViewServise menu = new MainView();
        while (true) {
            try {
                menu.showMenu();
                System.out.println("------For exit input 'exit'--------");
                message = reader.readLine();
                if (message.equalsIgnoreCase("exit")) break;
                menu = menu.action(Integer.parseInt(message));
            } catch (NumberFormatException e) {
                System.out.println("Wrong data input, repeat please");
            }
        }
        reader.close();
    }
}

