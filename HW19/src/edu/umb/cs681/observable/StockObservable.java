package edu.umb.cs681.observable;

public class StockObservable extends Observable<StockEvent> {
	private String ticker; 
	private double quote;
	
	public void changeQuote(String t, double q) {
		ticker = t;
		quote = q;
		notifyObservers( new StockEvent(ticker, quote) );
	}

}
