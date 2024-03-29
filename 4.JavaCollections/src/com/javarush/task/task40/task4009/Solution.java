package com.javarush.task.task40.task4009;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/* 
Buon Compleanno!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
        System.out.println(getWeekdayOfBirthday("1.12.2015", "2016"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {
        LocalDate localDate = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("d.M.y"));
        return localDate.withYear(Year.parse(year).getValue())
                .format(DateTimeFormatter.ofPattern("EEEE").withLocale(Locale.ITALIAN));
    }
}
