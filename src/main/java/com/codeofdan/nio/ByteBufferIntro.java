package com.codeofdan.nio;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 *
 */
public class ByteBufferIntro {

    public static void main(String[] args) throws IOException {
        // create an InputStream from "Hello World" bytes
        try (ByteArrayInputStream input =
                     new ByteArrayInputStream("Hello World".getBytes())) {
            // initialise channel from stream
            ReadableByteChannel channel = Channels.newChannel(input);
            // get a buffer of capacity = 8
            ByteBuffer buffer = ByteBuffer.allocate(8);

            while (channel.read(buffer) > 0) {

                // prepare the buffer for reading
                buffer.flip();

                // keep looping whilst there's still data to read
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }

                // print a new line
                System.out.println();

                // prepare the buffer for reading from the channel
                buffer.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
