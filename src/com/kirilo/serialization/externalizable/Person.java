package com.kirilo.serialization.externalizable;

import java.io.*;

public class Person implements Externalizable {
    private int id;
    private String name;
    private String gender;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject(name + "123");
        out.writeObject("abc" + gender);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readInt();
        name = (String) in.readObject();
        if (name == null || !name.endsWith("123")) {
            throw new InvalidObjectException("corrupted data");
        }
        name = name.substring(0, name.length() - "123".length());
        gender = (String) in.readObject();
        if (gender == null || !gender.startsWith("abc")) {
            throw new InvalidObjectException("corrupted data");
        }
        gender = gender.substring("abc".length());
    }
}
