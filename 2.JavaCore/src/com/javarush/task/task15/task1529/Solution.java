package com.javarush.task.task15.task1529;

/*
Осваивание статического блока
*/

import java.util.Scanner;

public class Solution {
    public static CanFly result;

    static {
        reset();
    }

    public static void main(String[] args) {

    }

    public static void reset() {
        Scanner scanner = new Scanner(System.in);
        String param = scanner.nextLine();
        if (param.equals("helicopter")) {
            result = new Helicopter();
        } else {
            result = new Plane(scanner.nextInt());
        }
        scanner.close();
    }
}
