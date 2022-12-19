package edu.umb.cs681.filesystem;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public class FSElement {

    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
    protected Directory parent;
    protected ReentrantLock lock = new ReentrantLock();

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    public String getName() {
        this.lock.lock();
        try {
            return this.name;
        } finally {
            this.lock.unlock();
        }
    }

    public int getSize() {
        this.lock.lock();
        try {
            return this.size;
        } finally {
            this.lock.unlock();
        }
    }

    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }

    public Directory getParent() {
        this.lock.lock();
        try {
            return this.parent;
        } finally {
            this.lock.unlock();
        }
    }

    public void setName(String name) {
        this.lock.lock();
        try {
            this.name = name;
        } finally {
            this.lock.unlock();
        }
    }

    public void setSize(int size) {
        this.lock.lock();
        try {
            this.size = size;
        } finally {
            this.lock.unlock();
        }
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public void setParent(Directory parent) {
        this.lock.lock();
        try {
            this.parent = parent;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean isDirectory(){
        return false;
    }

    public boolean isFile() {
        return false;
    }

    public boolean isLink() {
        return false;
    }

}