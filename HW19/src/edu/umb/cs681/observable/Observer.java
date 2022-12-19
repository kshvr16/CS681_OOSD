package edu.umb.cs681.observable;

public interface Observer<StockEvent> {
	void update(Observable<StockEvent> sender, StockEvent event);
}
