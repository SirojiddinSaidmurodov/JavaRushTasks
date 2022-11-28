package com.javarush.task.task15.task1522;

/*
Закрепляем паттерн Singleton
*/

import java.util.Scanner;

public class Solution {
    public static Planet thePlanet;

    static {
        readKeyFromConsoleAndInitPlanet();
        System.out.println(thePlanet);
    }

    public static void main(String[] args) {

    }

    public static void readKeyFromConsoleAndInitPlanet() {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case Planet.SUN:
                thePlanet = Sun.getInstance();
                break;
            case Planet.EARTH:
                thePlanet = Earth.getInstance();
                break;
            case Planet.MOON:
                thePlanet = Moon.getInstance();
                break;
            default:
                thePlanet = null;
        }
    }
}
