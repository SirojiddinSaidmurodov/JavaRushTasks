package com.javarush.task.task18.task1808;

/*
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String inputFile = reader.readLine();
            String outputFile1 = reader.readLine();
            String outputFile2 = reader.readLine();

            try (FileInputStream inputStream = new FileInputStream(inputFile)) {
                FileOutputStream outputStream1 = new FileOutputStream(outputFile1);
                FileOutputStream outputStream2 = new FileOutputStream(outputFile2);

                int halfOfFile = (inputStream.available() + 1) / 2;
                int bytesCount = 0;
                while (inputStream.available() > 0) {
                    if (bytesCount < halfOfFile) {
                        outputStream1.write(inputStream.read());
                        bytesCount++;
                    } else {
                        outputStream2.write(inputStream.read());
                    }
                }
                outputStream1.close();
                outputStream2.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
