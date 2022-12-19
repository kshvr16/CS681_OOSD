package edu.umb.cs681.observable;

public class LineChartObserver implements Observer<StockEvent>{
	public void update(Observable<StockEvent> sender, StockEvent event) {
		System.out.println("From LineChartObserver --> Event: " + event + ", Sender: " + sender);
	}
}
