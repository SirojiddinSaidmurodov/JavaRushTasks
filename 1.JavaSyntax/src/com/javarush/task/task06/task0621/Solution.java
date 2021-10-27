package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandpaString = reader.readLine();
        String grandmaString = reader.readLine();
        String fatherString = reader.readLine();
        String motherString = reader.readLine();
        String sonString = reader.readLine();
        String daughterString = reader.readLine();
        Cat grandpa = new Cat(grandpaString, null, null);
        Cat grandma = new Cat(grandmaString, null, null);
        Cat father = new Cat(fatherString, null, grandpa);
        Cat mother = new Cat(motherString, grandma, null);
        Cat son = new Cat(sonString, mother, father);
        Cat daughter = new Cat(daughterString, mother, father);

        System.out.println(grandpa);
        System.out.println(grandma);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son);
        System.out.println(daughter);
    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name, Cat mother, Cat father) {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        @Override
        public String toString() {
            String motherName = mother == null ? "no mother" : "mother is " + mother.name;
            String fatherName = father == null ? "no father" : "father is " + father.name;

            return "The cat's name is " + name + ", " + motherName + ", " + fatherName;
        }
    }

}
