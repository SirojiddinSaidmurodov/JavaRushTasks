package com.javarush.task.task39.task3901;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void lengthOfLongestUniqueSubstring() {
        assertEquals(6, Solution.lengthOfLongestUniqueSubstring("a123bcbcqwe"));
        assertEquals(2, Solution.lengthOfLongestUniqueSubstring("ttttwt"));
    }
}