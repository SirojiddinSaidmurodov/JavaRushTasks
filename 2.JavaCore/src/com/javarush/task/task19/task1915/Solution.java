package com.javarush.task.task19.task1915;

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        String file;
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            file = consoleReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(outputStream));
        testString.printSomething();
        System.setOut(oldOut);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(outputStream.toByteArray());
            System.out.println(outputStream.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

