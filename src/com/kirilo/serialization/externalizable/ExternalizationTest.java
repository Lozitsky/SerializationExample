package com.kirilo.serialization.externalizable;

import com.kirilo.serialization.SerializationUtil;

import java.io.File;
import java.io.IOException;

public class ExternalizationTest {
    public static void main(String[] args) {
        File tempFile = new File("E:/Temp/" + "externalization" + 1473756536901471956L + "serial");
        Person person = new Person();
        person.setId(200);
        person.setName("Some Person");
        person.setGender("male");
        try {
            SerializationUtil.serialize(person, tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("SerializationUtil.serialize: " + person);

        Person personNew = null;
        try {
            personNew = (Person) SerializationUtil.deserialize(tempFile.getAbsolutePath());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("SerializationUtil.deserialize: " + personNew);
    }
}
