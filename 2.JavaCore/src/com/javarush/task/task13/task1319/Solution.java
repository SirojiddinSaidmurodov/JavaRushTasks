package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String path = reader.readLine();
            ArrayList<String> text = new ArrayList<>();
            String temp;
            while (!"exit".equals(temp = reader.readLine())) {
                text.add(temp);
            }
            text.add("exit");
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for (String line : text) {
                writer.write(line + "\n");
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
