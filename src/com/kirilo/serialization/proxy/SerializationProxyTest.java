package com.kirilo.serialization.proxy;

import com.kirilo.serialization.SerializationUtil;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class SerializationProxyTest {
    public static void main(String[] args) {
        Data someData = new Data("Some Data...");
        File tempFile = null;
        try {
            tempFile = File.createTempFile("proxy", "serial");
            SerializationUtil.serialize(someData, tempFile);
            System.out.println("SerializationUtil.serialize(tempFile): " + someData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Data data = (Data) SerializationUtil.deserialize(Objects.requireNonNull(tempFile).getAbsolutePath());
            System.out.println("SerializationUtil.deserialize(tempFile): " + data);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
