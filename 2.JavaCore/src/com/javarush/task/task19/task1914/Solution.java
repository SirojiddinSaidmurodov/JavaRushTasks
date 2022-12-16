package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(outputStream));
        testString.printSomething();
        System.setOut(oldOut);
        String[] equation = outputStream.toString().split(" ");
        int a = Integer.parseInt(equation[0]);
        int b = Integer.parseInt(equation[2]);
        int result = 0;
        switch (equation[1]) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
        }
        System.out.println(a + " " + equation[1] + " " + b + " = " + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

