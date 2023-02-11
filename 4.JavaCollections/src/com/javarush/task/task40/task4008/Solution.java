package com.javarush.task.task40.task4008;

/*
Работа с Java 8 DateTime API
*/

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("d.M.y H:m:s");
        boolean hasDate = true;
        boolean hasTime = true;
        if (date.contains(".") && !date.contains(":")) {
            pattern = DateTimeFormatter.ofPattern("d.M.y");
            hasTime = false;
        }
        if (!date.contains(".") && date.contains(":")) {
            pattern = DateTimeFormatter.ofPattern("H:m:s");
            hasDate = false;
        }

        if (hasDate) {
            printDateOnly(LocalDate.parse(date, pattern));
        }
        if (hasTime) {
            printTimeOnly(LocalTime.parse(date, pattern));
        }
    }

    private static void printTimeOnly(LocalTime localTime) {
        System.out.println("AM или PM: " + localTime.format(DateTimeFormatter.ofPattern("a")));
        System.out.println("Часы: " + localTime.format(DateTimeFormatter.ofPattern("K")));
        System.out.println("Часы дня: " + localTime.getHour());
        System.out.println("Минуты: " + localTime.getMinute());
        System.out.println("Секунды: " + localTime.getSecond());
    }

    private static void printDateOnly(LocalDate localDate) {
        System.out.println("День: " + localDate.getDayOfMonth());
        System.out.println("День недели: " + localDate.getDayOfWeek().getValue());
        System.out.println("День месяца: " + localDate.getDayOfMonth());
        System.out.println("День года: " + localDate.getDayOfYear());
        System.out.println("Неделя месяца: " + localDate.format(DateTimeFormatter.ofPattern("W")));
        System.out.println("Неделя года: " + localDate.format(DateTimeFormatter.ofPattern("w")));
        System.out.println("Месяц: " + localDate.getMonth().getValue());
        System.out.println("Год: " + localDate.getYear());
    }
}
