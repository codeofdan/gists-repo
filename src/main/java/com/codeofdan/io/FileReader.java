package com.codeofdan.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Expecting 1 argument: <filename>");
            System.exit(1);
        }

        String filepath = args[0];

        File inFile = new File(filepath);

        try (FileInputStream fis = new FileInputStream(inFile)){

            if (!inFile.exists()) {
                System.err.println("File: " + inFile.getAbsolutePath() + ", doesn't exists.");
                System.exit(2);
            }

            byte[] bytes = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(bytes)) != -1) {
                System.out.write(bytes, 0, bytesRead);
            }

            System.out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
