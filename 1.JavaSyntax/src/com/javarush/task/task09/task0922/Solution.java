package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dateString = reader.readLine();
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = inFormat.parse(dateString);
        SimpleDateFormat outFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(Locale.ENGLISH);
        dateFormatSymbols.setShortMonths(new String[]{
                "JAN",
                "FEB",
                "MAR",
                "APR",
                "MAY",
                "JUN",
                "JUL",
                "AUG",
                "SEP",
                "OCT",
                "NOV",
                "DEC"
        });
        outFormat.setDateFormatSymbols(dateFormatSymbols);
        System.out.println(outFormat.format(parse));
    }
}
