package com.javarush.task.task19.task1918;

/*
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        String targetTag = args[0];
        String openTag = "<" + targetTag;
        String closeTag = "</" + targetTag;
        String content = readFile();

        ArrayList<Integer> openTags = getTagsIndexes(openTag, content);
        ArrayList<Integer> closeTags = getTagsIndexes(closeTag, content);
        ArrayList<Tag> allTags = getAllTags(openTags, closeTags);
        for (Tag tag : allTags) {
            if (tag.isOpen()) {
                int closeTagIndex = getCloseTag(tag.tagIndex, openTags, closeTags, allTags) + closeTag.length() + 1;
                System.out.println(content.substring(tag.tagIndex, closeTagIndex));
            }
        }

    }

    private static int getCloseTag(int openTag, ArrayList<Integer> openTags, ArrayList<Integer> closeTags, ArrayList<Tag> allTags) {
        if (openTags.get(openTags.size() - 1) == openTag) {
            return findNearestCloseTagIndex(openTag, closeTags);
        } else {
            int openTagsCount = 1, closeTagsCount = 0;
            int currentTag = getIndexOfTag(openTag, allTags) + 1;
            while (openTagsCount != closeTagsCount) {
                if (allTags.get(currentTag).isOpen()) {
                    openTagsCount++;
                } else {
                    closeTagsCount++;
                }
                if (openTagsCount != closeTagsCount) {
                    currentTag++;
                }
            }
            return allTags.get(currentTag).tagIndex;
        }
    }

    private static ArrayList<Tag> getAllTags(ArrayList<Integer> openTags, ArrayList<Integer> closeTags) {
        ArrayList<Tag> tags = new ArrayList<>();
        for (int tagIndex : openTags) {
            tags.add(new Tag(tagIndex, true));
        }
        for (int tagIndex : closeTags) {
            tags.add(new Tag(tagIndex, false));
        }
        tags.sort(Comparator.comparingInt(o -> o.tagIndex));
        return tags;
    }

    private static int getIndexOfTag(int tag, ArrayList<Tag> tags) {
        for (int i = 0; i < tags.size(); i++) {
            if (tags.get(i).tagIndex == tag) {
                return i;
            }
        }
        return -1;
    }


    private static int findNearestCloseTagIndex(int openTag, ArrayList<Integer> closeTags) {
        int currentCloseTagIndex = 0;
        while (openTag > closeTags.get(currentCloseTagIndex)) {
            currentCloseTagIndex++;
        }
        return closeTags.get(currentCloseTagIndex);
    }

    private static ArrayList<Integer> getTagsIndexes(String tag, String content) {
        String currentTail = content;
        ArrayList<Integer> indexes = new ArrayList<>();
        int globalIndex = 0;
        while (currentTail.contains(tag)) {
            int currentIndex = currentTail.indexOf(tag);
            indexes.add(globalIndex + currentIndex);
            currentTail = content.substring(globalIndex + currentIndex + tag.length());
            globalIndex += currentIndex + tag.length();
        }
        return indexes;
    }

    private static String readFile() {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            String file = consoleReader.readLine();
            try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
                while (fileReader.ready()) {
                    builder.append(fileReader.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString().replaceAll("[\\r\\n]+", "");
    }

    private static class Tag {
        private final int tagIndex;
        private final boolean open;

        public Tag(int tagIndex, boolean open) {
            this.tagIndex = tagIndex;
            this.open = open;
        }

        public int getTagIndex() {
            return tagIndex;
        }

        public boolean isOpen() {
            return open;
        }
    }
}
