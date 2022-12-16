package com.javarush.task.task18.task1824;

/*
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String file = reader.readLine();
                try (FileReader fileReader = new FileReader(file)) {

                } catch (FileNotFoundException e) {
                    System.out.println(file);
                    return;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
