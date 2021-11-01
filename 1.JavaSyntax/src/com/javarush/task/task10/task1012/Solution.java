package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String line = reader.readLine();
            list.add(line.toLowerCase());
        }

        Map<Character, Integer> map = new HashMap<>();
        for (Character letter :
                alphabet) {
            map.put(letter, 0);
        }

        for (String string :
                list) {
            char[] chars = string.toCharArray();
            for (Character character :
                    chars) {
                if (alphabet.contains(character)) {
                    map.put(character, map.get(character) + 1);
                }
            }
        }

        for (Character letter :
                alphabet) {
            System.out.println(letter + " " + map.get(letter));
        }
    }
}
