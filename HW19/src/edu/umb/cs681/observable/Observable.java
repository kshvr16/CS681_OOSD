package edu.umb.cs681.observable;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Observable<StockEvent> {
	private ConcurrentLinkedQueue<Observer<StockEvent>> observers = new ConcurrentLinkedQueue<>();
	private ReentrantLock lockObs = new ReentrantLock();

	public void addObserver(Observer<StockEvent> observer) {
		observers.add(observer);
	}

	public void clearObservers() {
		observers.clear();
	}
	public ConcurrentLinkedQueue<Observer<StockEvent>> getObservers(){
		return observers;
	}
	
	public int countObservers() {
		return observers.size();
	}

	public void removeObserver(Observer<StockEvent> observer) {
		observers.remove(observer);
	}

	public void notifyObservers(StockEvent event) {
		ConcurrentLinkedQueue<Observer<StockEvent>> observersLocal = observers;
		observersLocal.forEach( (observer)-> observer.update(this, event));
	}
	
}
