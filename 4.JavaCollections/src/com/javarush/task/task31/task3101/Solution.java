package com.javarush.task.task31.task3101;

/*
Проход по дереву файлов
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        File path = new File(args[0]), resultFileAbsolutePath = new File(args[1]);
        File resultFile = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, resultFile);
        try (FileOutputStream outputStream = new FileOutputStream(resultFile)) {
            extract(path, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void extract(File path, FileOutputStream outputStream) throws IOException {
        for (File file : path.listFiles()) {
            if (file.isDirectory()) {
                extract(file, outputStream);
            } else if (file.length() <= 50) {
                try (FileInputStream inputStream = new FileInputStream(file)) {
                    while (inputStream.available() > 0) {
                        outputStream.write(inputStream.read());
                    }
                    outputStream.write("\n".getBytes());
                }
            }
        }
    }
}
