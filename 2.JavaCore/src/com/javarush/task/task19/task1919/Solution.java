package com.javarush.task.task19.task1919;

/*
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            HashMap<String, Double> salaries = new HashMap<>();
            while (reader.ready()) {
                String[] input = reader.readLine().split(" ");
                String name = input[0];
                Double salary = Double.parseDouble(input[1]);
                if (salaries.containsKey(name)) {
                    salaries.put(name, salaries.get(name) + salary);
                } else {
                    salaries.put(name, salary);
                }
            }
            List<String> names = salaries.keySet().stream().sorted().collect(Collectors.toList());
            for (String name : names) {
                System.out.println(name + " " + salaries.get(name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
