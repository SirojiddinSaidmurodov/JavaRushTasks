package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        File resultFile = new File(args[0]);
        if (!resultFile.exists()) {
            resultFile.createNewFile();
        }
        ArrayList<String> fileNames = new ArrayList<>(Arrays.asList(args).subList(1, args.length));
        Collections.sort(fileNames);
        ArrayList<FileInputStream> streams = new ArrayList<>();
        for (String fileName : fileNames) {
            streams.add(new FileInputStream(fileName));
        }

        try (ZipInputStream is = new ZipInputStream(new SequenceInputStream(Collections.enumeration(streams))))    //Входящий стрим общего архива
        {
            while (true) {
                ZipEntry entry = is.getNextEntry();
                if (entry == null) break;

                try (OutputStream os = new BufferedOutputStream(new FileOutputStream(resultFile))) {
                    final int bufferSize = 1024;
                    byte[] buffer = new byte[bufferSize];
                    for (int readBytes; (readBytes = is.read(buffer, 0, bufferSize)) > -1; ) {
                        os.write(buffer, 0, readBytes);
                    }
                }
            }

        }
    }
}
