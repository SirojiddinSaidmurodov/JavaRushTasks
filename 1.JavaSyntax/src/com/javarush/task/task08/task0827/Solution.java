package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Calendar calendar = new GregorianCalendar();
        DateFormat format = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        try {
            Date parse = format.parse(date);
            calendar.setTime(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (calendar.get(Calendar.DAY_OF_YEAR) % 2 == 1);
    }
}
