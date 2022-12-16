package com.javarush.task.task18.task1821;

/*
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<Character, Integer> countChars = new HashMap<>();
        try (FileInputStream input = new FileInputStream(args[0])) {
            while (input.available() > 0) {
                char letter = (char) input.read();
                if (countChars.containsKey(letter)) {
                    countChars.put(letter, countChars.get(letter) + 1);
                } else {
                    countChars.put(letter, 1);
                }
            }
        }
        List<Character> characterList = countChars.keySet().stream().sorted().collect(Collectors.toList());
        for (Character character : characterList) {
            System.out.printf("%s %d\n", character, countChars.get(character));
        }
    }
}
