package com.javarush.task.task20.task2017;

import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/

public class Solution {
    public static void main(String[] args) {

    }

    public A getOriginalObject(ObjectInputStream objectStream) {
        try {
            Object loaded = objectStream.readObject();
            if (loaded instanceof A) {
                return (Solution.A) loaded;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }
}
