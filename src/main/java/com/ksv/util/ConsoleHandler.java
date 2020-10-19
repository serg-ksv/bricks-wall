package com.ksv.util;

import com.ksv.service.impl.FileServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleHandler {
    private static final Pattern DATA_PATTERN = Pattern.compile("([0-9]*\\)*\\(*\\s*)+");

    public String getUsersChoice() {
        var in = new Scanner(System.in);
        return in.next();
    }

    public List<String> getData(String choice) {
        List<String> data = new ArrayList<>();
        switch (choice) {
            case "1": {
                System.out.println("Please enter the file path: ");
                var scanner = new Scanner(System.in);
                var filePath = scanner.nextLine();
                var fileService = new FileServiceImpl();
                data = fileService.readFile(filePath);
                break;
            }
            case "2": {
                System.out.println("Please enter the data: ");
                var scanner = new Scanner(System.in);
                String line;
                while (!(line = scanner.nextLine()).isEmpty()) {
                    data.add(line);
                }
                break;
            }
            default: System.exit(0);
        }
        for (var line : data) {
            if (!isCorrectDataFormat(line)) {
                throw new IllegalArgumentException("Incorrect data!");
            }
        }
        return data;
    }

    public void showMenu() {
        var menu = "Please make your choice:\n"
                + "1 - Read from file\n"
                + "2 – Read from standard input\n";
        System.out.println(menu);
    }

    public void printAnswer(boolean isEnoughBricks) {
        System.out.println(isEnoughBricks
                ? "yes"
                : "no");
    }

    private boolean isCorrectDataFormat(String data) {
        return DATA_PATTERN.matcher(data).matches();
    }
}
