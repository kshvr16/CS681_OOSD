package edu.umb.cs681.observable;

public class TableObserver implements Observer<StockEvent> {
	public void update(Observable<StockEvent> sender, StockEvent event) {
		System.out.println("From TableObserver --> Event: " + event + ", Sender: " + sender);
	}
}
