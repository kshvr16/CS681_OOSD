package edu.umb.cs681.concurrentsingleton;

import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentSingleton implements Runnable {
    private static ConcurrentSingleton instance = null;
    private static ReentrantLock lock = new ReentrantLock();

    private ConcurrentSingleton() {

    }

    public static ConcurrentSingleton getInstance() {
        lock.lock();
        try {
            if(instance == null) {
                instance = new ConcurrentSingleton();
            }
            return instance;
        } finally {
            lock.unlock();
        }
    }

    public void run() {
        System.out.println(ConcurrentSingleton.getInstance());
    }

    public static void main(String[] args) {
        ConcurrentSingleton concurrentSingletonOne = new ConcurrentSingleton();
        Thread threadOne = new Thread(concurrentSingletonOne);

        ConcurrentSingleton concurrentSingletonTwo = new ConcurrentSingleton();
        Thread threadTwo = new Thread(concurrentSingletonTwo);

        ConcurrentSingleton concurrentSingletonThree = new ConcurrentSingleton();
        Thread threadThree = new Thread(concurrentSingletonThree);

        ConcurrentSingleton concurrentSingletonFour = new ConcurrentSingleton();
        Thread threadFour = new Thread(concurrentSingletonFour);

        ConcurrentSingleton concurrentSingletonFive = new ConcurrentSingleton();
        Thread threadFive = new Thread(concurrentSingletonFive);

        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();
        threadFive.start();
    }

}
