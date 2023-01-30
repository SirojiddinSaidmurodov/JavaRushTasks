package com.javarush.task.task39.task3903;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void swapBits() {
        Assert.assertEquals(Long.toBinaryString(12),Long.toBinaryString(Solution.swapBits(12,2,3)));
        Assert.assertEquals(10,Solution.swapBits(12,1,2));
        Assert.assertEquals(1,Solution.swapBits(128,0,7));
        Assert.assertEquals(128,Solution.swapBits(1,0,7));
    }
}