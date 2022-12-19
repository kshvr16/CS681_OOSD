package edu.umb.cs681.observable;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Observable<StockEvent> {
	private LinkedList<Observer<StockEvent>> observers = new LinkedList<>();
	private ReentrantLock lockObs = new ReentrantLock();

	public void addObserver(Observer<StockEvent> observer) {
		this.lockObs.lock();
		try {
			observers.add(observer);
		} finally {
			this.lockObs.unlock();
		}
	}

	public void clearObservers() {
		this.lockObs.lock();
		try {
			observers.clear();
		} finally {
			this.lockObs.unlock();
		}
	}
	public List<Observer<StockEvent>> getObservers(){
		this.lockObs.lock();
		try {
			return observers;
		} finally {
			this.lockObs.unlock();
		}
	}
	
	public int countObservers() {
		this.lockObs.lock();
		try {
			return observers.size();
		} finally {
			this.lockObs.unlock();
		}
	}

	public void removeObserver(Observer<StockEvent> observer) {
		this.lockObs.lock();
		try {
			observers.remove(observer);
		} finally {
			this.lockObs.unlock();
		}
	}

	public void notifyObservers(StockEvent event) {
		LinkedList<Observer<StockEvent>> observersLocal;
		this.lockObs.lock();
		try {
			observersLocal = observers;
		} finally {
			this.lockObs.unlock();
		}
		observersLocal.forEach( (observer)-> observer.update(this, event));
	}
	
}
