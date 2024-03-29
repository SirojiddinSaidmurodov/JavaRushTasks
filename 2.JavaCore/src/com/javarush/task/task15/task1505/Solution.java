package com.javarush.task.task15.task1505;

/* 
ООП - исправь ошибки в наследовании
*/

public class Solution {
    public static void main(String[] args) {
        Human human = new Human();
        System.out.println(human.getHeight());
        System.out.println(human.getWeight());
    }

    public interface HasWeight {
        int getWeight();
    }

    public interface HasHeight {
        int getHeight();
    }

    public static class Human implements HasWeight, HasHeight {

        @Override
        public int getWeight() {
            return 82;
        }

        @Override
        public int getHeight() {
            return 180;
        }
    }
}