package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/* 
Находим все файлы
*/

public class Solution {
    /**
     * public static List<String> getFileTree(String root) throws IOException {
     * List<String> result = new ArrayList<>();
     * <p>
     * EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
     * Files.walkFileTree(Paths.get(root), options, 20, new GetFiles(result));
     * <p>
     * return result;
     * }
     * <p>
     * private static class GetFiles extends SimpleFileVisitor<Path> {
     * private List<String> result;
     * <p>
     * public GetFiles(List<String> result) {
     * this.result = result;
     * }
     *
     * @Override public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
     * String s = path.toAbsolutePath().toString();
     * result.add(s);
     * return FileVisitResult.CONTINUE;
     * }
     * }
     */
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();
        Queue<File> directories = new ArrayDeque<>();
        directories.add(new File(root));
        while (!directories.isEmpty()) {
            File directory = directories.poll();
            for (File file : directory.listFiles()) {
                if (file.isDirectory()) {
                    directories.add(file);
                } else {
                    result.add(file.getAbsolutePath());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
