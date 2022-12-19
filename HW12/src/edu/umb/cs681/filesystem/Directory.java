package edu.umb.cs681.filesystem;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {

    private final LinkedList<FSElement> children = new LinkedList<>();
    private final LinkedList<Directory> directoryList = new LinkedList<>();
    private final LinkedList<File> fileList = new LinkedList<>();

    public Directory(Directory parent, String name, int size, LocalDateTime createdTime) {
        super(parent, name, size, createdTime);
        if(parent != null) {
            parent.appendChild(this);
        }
    }

    public LinkedList<FSElement> getChildren() {
        this.lock.lock();
        try {
            return this.children;
        } finally {
            this.lock.unlock();
        }
    }

    public void appendChild(FSElement child) {
        this.lock.lock();
        try {
            this.children.add(child);
            child.setParent(this);
        } finally {
            this.lock.unlock();
        }
    }

    public int countChildren() {
        this.lock.lock();
        try {
            return getChildren().size();
        } finally {
            this.lock.unlock();
        }

    }

    public LinkedList<Directory> getSubDirectories() {
        this.lock.lock();
        try {
            for (FSElement fsElement : getChildren()) {
                if (fsElement instanceof Directory)
                    directoryList.add((Directory) fsElement);
            }
            return directoryList;
        } finally {
            this.lock.unlock();
        }
    }

    public LinkedList<File> getFiles() {
        this.lock.lock();
        try {
            for (FSElement fsElement : getChildren()) {
                if (fsElement instanceof File) {
                    fileList.add((File) fsElement);
                }
            }
            return fileList;
        } finally {
            this.lock.unlock();
        }

    }

    public int getTotalSize() {
        this.lock.lock();
        try {
            int totalSize = 0;
            for (FSElement fsElement : getChildren()) {
                if (fsElement instanceof Directory)
                    totalSize += ((Directory) fsElement).getTotalSize();
                else
                    totalSize += fsElement.getSize();
            }
            return totalSize;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean isDirectory() {
        return true;
    }

}