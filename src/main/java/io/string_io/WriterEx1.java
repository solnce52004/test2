package io.string_io;

import java.io.FileWriter;
import java.io.IOException;

public class WriterEx1 {
    //    FileWriter fileWriter;
    static String text = "Hello, world!";
    public static void main(String[] args) {
        try (FileWriter fileWriter = new FileWriter(
                "template.txt",
                true
        )) {
            for (int i = 0; i < text.length(); i++) {
                fileWriter.write((char)text.charAt(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
