package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("Files/v2.png");
        FileOutputStream fileOutputStream = new FileOutputStream(file);


        File fileDir = new File("Files/v2");
        String[] filenames = fileDir.list();
        ArrayList<MyThread> threads = new ArrayList<>();
        for (String filename : filenames) {
            MyThread thread = new MyThread("Files/v2/" + filename);
            thread.run();
            threads.add(thread);
        }
        for (Thread thread:threads){
            try{
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        Collections.sort(threads, new Comparator<MyThread>() {
            public int compare(MyThread thread1, MyThread thread2) {
                if (thread1.part > thread2.part) {
                    return 1;
                }
                return -1;
            }
        });
        for (MyThread thread:threads){
            fileOutputStream.write(thread.data);
            fileOutputStream.flush();
        }
    }
}