package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    private static final Random random = new Random();

    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password);
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        try {
            outputStream.write(passwordGenerator.generate());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return outputStream;
    }


    static class PasswordGenerator {
        private byte[] generate() {
            byte[] password = new byte[8];
            for (int i = 0; i < 5; i++) {
                password[i] = (byte) generateCharacter();
            }
            password[5] = (byte) (random.nextInt(10) + 48);
            password[6] = (byte) (random.nextInt(25) + 97);
            password[7] = (byte) (random.nextInt(25) + 65);
            return password;
        }


        private char generateCharacter() {
            switch (random.nextInt(3)) {
                case 0:
                    return (char) (random.nextInt(10) + 48);
                case 1:
                    return (char) (random.nextInt(25) + 97);
                case 2:
                    return (char) (random.nextInt(25) + 65);
            }
            return 0;
        }
    }

}
