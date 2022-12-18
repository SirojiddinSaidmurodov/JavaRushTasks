package com.javarush.task.task19.task1927;

/*
Контекстная реклама
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething();
        outputStream.toByteArray();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(outputStream.toByteArray())))) {
            int count = 0;
            while (reader.ready()) {
                consoleOut.println(reader.readLine());
                if (count % 2 == 1) {
                    consoleOut.println("JavaRush - курсы Java онлайн");
                }
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setOut(consoleOut);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
