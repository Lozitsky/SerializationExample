package com.kirilo.serialization.proxy;

import java.io.*;

public class Data implements Serializable {
    private static final long serialVersionUID = 2769537668196960555L;
    private String data;

    public Data(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data{" +
                "data='" + data + '\'' +
                '}';
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new DataProxy(this);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        throw new InvalidObjectException("Proxy is not used, something fishy");
    }

    private static class DataProxy implements Serializable {
        private static final long serialVersionUID = 6794394316053150115L;
        private static final String PREFIX = "ABCD";
        private static final String SUFFIX = "EFG";
        private String dataProxy;

        public DataProxy(Data dataProxy) {
            this.dataProxy = PREFIX + dataProxy.data + SUFFIX;
        }

        private Object readResolve() throws ObjectStreamException {
            if (dataProxy.startsWith(PREFIX) && dataProxy.endsWith(SUFFIX)) {
                return new Data(dataProxy.substring(PREFIX.length(), dataProxy.length() - SUFFIX.length()));
            } else throw new InvalidObjectException("data corrupted");
        }
    }


}
