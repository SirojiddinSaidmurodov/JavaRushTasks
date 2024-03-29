package com.javarush.task.task18.task1810;

/*
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                try (FileInputStream file = new FileInputStream(input)) {
                    if (file.available() < 1000) throw new DownloadException();
                }
            } catch (IOException e) {
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
