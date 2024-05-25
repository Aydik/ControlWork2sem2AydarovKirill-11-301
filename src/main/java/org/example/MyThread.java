package org.example;

import java.io.*;

public class MyThread extends Thread {
    String filename;
    public int part;
    byte[] data;
    MyThread(String filename){
        this.filename = filename;
    }
    @Override
    public void run() {
        try (DataInputStream is = new DataInputStream(new FileInputStream(filename))) {
            int sz = is.readInt();
            data = is.readNBytes(sz);
            int even = is.readInt();
            part = is.readInt();
            int controlNumber = countOne(data);
            if(controlNumber % 2 != even) throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int countOne(byte[] data){
        int controlNumber = 0;
        for(byte b: data){
            for (int i = 0; i < 8; i ++){
                controlNumber += (b & ( 1 << i)) >> i;
            }
        }
        return controlNumber;
    }
}