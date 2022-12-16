package com.javarush.task.task18.task1819;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String source = reader.readLine();
        String target = reader.readLine();
        byte[] secondPart;

        try (FileInputStream stream = new FileInputStream(source)) {
            secondPart = new byte[stream.available()];
            if (secondPart.length != stream.read(secondPart)) {
                throw new IOException("File wasn't copied at all");
            }
        }
        try (FileInputStream sourceStream = new FileInputStream(target)) {
            FileOutputStream outputStream = new FileOutputStream(source);
            while (sourceStream.available() > 0) {
                outputStream.write(sourceStream.read());
            }
            outputStream.write(secondPart);
            outputStream.close();
        }
    }
}
