package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;


public class FunctionalTest {
    public void testStorage(Shortener shortener) {
        String a = "a", b = "b", c = "a";
        Long idA = shortener.getId(a);
        Long idB = shortener.getId(b);
        Long idC = shortener.getId(c);
        Assert.assertNotEquals(idB, idA);
        Assert.assertNotEquals(idB, idC);
        Assert.assertEquals(idA, idC);

        String newA = shortener.getString(idA);
        String newB = shortener.getString(idB);
        String newC = shortener.getString(idC);
        Assert.assertEquals(a, newA);
        Assert.assertEquals(b, newB);
        Assert.assertEquals(c, newC);
    }

    @Test
    public void testHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy() {
        Shortener shortener = new Shortener(new FileStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);
    }
}
