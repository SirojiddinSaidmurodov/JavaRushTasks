package com.javarush.task.task39.task3912;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        int result;

        result = Solution.maxSquare(new int[][]{
                {0, 0, 0, 0, 0, 1, 1},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
        });
        Assert.assertEquals(4, result);

        result = Solution.maxSquare(new int[][]{
                {0, 0, 0, 0, 0, 1, 1},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
        });
        Assert.assertEquals(9, result);

        result = Solution.maxSquare(new int[][]{
                {0, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 1},
        });
        Assert.assertEquals(16, result);


        result = Solution.maxSquare(new int[][]{
                {0, 0},
                {0, 1},
        });
        Assert.assertEquals(1, result);

        result = Solution.maxSquare(new int[][]{
                {1}
        });
        Assert.assertEquals(1, result);

        result = Solution.maxSquare(new int[][]{
                {0}
        });
        Assert.assertEquals(0, result);

        result = Solution.maxSquare(new int[0][0]);
        Assert.assertEquals(0, result);
    }
}