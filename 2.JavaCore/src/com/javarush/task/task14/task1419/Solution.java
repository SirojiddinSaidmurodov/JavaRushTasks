package com.javarush.task.task14.task1419;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            exceptions.get(10);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            new FileInputStream("fafas").close();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            BufferedReader reader = null;
            reader.readLine();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Integer.parseInt("asdad");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Scanner scanner = new Scanner("sadad");
            scanner.nextInt();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Scanner scanner = new Scanner("sadad");
            scanner.close();
            scanner.nextInt();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Scanner scanner = new Scanner("");
            scanner.nextInt();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            "sdasad".charAt(254);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Solution.class.getClassLoader().loadClass("sdfsf");
        } catch (Exception e) {
            exceptions.add(e);
        }

    }
}
