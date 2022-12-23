package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            String directoryPath = consoleReader.readLine();
            Path path = Paths.get(directoryPath);
            if (Files.isDirectory(path)) {
                AtomicInteger countFiles = new AtomicInteger();
                AtomicInteger countDirs = new AtomicInteger();
                AtomicLong totalSize = new AtomicLong();

                Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                        if (!dir.equals(path)) countDirs.incrementAndGet();
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        countFiles.incrementAndGet();
                        totalSize.addAndGet(attrs.size());
                        return FileVisitResult.CONTINUE;
                    }
                });

                System.out.println("Всего папок - " + countDirs);
                System.out.println("Всего файлов - " + countFiles);
                System.out.println("Общий размер - " + totalSize + " байт");
            } else {
                System.out.println(path.toAbsolutePath().toString() + " - не папка");
            }
        }

    }
}
