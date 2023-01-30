package com.javarush.task.task39.task3909;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void isOneEditAway() {
        assertFalse(Solution.isOneEditAway("123", "1"));
        assertFalse(Solution.isOneEditAway("123", null));
        assertFalse(Solution.isOneEditAway("123", "345"));
        assertFalse(Solution.isOneEditAway("", ""));

        assertTrue(Solution.isOneEditAway("","1"));
        assertTrue(Solution.isOneEditAway("1244", "1234"));
        assertTrue(Solution.isOneEditAway("1", "2"));
        assertTrue(Solution.isOneEditAway("124", "1234"));
        assertTrue(Solution.isOneEditAway("марка", "манка"));
    }
}