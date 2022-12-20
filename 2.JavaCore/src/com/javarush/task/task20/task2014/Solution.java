package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable {
    private transient final String pattern = "dd MMMM yyyy, EEEE";
    String string;
    private transient Date currentDate;
    private transient int temperature;
    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    public static void main(String[] args) {
        File outputFile = new File("/home/sirojiddin/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2014/output");
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(outputFile))) {
            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(outputFile))) {
                Solution savedObject = new Solution(4);
                System.out.println(savedObject);
                outputStream.writeObject(savedObject);
                outputStream.flush();

                Solution solution = new Solution(10);
                Solution loadedObject = (Solution) inputStream.readObject();
                System.out.println(loadedObject);
                System.out.println(savedObject.string.equals(loadedObject.string));
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return this.string;
    }
}
