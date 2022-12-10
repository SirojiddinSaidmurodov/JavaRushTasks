package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader firstFileReader = new BufferedReader(new FileReader(reader.readLine()));
            BufferedReader secondFileReader = new BufferedReader(new FileReader(reader.readLine()));

            while (firstFileReader.ready()) {
                allLines.add(firstFileReader.readLine());
            }
            while (secondFileReader.ready()) {
                forRemoveLines.add(secondFileReader.readLine());
            }
            reader.close();
            firstFileReader.close();
            secondFileReader.close();

            Solution solution = new Solution();
            solution.joinData();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if (new HashSet<>(allLines).containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
