package com.kirilo.serialization.inheritance;

import java.io.*;

public class SubClass extends SuperClass implements Serializable, ObjectInputValidation {
    private static final long serialVersionUID = -4019770647743978116L;
    private String name;

    @Override
    public String toString() {
        return "SubClass{" +
                "id='" + getId() + '\'' +
                "value='" + getValue() + '\'' +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        setId(inputStream.readInt());
        setValue((String) inputStream.readObject());
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        outputStream.writeInt(getId());
        outputStream.writeObject(getValue());
    }

    @Override
    public void validateObject() throws InvalidObjectException {
        if (name == null || "".equals(name)) throw new InvalidObjectException("name can't be null or empty");
        if (getId() <= 0) throw new InvalidObjectException("ID can't be negative or zero");
    }
}
