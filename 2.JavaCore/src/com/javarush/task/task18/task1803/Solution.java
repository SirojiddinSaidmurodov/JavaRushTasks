package com.javarush.task.task18.task1803;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        HashMap<Integer, Integer> map = new HashMap<>();

        FileInputStream inputStream = new FileInputStream(fileName);
        while (inputStream.available() > 0) {
            int input = inputStream.read();
            if (map.containsKey(input)) {
                map.put(input, map.get(input) + 1);
            } else {
                map.put(input, 1);
            }
        }
        inputStream.close();

        Integer max = Collections.max(map.values());
        for (Integer key : map.keySet()) {
            if (Objects.equals(map.get(key), max)) {
                System.out.print(key + " ");
            }
        }


    }
}
