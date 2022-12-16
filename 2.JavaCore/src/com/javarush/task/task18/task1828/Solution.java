package com.javarush.task.task18.task1828;

/*
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        if (args[0].equals("-u")) {
            update(file, args[1], args[2], args[3], args[4]);
        } else if (args[0].equals("-d")) {
            delete(file, args[1]);
        }

    }

    private static void update(String file, String id, String productName, String price, String quantity) {
        ArrayList<String> fileContent = getFileContent(file);
        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).substring(0, 8).trim().equals(id)) {
                fileContent.set(i, new Product(id, productName, price, quantity).toString());
            }
        }
        writeFile(file, fileContent);
    }

    private static void delete(String file, String id) {
        ArrayList<String> fileContent = getFileContent(file);
        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).substring(0, 8).trim().equals(id)) {
                fileContent.remove(i);
            }
        }
        writeFile(file, fileContent);
    }

    private static ArrayList<String> getFileContent(String file) {
        ArrayList<String> fileContent = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                fileContent.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    private static void writeFile(String file, ArrayList<String> fileContent) {
        try (FileWriter writer = new FileWriter(file)) {
            for (int i = 0; i < fileContent.size(); i++) {
                writer.write(fileContent.get(i));
                if (i != fileContent.size() - 1) writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Product {
        private final String id;
        private final String name;
        private final String price;
        private final String quantity;

        public Product(String id, String productName, String price, String quantity) {
            this.id = id;
            this.name = productName;
            this.price = price;
            this.quantity = quantity;
        }

        public Product(String tableRow) {
            id = tableRow.substring(0, 8).trim();
            name = tableRow.substring(8, 38).trim();
            price = tableRow.substring(38, 46).trim();
            quantity = tableRow.substring(46).trim();
        }

        @Override
        public String toString() {
            return String.format("%-8s%-30s%-8s%-4s", id, name, price, quantity);
        }
    }
}
