package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private final List<Path> foundFiles = new ArrayList<>();
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;

    public String getPartOfName() {
        return partOfName;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public long getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        boolean hasPartOfName = partOfName == null || file.getFileName().toString().contains(partOfName);
        boolean hasPartOfContent = partOfContent == null || new String(content).contains(partOfContent);
        boolean hasMinSize = minSize == 0 || content.length > minSize;
        boolean hasMaxSize = maxSize == 0 || content.length < maxSize;
        if (hasPartOfName && hasPartOfContent && hasMinSize && hasMaxSize) {
            foundFiles.add(file);
        }
        return super.visitFile(file, attrs);
    }
}
