package com.javarush.task.task08.task0813;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
20 слов на букву «Л»
*/

public class Solution {
    public static Set<String> createSet() {
        return new HashSet<>(Arrays.asList(
                "Лекция", "Лакрос", "Ласточка", "Лекарство",
                "Ласось", "Лейкемия", "Литература", "Лукавство",
                "Лох", "Лучшее", "Ларгус", "Лоперамид",
                "Легитимность", "Лор", "Ламода", "Люк",
                "Ланцет", "Лакрица", "Лак", "Лось"
        ));
    }

    public static void main(String[] args) {

    }
}
