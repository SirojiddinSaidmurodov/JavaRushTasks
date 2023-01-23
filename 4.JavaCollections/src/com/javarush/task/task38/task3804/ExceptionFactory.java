package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable getException(Enum e) {
        Throwable result = new IllegalArgumentException();
        if (e == null) return result;

        Class<? extends Enum> enumClass = e.getClass();
        String message = e.toString().replaceAll("_", " ").toLowerCase();
        message = message.substring(0, 1).toUpperCase() + message.substring(1);
        if (enumClass.equals(ApplicationExceptionMessage.class)) {
            result = new Exception(message);
        } else if (enumClass.equals(DatabaseExceptionMessage.class)) {
            result = new RuntimeException(message);
        } else if (enumClass.equals(UserExceptionMessage.class)) {
            result = new Error(message);
        }
        return result;
    }
}
