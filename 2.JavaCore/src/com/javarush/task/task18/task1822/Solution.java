package com.javarush.task.task18.task1822;

/*
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedReader tableReader = new BufferedReader(new FileReader(reader.readLine()))) {
            while (tableReader.ready()) {
                String line = tableReader.readLine();
                if (line.startsWith(args[0])) {
                    if (Objects.equals(line.split(" ")[0], args[0])) {
                        System.out.println(line);
                    }
                }
            }
        }
    }
}
