package com.adohong.leetcode.practice.multithread.consumerproducer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyContainer {

    List<Object> list = new ArrayList<>();
    int max_limit = 10;

    synchronized public void put(Object o) {
        while (list.size() == max_limit) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(o);
        this.notifyAll();
    }

    synchronized public Object get() {
        while (list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object o = list.remove(0);
        this.notifyAll();
        return o;
    }
}

class MyContainerWithReentrantLock {

    List<Object> list = new ArrayList<>();
    Lock lock = new ReentrantLock();
    Condition producer = lock.newCondition();
    Condition consumer = lock.newCondition();
    private static int MAX_LIMIT = 100;

    public void put(Object o) {
        try {
            lock.lock();
            while (list.size() == MAX_LIMIT) {
                producer.await();
            }
            list.add(o);
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Object get() {
        Object o = null;
        try {
            lock.lock();
            while (list.size() == 0) {
                consumer.await();
            }
            o = list.remove(0);
            producer.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return o;
    }
}

public class Solution {

    private final static MyContainer myContainer = new MyContainer();

    public static void main(String[] args) {
        Thread[] producers = new Thread[2];
        Thread[] consumers = new Thread[10];
        for (int i = 0; i < 2; i++) {
            Thread producer = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    myContainer.put(new Object());
                    System.out.println("produce object");
                }
            });
            producers[i] = producer;
        }

        for (int i = 0; i < 10; i++) {
            Thread consumer = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    myContainer.get();
                    System.out.println("consuming object");

                }
            });
            consumers[i] = consumer;
        }

        for (int i = 0; i < producers.length; i++) {
            producers[i].start();
        }
        for (int i = 0; i < consumers.length; i++) {
            consumers[i].start();
        }

    }
}
