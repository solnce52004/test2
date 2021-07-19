package io.buffered;

import java.io.*;

public class BufferedStreamEx {
    public static void main(String[] args) {
        try (
                BufferedInputStream bufferedInputStream = new BufferedInputStream(
                        new FileInputStream("slide-130.jpg"),
                        4096
                );
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                        new FileOutputStream("copy-buffered-by-slide-130.jpg"),
                        2048
                );
        ) {

            int i;
            while ((i = bufferedInputStream.read()) != -1){
                bufferedOutputStream.write(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
