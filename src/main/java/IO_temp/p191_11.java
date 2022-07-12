package IO_temp;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;
import java.io.File;
import java.lang.*;

public class p191_11 {
    public static void main(String[] args) throws IOException {
        File file=new File("D:/temp1.txt");
        RandomAccessFile accessFile=new RandomAccessFile(file,"rw");

        Store store1 = new Store(2.0,"zhangsan",5);
        Store store2 = new Store(1.5,"lisi",7);
    }
}

class Store{
    double price;
    String name;
    int storage;

    public Store() {
    }

    public Store(double price, String name, int storage) {
        this.price = price;
        this.name = name;
        this.storage = storage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }
}