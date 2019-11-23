package com.kirilo.serialization.transient_keyword;

import com.kirilo.serialization.SerializationUtil;

import java.io.IOException;

public class DeserializationTest {

    public static void main(String[] args) {

        Employee employeeNew = null;
        String fileName = "E:/Temp/" + "transient" + 1473756536901471956L + "serial";
        try {
            employeeNew = (Employee) SerializationUtil.deserialize(fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("employeeNew: " + employeeNew);
        System.out.println(fileName);
    }
}
