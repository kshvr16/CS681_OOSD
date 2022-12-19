package edu.umb.cs681.admissionmonitor;

import java.util.concurrent.locks.ReentrantLock;

public class EntranceHandler implements Runnable {
    private AdmissionMonitor admissionMonitor;
    private ReentrantLock lock = new ReentrantLock();
    private volatile boolean done = false;

    public EntranceHandler(AdmissionMonitor admissionMonitor) {
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
                System.out.println("Monitor for Entrance Handler Exited");
            }
            admissionMonitor.enter();
        } finally {
            this.lock.unlock();
        }
    }
}
