package io.binary_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamEx {
    public static void main(String[] args) {
        try(
                FileInputStream fileInputStream = new FileInputStream("slide-130.jpg");
                FileOutputStream fileOutputStream = new FileOutputStream("copy-by-slide-130.jpg");
                ){

            int i;
            while ((i = fileInputStream.read()) != -1){
                fileOutputStream.write(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
