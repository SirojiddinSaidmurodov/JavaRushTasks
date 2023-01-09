package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil implements Convertable<Object> {
    static ConvertableUtil instance;
    public static <X> Map convert(List<? extends Convertable<X>> list) {
        Map<X,Convertable> result = new HashMap();
        for (Convertable value :
                list) {
            result.put((X) value.getKey(),value);
        }
        return result;
    }

    @Override
    public Object getKey() {
        return null;
    }
}
