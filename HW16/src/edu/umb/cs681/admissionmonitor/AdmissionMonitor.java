package edu.umb.cs681.admissionmonitor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AdmissionMonitor {
    private int countVisitors = 0;
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private Condition visitorEnter = rwLock.writeLock().newCondition();
    private Condition visitorExit = rwLock.writeLock().newCondition();

    public void enter() {
        this.rwLock.writeLock().lock();
        try {
            while(this.countVisitors >= 10) {
                System.out.println("Too many visitors. Please wait for a while.");
                try {
                    visitorExit.await();
                } catch (InterruptedException exception) {
                    System.out.println(exception);
                }
            }
            this.countVisitors++;
            System.out.println("Entering visitor");
            visitorEnter.signalAll();
        } finally {
            this.rwLock.writeLock().unlock();
        }
    }

    public void exit() {
        this.rwLock.writeLock().lock();
        try {
            while(this.countVisitors <= 0) {
                try {
                    visitorEnter.await();
                } catch(InterruptedException exception) {
                    System.out.println(exception);
                }
            }
            this.countVisitors--;
            System.out.println("Exiting visitor");
            visitorExit.signalAll();
        } finally {
            this.rwLock.writeLock().unlock();
        }
    }

    public int countCurrentVisitors() {
        this.rwLock.readLock().lock();
        try {
            return this.countVisitors;
        } finally {
            this.rwLock.readLock().unlock();
        }
    }

}
