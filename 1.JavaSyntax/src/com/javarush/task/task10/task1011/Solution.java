package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

public class Solution {
    public static void main(String[] args) {
        String text = "Я не хочу изучать Java, я хочу большую зарплату";
        String[] split = text.split("");
        int linesCount = 0;
        int position = 0;
        while (linesCount < 40) {
            StringBuilder tempText = new StringBuilder();
            for (int i = position; i < split.length; i++) {
                tempText.append(split[i]);
            }
            position++;
            if (!tempText.toString().equals("")) {
                System.out.println(tempText);
                linesCount++;
            }
        }
    }

}

