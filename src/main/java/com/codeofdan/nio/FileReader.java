package com.codeofdan.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {

    public static void main(String[] args) {

        Path filePath = Paths.get(args[0]);

        try (FileChannel fileChannel = FileChannel.open(filePath)) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int bytesRead = 0;

            do {
                bytesRead += fileChannel.read(buffer);
                System.out.print(new String(buffer.array(), 0, buffer.position()));
                buffer.rewind();
            }
            while (bytesRead != fileChannel.size());

            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
