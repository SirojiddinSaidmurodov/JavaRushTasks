package com.javarush.task.task08.task0801;

/*
Set из растений
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Set<String> plants = new HashSet<String>();

        plants.add("арбуз");
        plants.add("банан");
        plants.add("вишня");
        plants.add("груша");
        plants.add("дыня");
        plants.add("ежевика");
        plants.add("женьшень");
        plants.add("земляника");
        plants.add("ирис");
        plants.add("картофель");

        for (String plant : plants) {
            System.out.println(plant);
        }
    }
}
