package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/*
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String[] inputLine = reader.readLine().split(" ");
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < inputLine.length - 3; i++) {
                    builder.append(inputLine[i]).append(" ");
                }
                String name = builder.toString().trim();
                GregorianCalendar calendar = new GregorianCalendar();
                int size = inputLine.length;
                calendar.set(
                        Integer.parseInt(inputLine[size - 1]),
                        Integer.parseInt(inputLine[size - 2])-1,
                        Integer.parseInt(inputLine[size - 3]));
                PEOPLE.add(new Person(name, calendar.getTime()));
            }
            PEOPLE.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
