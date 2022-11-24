package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        boolean isEnd = false;
        while (!isEnd) {
            key = reader.readLine();
            switch (key) {
                case "user":
                    person = new Person.User();
                    break;
                case "loser":
                    person = new Person.Loser();
                    break;
                case "coder":
                    person = new Person.Coder();
                    break;
                case "proger":
                    person = new Person.Proger();
                    break;
                default:
                    isEnd = true;
                    break;
            }
            //создаем объект, пункт 2
            if (isEnd) {
                break;
            }
            doWork(person); //вызываем doWork

        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) {
            ((Person.User) person).live();
        }
        if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
        if (person instanceof Person.Coder) {
            ((Person.Coder) person).writeCode();
        }
        if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        }
    }
}
