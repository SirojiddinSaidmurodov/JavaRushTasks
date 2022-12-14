package com.javarush.task.task18.task1826;

/*
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream source = new FileInputStream(args[1]);
            FileOutputStream target = new FileOutputStream(args[2]);
            switch (args[0]) {
                case "-e":
                    encrypt(source, target);
                    break;
                case "-d":
                    decrypt(source, target);
                    break;
            }
            source.close();
            target.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void decrypt(FileInputStream source, FileOutputStream target) throws IOException {
        while (source.available() > 0) {
            target.write(source.read() - 10);
        }
    }

    private static void encrypt(FileInputStream source, FileOutputStream target) throws IOException {
        while (source.available() > 0) {
            target.write(source.read() + 10);
        }
    }

}
