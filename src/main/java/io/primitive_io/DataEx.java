package io.primitive_io;

import java.io.*;

public class DataEx {
    public static void main(String[] args) {
        try(
                final DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("template.bin"));
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream("template.bin"));
        ){
            dataOutputStream.writeByte(3);
            dataOutputStream.writeInt(10);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeChars("Hello");

            System.out.println(dataInputStream.readByte());
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
