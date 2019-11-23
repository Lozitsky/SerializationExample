package com.kirilo.serialization.transient_keyword;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1473756536901471956L;
    private int id;
    private String name;
    transient private int salary;

//    ------------------------first version run with TransientSerializationTest.main---------------------------
/*    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }*/
//    ------------------------first version---------------------------

//    ------------------------second version run with DeserializationTest.main--------------------------

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

//    ------------------------second version--------------------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
