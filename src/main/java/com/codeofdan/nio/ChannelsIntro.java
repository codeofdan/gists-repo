package com.codeofdan.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

public class ChannelsIntro {

    private static final Random RANDOM = new Random(new Date().getTime());

    private int[] bigArray = new int[30];

    public ChannelsIntro() {
        // fill array with ints equal to its index
        Arrays.setAll(bigArray, i -> i);
    }

    public void play(final DataOutputStream outputStream) {
        new Thread(() -> {
            try {
                int written = 0;
                int next = 4;

                writeInts(outputStream,bigArray,written,next);
                written += next;

                Thread.sleep(1000);

                next = 3;
                writeInts(outputStream,bigArray,written,next);
                written += next;

                Thread.sleep(5000);

                next = 7;
                writeInts(outputStream,bigArray,written,next);
                written += next;

                Thread.sleep(5000);

                next = 6;
                writeInts(outputStream,bigArray,written,next);
                written += next;

                Thread.sleep(5000);

                next = 10;
                writeInts(outputStream,bigArray,written,next);
                written += next;

                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void writeInts(DataOutputStream out, int[] array, int offset, int len) throws IOException {
        for (int i = offset; i < offset + len; i ++) {
            out.writeInt(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream(pis);
        DataOutputStream output = new DataOutputStream(pos);

        ReadableByteChannel channel = Channels.newChannel(pis);

        // start the thread playing data into our channel
        new ChannelsIntro().play(output);

        ByteBuffer buffer = ByteBuffer.allocate(32);

        StringBuilder sb = new StringBuilder();

        while (channel.read(buffer) != -1) {

            System.out.println();
            buffer.flip();

            while (buffer.position() + 4 <= buffer.limit()) {
                System.out.print(sb.append(buffer.getInt()).append(" ").toString());
                sb.delete(0, sb.length());
            }

            buffer.clear();
        }
    }
}
