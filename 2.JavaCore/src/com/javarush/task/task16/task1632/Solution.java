package com.javarush.task.task16.task1632;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
//        Thread 1
        threads.add(new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    continue;
                }
            }
        }));
//        Thread 2
        threads.add(new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }));
//        Thread 3
//        threads.add(new Thread(() -> {
//            System.out.println("Ура");
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//            }
//        }));
        threads.add(new Thread3());
//        Thread 4
        threads.add(new MessageThread());
//        Thread 5
        threads.add(new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            int sum = 0;
            String currentInput = scanner.nextLine();
            while (!currentInput.equals("N")) {
                sum += Integer.parseInt(currentInput);
                currentInput = scanner.nextLine();
            }
            System.out.println(sum);
        }));
    }

    public static void main(String[] args) {

    }

    public static class Thread3 extends Thread {
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class MessageThread extends Thread implements Message {
        @Override
        public void showWarning() {
            this.interrupt();
        }

        @Override
        public void run() {
            while (this.isAlive()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}