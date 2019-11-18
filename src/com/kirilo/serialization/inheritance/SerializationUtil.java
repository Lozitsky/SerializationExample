package com.kirilo.serialization.inheritance;

import java.io.*;

public class SerializationUtil {
    public static void serialize(Object obj, File fileName) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(obj);
        outputStream.close();
    }
    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Object object = inputStream.readObject();
        inputStream.close();
        return object;
    }
}
