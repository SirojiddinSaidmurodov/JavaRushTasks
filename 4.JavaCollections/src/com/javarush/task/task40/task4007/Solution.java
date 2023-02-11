package com.javarush.task.task40.task4007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        Date resultDate;
        Calendar calendar = Calendar.getInstance();
        if ((resultDate = parseDate(date, "d.MM.yyyy HH:mm:ss")) != null) {
            calendar.setTime(resultDate);
            printDayDate(calendar);
            printTime(calendar);
        } else if ((resultDate = parseDate(date, "HH:mm:ss")) != null) {
            calendar.setTime(resultDate);
            printTime(calendar);
        } else if ((resultDate = parseDate(date, "d.MM.yyyy")) != null) {
            calendar.setTime(resultDate);
            printDayDate(calendar);
        }
    }

    private static void printDayDate(Calendar calendar) {
        System.out.println("День: " + calendar.get(Calendar.DATE));
        System.out.println("День недели: " + ((calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1));
        System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
        System.out.println("Год: " + calendar.get(Calendar.YEAR));
    }

    private static void printTime(Calendar calendar) {
        System.out.println("AM или PM: " + (((calendar.get(Calendar.AM_PM) == Calendar.AM)) ? "AM" : "PM"));
        System.out.println("Часы: " + calendar.get(Calendar.HOUR));
        System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
        System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
    }

    private static Date parseDate(String date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date parse = null;
        try {
            parse = dateFormat.parse(date);
        } catch (ParseException ignored) {
        }
        return parse;
    }
}
