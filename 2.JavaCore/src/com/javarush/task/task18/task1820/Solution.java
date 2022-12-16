package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String source = reader.readLine();
        String target = reader.readLine();

        String[] input;
        try (BufferedReader sourceReader = new BufferedReader(new FileReader(source))) {
            input = sourceReader.readLine().split(" ");
        }
        List<Double> doubles = Arrays.stream(input).map(Double::parseDouble).collect(Collectors.toList());
        try (FileWriter writer = new FileWriter(target)) {
            for (Double number : doubles) {
                writer.write(Math.round(number) + " ");
            }
        }

    }
}
