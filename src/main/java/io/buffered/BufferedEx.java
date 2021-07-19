package io.buffered;

import java.io.*;

public class BufferedEx {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("template.txt")
        );
             BufferedWriter bufferedWriter = new BufferedWriter(
                     new FileWriter("template2.txt", true)
             );
        ) {
            int ch;
            while ((ch = bufferedReader.read()) != -1) {
                bufferedWriter.write((char) ch);
            }

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
