package edu.umb.cs681.accesscounter;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {
    private static AccessCounter instance = null;
    private static ReentrantLock staticLock = new ReentrantLock();
    private ReentrantLock nonStaticLock = new ReentrantLock();
    private HashMap<Path, Integer> pathCounter= new HashMap<>();

    private AccessCounter() {

    }

    public static AccessCounter getInstance() {
        staticLock.lock();
        try {
            if(instance == null) {
                instance = new AccessCounter();
            }
            return instance;
        } finally {
            staticLock.unlock();
        }
    }

    public void increment(Path path) {
        this.nonStaticLock.lock();
        try {
            if(pathCounter.containsKey(path)) {
                pathCounter.put(path, pathCounter.get(path) + 1);
            } else {
                pathCounter.put(path, 1);
            }
        } finally {
            this.nonStaticLock.unlock();
        }
    }

    public int getCount(Path path) {
        this.nonStaticLock.lock();
        try {
            return pathCounter.getOrDefault(path, 0);
        } finally {
            this.nonStaticLock.unlock();
        }
    }
}
