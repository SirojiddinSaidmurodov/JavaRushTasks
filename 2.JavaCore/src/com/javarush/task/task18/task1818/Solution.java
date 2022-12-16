package com.javarush.task.task18.task1818;

/*
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileOutputStream output = new FileOutputStream(file1);
        FileInputStream input2 = new FileInputStream(file2);
        FileInputStream input3 = new FileInputStream(file3);

        while (input2.available() > 0) {
            output.write(input2.read());
        }
        while (input3.available() > 0) {
            output.write(input3.read());
        }
        output.flush();
        output.close();
        input2.close();
        input3.close();
    }
}
