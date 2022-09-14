package edu.umb.cs681.observer;

@FunctionalInterface
public interface Observer<T> {
    void update(Observable<T> sender, T event);
}
