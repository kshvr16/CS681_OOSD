package edu.umb.cs681.filesystem;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class FileSystem {

    private static FileSystem instance;
    private LinkedList<Directory> rootDirs;
    private static ReentrantLock lock = new ReentrantLock();

    private FileSystem() {
        instance = null;
        rootDirs = new LinkedList<>();
    }

    public static FileSystem getFileSystem() {
        lock.lock();
        try {
            if(instance == null) {
                instance = new FileSystem();
            }
            return instance;
        } finally {
            lock.unlock();
        }
    }

    public LinkedList<Directory> getRootDirs() {
        return this.rootDirs;
    }

    public void appendRootDir(Directory root) {
        rootDirs.add(root);
    }

}