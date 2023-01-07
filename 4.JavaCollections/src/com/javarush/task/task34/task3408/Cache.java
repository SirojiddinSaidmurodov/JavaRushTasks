package com.javarush.task.task34.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private final Map<K, V> cache = new WeakHashMap<>();

    public V getByKey(K key, Class<V> clazz) throws Exception {
        V v = cache.get(key);
        if (v == null) {
            v = clazz
                    .getConstructor(new Class[]{key.getClass()})
                    .newInstance(key);
            cache.put(key, v);
        }
        return v;
    }

    public boolean put(V obj) {
        try {
            Method getKeyMethod = obj.getClass().getDeclaredMethod("getKey", (Class<?>[]) null);
            getKeyMethod.setAccessible(true);
            K key = (K) getKeyMethod.invoke(obj);
            cache.put(key, obj);
            return true;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}
