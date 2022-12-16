package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static final Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        while (!input.equals("exit")) {
            new ReadThread(input);
            input = reader.readLine();
        }

    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
            this.start();
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            int[] charCount = new int[256];
            try (FileInputStream inputStream = new FileInputStream(fileName)) {
                while (inputStream.available() > 0) {
                    charCount[inputStream.read()]++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            int max = Arrays.stream(charCount).max().getAsInt();
            for (int i = 0; i < charCount.length; i++) {
                if (charCount[i] == max) {
                    synchronized (resultMap) {
                        resultMap.put(fileName, i);
                    }
                    return;
                }
            }
        }
    }
}
