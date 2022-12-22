package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public static void main(String[] args) {
        String file = "/home/sirojiddin/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2022/temp";
        try (Solution solutionInit = new Solution(file)) {
            solutionInit.writeObject("smth");
            solutionInit.writeObject(new ObjectOutputStream(new FileOutputStream(file)));
//            solutionInit.readObject(new ObjectInputStream(new FileInputStream(file)));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.flush();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(this.fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
