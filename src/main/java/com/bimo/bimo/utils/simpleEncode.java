package com.bimo.bimo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class simpleEncode {
    public static String md5Encode(String raw) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(raw.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 0xFF);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                stringBuilder.append(hexString);
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            return "error";
        }
    }
}
