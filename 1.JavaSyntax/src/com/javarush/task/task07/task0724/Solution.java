package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

import java.util.ArrayList;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Human> humans = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            humans.add(new Human(
                    "orphan" + i,
                    i % 2 == 0,
                    random.nextInt(80)));
        }
        for (int i = 0; i < 5; i++) {
            humans.add(new Human(
                    "human" + i,
                    i % 2 == 0,
                    random.nextInt(80),
                    humans.get(random.nextInt(humans.size())),
                    humans.get(random.nextInt(humans.size()))));
        }
        for (Human human :
                humans) {
            System.out.println(human);
        }
    }

    public static class Human {
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}