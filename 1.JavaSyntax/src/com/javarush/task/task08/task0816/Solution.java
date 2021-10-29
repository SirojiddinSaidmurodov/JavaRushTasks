package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("Смирнов" + i, dateFormat.parse("JUNE 1 2012"));
        }
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        for (String name : map.keySet().toArray(new String[0])) {
//            5 6 7
            if (map.get(name).getMonth() <= 7 && map.get(name).getMonth() >= 5) {
                map.remove(name);
            }
        }

    }

    public static void main(String[] args) {
    }
}
