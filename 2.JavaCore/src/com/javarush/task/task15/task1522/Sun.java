package com.javarush.task.task15.task1522;

public class Sun implements Planet {
    private static Sun instance;

    private Sun() {
    }

    public static Sun getInstance() {
        return (Sun.instance == null) ? instance = new Sun() : instance;
    }
}
