package com.kirilo.serialization.transient_keyword;

import com.kirilo.serialization.SerializationUtil;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class TransientSerializationTest {
    public static void main(String[] args) {
        File tempFile = new File("E:/Temp/" + "transient" + 1473756536901471956L + "serial");
        Employee employee = new Employee();
        employee.setId(100);
        employee.setName("Some Name");
        employee.setSalary(1000);

        try {
            SerializationUtil.serialize(employee, tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Employee employeeNew = null;
        try {
            employeeNew = (Employee) SerializationUtil.deserialize(Objects.requireNonNull(tempFile).getAbsolutePath());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("employee: " + employee);
        System.out.println("employeeNew: " + employeeNew);
        System.out.println(tempFile.getAbsolutePath());
    }
}
