package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String zipFIle = args[1];
        ArrayList<Content> content = getContent(zipFIle);

        try (ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(zipFIle))) {
            File source = new File(args[0]);
            outputStream.putNextEntry(new ZipEntry("new/" + source.getName()));
            Files.copy(source.toPath(), outputStream);

            for (Content zipContent : content) {
                if (!zipContent.getName().equals("new/" + source.getName())) {
                    zipContent.saveToZip(outputStream);
                }


            }
        }
    }

    private static ArrayList<Content> getContent(String zipFIle) {
        ArrayList<Content> result = new ArrayList<>();
        try (ZipInputStream inputStream = new ZipInputStream(new FileInputStream(zipFIle))) {
            ZipEntry nextEntry;
            while (!((nextEntry = inputStream.getNextEntry()) == null)) {
                byte[] buffer = new byte[1024];
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                int readLength = 0;
                while ((readLength = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, readLength);
                }
                result.add(new Content(outputStream.toByteArray(), nextEntry.getName()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static class Content {
        private byte[] content;
        private String name;

        public Content(byte[] content, String name) {
            this.content = content;
            this.name = name;
        }

        public byte[] getContent() {
            return content;
        }

        public String getName() {
            return name;
        }

        public void saveToZip(ZipOutputStream zipOutputStream) throws IOException {
            zipOutputStream.putNextEntry(new ZipEntry(name));
            zipOutputStream.write(content);
            zipOutputStream.closeEntry();
        }

    }
}
