package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet<Long>();
        for (String string : strings) {
            result.add(shortener.getId(string));
        }
        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet<>();
        for (Long key : keys) {
            result.add(shortener.getString(key));
        }
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Shortener shortener = new Shortener(strategy);
        Set<String> generated = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            String string = Helper.generateRandomString();
            generated.add(string);
        }

        Date startGetIds = new Date();
        Set<Long> ids = getIds(shortener, generated);
        Date finishGetIds = new Date();
        Helper.printMessage(String.valueOf(finishGetIds.getTime() - startGetIds.getTime()));

        Date startGetStrings = new Date();
        Set<String> strings = getStrings(shortener, ids);
        Date finishGetStrings = new Date();
        Helper.printMessage(String.valueOf(finishGetStrings.getTime() - startGetStrings.getTime()));

        if (strings.size() == generated.size()) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }
}
