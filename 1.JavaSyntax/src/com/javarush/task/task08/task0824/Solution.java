package com.javarush.task.task08.task0824;

import java.util.ArrayList;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        Human child1 = new Human("child1", true, 10, new ArrayList<>());
        Human child2 = new Human("child2", true, 10, new ArrayList<>());
        Human child3 = new Human("child3", true, 10, new ArrayList<>());
        ArrayList<Human> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        children.add(child3);

        Human mom = new Human("mom", false, 30, children);
        Human pa = new Human("pa", true, 30, children);
        Human grandma1 = new Human("grandma1", false, 80, mom);
        Human grandpa1 = new Human("grandpa1", true, 80, mom);
        Human grandma2 = new Human("grandpa1", false, 80, pa);
        Human grandpa2 = new Human("grandpa1", true, 80, pa);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
        System.out.println(mom);
        System.out.println(pa);
        System.out.println(grandma1);
        System.out.println(grandpa1);
        System.out.println(grandma2);
        System.out.println(grandpa2);
    }

    public static class Human {
        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public Human(String name, boolean sex, int age, Human human) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = new ArrayList<>();
            this.children.add(human);
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
