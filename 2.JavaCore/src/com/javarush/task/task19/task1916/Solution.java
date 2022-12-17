package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayList<String> origin = readFile(consoleReader.readLine());
            ArrayList<String> modded = readFile(consoleReader.readLine());
            int originIndex = 0, moddedIndex = 0;
            while (originIndex < origin.size() || moddedIndex < modded.size()) {
                if (originIndex == origin.size()) {
                    lines.add(new LineItem(Type.ADDED, modded.get(moddedIndex)));
                    originIndex++;
                    moddedIndex++;
                    continue;
                }
                if (moddedIndex == modded.size()) {
                    lines.add(new LineItem(Type.REMOVED, origin.get(originIndex)));
                    originIndex++;
                    moddedIndex++;
                    continue;
                }

                String originLine = origin.get(originIndex);
                String moddedLine = modded.get(moddedIndex);
                if (originLine.equals(moddedLine)) {
                    lines.add(new LineItem(Type.SAME, originLine));
                    originIndex++;
                    moddedIndex++;
                } else {
                    if (origin.get(originIndex + 1).equals(moddedLine)) {
                        lines.add(new LineItem(Type.REMOVED, originLine));
                        originIndex++;
                    } else {
                        lines.add(new LineItem(Type.ADDED, moddedLine));
                        moddedIndex++;
                    }
                }
            }
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> readFile(String origin) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(origin))) {
            while (fileReader.ready()) {
                strings.add(fileReader.readLine());
            }
        }
        return strings;
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return "LineItem{" +
                    "type=" + type.name() +
                    ", line='" + line + '\'' +
                    '}';
        }
    }
}
