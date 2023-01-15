package com.javarush.task.task37.task3714;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void testFormat() {
        try {
            Solution.romanToInteger("MMMMCMXCIX");
        }catch (Exception e){
            assertEquals(NumberFormatException.class,e.getClass());
        }
    }
    @Test
    public void testNumber(){
        Object[][] tests = new Object[][]{
                {1, "I"},
                {2, "II"},
                {3, "III"},
                {4, "IV"},
                {5, "V"},
                {9, "IX"},
                {12, "XII"},
                {16, "XVI"},
                {29, "XXIX"},
                {44, "XLIV"},
                {45, "XLV"},
                {68, "LXVIII"},
                {83, "LXXXIII"},
                {97, "XCVII"},
                {99, "XCIX"},
                {500, "D"},
                {501, "DI"},
                {649, "DCXLIX"},
                {798, "DCCXCVIII"},
                {891, "DCCCXCI"},
                {1000, "M"},
                {1004, "MIV"},
                {1006, "MVI"},
                {1023, "MXXIII"},
                {2014, "MMXIV"},
                {3999, "MMMCMXCIX"}
        };

        Arrays.stream(tests).forEach(ele -> {
            System.out.println((int)ele[0]);
            assertEquals(ele[0], Solution.romanToInteger((String)ele[1]));
        });
    }
}