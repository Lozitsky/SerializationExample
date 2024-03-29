package com.kirilo.serialization.inheritance;

import com.kirilo.serialization.SerializationUtil;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class InheritanceSerializationTest {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.setId(100);
        subClass.setValue("someValue");
        subClass.setName("Noname");

        File tempFile = null;
        try {
            tempFile = File.createTempFile("subclass", "serial");
            SerializationUtil.serialize(subClass, tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String absolutePath = Objects.requireNonNull(tempFile).getAbsolutePath();
            System.out.println("File name:" + absolutePath);
            SubClass subClassNew = (SubClass) SerializationUtil.deserialize(absolutePath);
            System.out.println("Deserialize class: " + subClassNew);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
