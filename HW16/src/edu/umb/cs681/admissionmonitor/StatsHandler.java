package edu.umb.cs681.admissionmonitor;

import java.util.concurrent.locks.ReentrantLock;

public class StatsHandler implements Runnable {
    private AdmissionMonitor admissionMonitor;
    private ReentrantLock lock = new ReentrantLock();
    private volatile boolean done = false;

    public StatsHandler(AdmissionMonitor admissionMonitor) {
        this.admissionMonitor = admissionMonitor;
    }

    public void setDone() {
        this.lock.lock();
        try {
            this.done = true;
        } finally {
            this.lock.unlock();
        }
    }

    @Override
    public void run() {
        this.lock.lock();
        try {
            if(done) {
                System.out.println("Monitor for Stats Handler Exited");
            }
            int currentCount = admissionMonitor.countCurrentVisitors();
            System.out.println("Current Visitor Count: " + currentCount);
        } finally {
            this.lock.unlock();
        }
    }
}
