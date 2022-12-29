package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true
    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(byteArrayOutputStream.toByteArray());
        byte[] md5hash = digest.digest();
        StringBuilder stringBuilder = new StringBuilder();
        for (byte hash : md5hash) {
            String s = Integer.toHexString(0xFF & hash);
            stringBuilder.append((s.length() < 2) ? "0" + s : s);
        }
        return md5.equals(stringBuilder.toString());
    }
}
