package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        Set<Integer> integers = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            integers.add(i);
        }
        return integers;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        Set<Integer> greaterThan10 = new HashSet<>();
        for (int element : set) {
            if (element > 10) {
                greaterThan10.add(element);
            }
        }
        set.removeAll(greaterThan10);
        return set;
    }

    public static void main(String[] args) {
        Set<Integer> set = createSet();
        Set<Integer> integers = removeAllNumbersGreaterThan10(set);
    }
}
