package com.adohong.leetcode.practice.multithread.container;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

class MyContainer2 {

    List<Object> lists = new ArrayList<>();

    public void add(Object o) {
        lists.add(0);
    }

    public int size() {
        return lists.size();
    }

}

public class SolutionCountDownLatch {

    private static MyContainer2 myContainer2 = new MyContainer2();
    private static CountDownLatch countDownLatch1 = new CountDownLatch(1);
    private static CountDownLatch countDownLatch2 = new CountDownLatch(1);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myContainer2.add(new Object());
                System.out.printf("add new object, size: %s", myContainer2.size());
                System.out.println();
                if (myContainer2.size() == 5) {
                    countDownLatch1.countDown();
                    try {
                        countDownLatch2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            if (myContainer2.size() != 5) {
                try {
                    countDownLatch1.await();
                    System.out.println("size is 5 now!");
                    countDownLatch2.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        t1.start();
    }
}
