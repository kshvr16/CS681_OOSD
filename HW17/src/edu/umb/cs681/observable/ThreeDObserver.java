package edu.umb.cs681.observable;

public class ThreeDObserver implements Observer<StockEvent> {
    public void update(Observable<StockEvent> sender, StockEvent event) {
        System.out.println("From 3DObserver --> Event: " + event + ", Sender: " + sender);
    }
}
