package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        ArrayList<Character> vowels = new ArrayList<>();
        ArrayList<Character> other = new ArrayList<>();
        for (Character c : input.toCharArray()) {
            if (!c.equals(' ')) {
                if (isVowel(c)) {
                    vowels.add(c);
                } else {
                    other.add(c);
                }
            }
        }
        print(vowels);
        System.out.println();
        print(other);
    }

    public static void print(ArrayList<Character> chars) {
        for (char c : chars) {
            System.out.print(c + " ");
        }
        System.out.print(" ");
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char character) {
        character = Character.toLowerCase(character);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char vowel : vowels) {  // ищем среди массива гласных
            if (character == vowel) {
                return true;
            }
        }
        return false;
    }
}