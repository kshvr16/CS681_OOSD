package edu.umb.cs681.immutable;

import java.util.concurrent.locks.ReentrantLock;

public class Aircraft {
    private Position position;
    private ReentrantLock lock = new ReentrantLock();

    public Aircraft(Position position) {
        this.position = position;
    }

    public void setPosition(double newLatitude, double newLongitude, double newAltitude) {
        this.lock.lock();
        try {
            this.position = this.position.change(newLatitude, newLongitude, newAltitude);
            System.out.println("Position of Aircraft is set at: " + this.position);
        } finally {
            this.lock.unlock();
        }

    }

    public Position getPosition() {
        this.lock.lock();
        try {
            return this.position;
        } finally {
            this.lock.unlock();
        }
    }

}
