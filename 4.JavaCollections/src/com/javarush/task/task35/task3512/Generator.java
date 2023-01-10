package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class<T> type;

    public Generator(Class<T> type) {
        this.type = type;
    }

    T newInstance()
    {
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
