package com.javarush.task.task18.task1827;

/*
Прайсы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            return;
        }
        if (args[0].equals("-c")) {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String table = consoleReader.readLine();
            int maxID = Integer.MIN_VALUE;
            try (BufferedReader reader = new BufferedReader(new FileReader(table))) {
                int currentID;
                while (reader.ready()) {
                    String line = reader.readLine();
                    if ((currentID = (new Product(line)).id) > maxID) maxID = currentID;
                }
            }
            try (FileWriter fileWriter = new FileWriter(table, true)) {
                fileWriter.write(
                        new Product(
                                maxID + 1,
                                args[1],
                                Double.parseDouble(args[2]),
                                Integer.parseInt(args[3])).toString());
                fileWriter.flush();
            }

        }
    }

    public static class Product {
        private int id;
        private String name;
        private double price;
        private int quantity;

        public Product(int id, String productName, double price, int quantity) {
            this.id = id;
            this.name = productName;
            this.price = price;
            this.quantity = quantity;
        }

        public Product(String tableRow) {
            id = Integer.parseInt(tableRow.substring(0, 8).trim());
            name = tableRow.substring(8, 38).trim();
            price = Double.parseDouble(tableRow.substring(38, 46).trim());
            quantity = Integer.parseInt(tableRow.substring(46).trim());
        }

        @Override
        public String toString() {
            return String.format("\n%-8d%-30s%-8s%-4s", id, name, price, quantity);
        }
    }
}
