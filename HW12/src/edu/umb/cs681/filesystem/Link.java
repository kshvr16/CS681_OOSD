package edu.umb.cs681.filesystem;

import java.time.LocalDateTime;

public class Link extends FSElement {

    private FSElement target;

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime);
        this.target = target;
        parent.appendChild(this);
    }
    public FSElement getTarget() {
        this.lock.lock();
        try {
            return this.target;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean isLink() {
        return true;
    }

}