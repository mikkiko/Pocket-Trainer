package com.github.mikkiko.pockettrainer.util;

import java.io.*;

public class FileUtils {

    public static byte[] extractBytes(File image) throws IOException {
        FileInputStream in = new FileInputStream(image);
        byte[] bytes = new byte[in.available()];
        in.read(bytes);
        in.close();
        return bytes;
    }

    public static String extractString(File text) throws IOException {
        FileInputStream in = new FileInputStream(text);
        byte[] bytes = new byte[in.available()];
        in.read(bytes);
        in.close();
        return new String(bytes);
    }

    public static boolean readImage(byte[] bytes, File distPath) throws IOException {
        FileOutputStream out = new FileOutputStream(distPath);
        out.write(bytes);
        out.flush();
        out.close();
        return distPath.exists();
    }
}