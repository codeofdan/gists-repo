package com.codeofdan.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Expecting 1 argument: <filename>");
            System.exit(1);
        }

        String filepath = args[0];

        File outFile = new File(filepath);
        FileOutputStream fos = null;

        try {

            if (!outFile.createNewFile()) {
                System.err.println("File: " + outFile.getAbsolutePath() + ", already exists.");
                System.exit(2);
            }

            fos = new FileOutputStream(outFile);

            byte[] bytes = new byte[1024];
            int bytesRead;

            while ((bytesRead = System.in.read(bytes)) != -1) {
                fos.write(bytes, 0, bytesRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.flush();
                    fos.close();
                } catch (IOException e2) {
                    // give up
                    e2.printStackTrace();
                }
            }
        }


    }
}
