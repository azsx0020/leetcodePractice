package com.adohong.leetcode.practice.multithread.container;

import java.util.ArrayList;
import java.util.List;

class MyContainer {

    List<Object> lists = new ArrayList<>();

    public void add(Object o) {
        lists.add(0);
    }

    public int size() {
        return lists.size();
    }

}

public class Solution {

    static final MyContainer myContainer = new MyContainer();

    private static Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    myContainer.add(new Object());
                    System.out.printf("size: %s", myContainer.size());
                    System.out.println();
                    if (myContainer.size() == 5) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        });
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                if (myContainer.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("size is 5");
                lock.notify();
            }
        });
        t2.start();
        t1.start();

    }

}
