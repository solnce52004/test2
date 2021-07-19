package io.string_io;

import java.io.FileReader;
import java.io.IOException;

public class ReaderEx1 {
    public static void main(String[] args) {
        FileReader fileReader = null;

        try (
                FileReader reader = fileReader = new FileReader("template.txt")
        ) {
            int eachChar;
            while ((eachChar = reader.read()) != -1) {
                System.out.print((char)eachChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
