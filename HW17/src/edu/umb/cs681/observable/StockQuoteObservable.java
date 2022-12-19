package edu.umb.cs681.observable;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class StockQuoteObservable extends Observable<StockEvent> {

    private HashMap<String, Double> mapOfTickerAndQuote = new HashMap<>();
    private ReentrantLock lockTQ = new ReentrantLock();

    public void changeQuote(String ticker, Double quote) {
        this.lockTQ.lock();
        try {
            mapOfTickerAndQuote.put(ticker, quote);
        } finally {
            this.lockTQ.unlock();
            notifyObservers(new StockEvent(ticker, quote));
        }
    }

}
