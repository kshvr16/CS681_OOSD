package edu.umb.cs681.accesscounter;

import java.nio.file.Path;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {
    private static AccessCounter instance = null;
    private static ReentrantLock staticLock = new ReentrantLock();
    private ConcurrentHashMap<Path, AtomicInteger> pathCounter= new ConcurrentHashMap<>();

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
        pathCounter.compute(path, (Path p, AtomicInteger count) ->
                count==null ? new AtomicInteger(1) : new AtomicInteger(count.incrementAndGet()));
    }

    public int getCount(Path path) {
        return pathCounter.getOrDefault(path, new AtomicInteger(0)).get();
    }
}
