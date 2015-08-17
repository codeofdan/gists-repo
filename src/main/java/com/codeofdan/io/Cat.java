package com.codeofdan.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Implementation of /bin/cat in Java.
 *
 * If run with no arguments, will read from stdin and write to stdout.
 *
 * If run with arguments, each argument is a filepath whose contents will be written to stdout.
 */
public class Cat {

    private static byte[] bytes = new byte[128];

    public static void main(String[] args) throws Exception {

        if (args.length != 0) {
            for (String filePath : args) {
                try (FileInputStream fis = new FileInputStream(filePath)) {
                    readInputStream(fis);
                }
            }
        } else {
            readInputStream(System.in);
        }

    }

    public static void readInputStream(InputStream inputStream) throws IOException {
        int bytesRead;
        while ((bytesRead = inputStream.read(bytes)) != -1) {
            System.out.write(bytes, 0, bytesRead);
            System.out.flush();
        }
    }

}
