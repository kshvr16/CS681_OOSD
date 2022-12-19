package edu.umb.cs681.observable;

public class MainRunnable implements Runnable {

    @Override
    public void run() {
        StockQuoteObservable stockQuoteObservable = new StockQuoteObservable();
        stockQuoteObservable.addObserver(new LineChartObserver());
        stockQuoteObservable.addObserver(new TableObserver());
        stockQuoteObservable.notifyObservers(new StockEvent("TestCo.", 3599.00));
        stockQuoteObservable.addObserver(new ThreeDObserver());
        stockQuoteObservable.notifyObservers(new StockEvent("TeslaCo.", 45666.22));
        stockQuoteObservable.changeQuote("TestCo.", 4500.00);
        stockQuoteObservable.notifyObservers(new StockEvent("AlphabetCo.", 50000.99));
    }

    public static void main(String[] args) {
        MainRunnable mainRunnable = new MainRunnable();
        Thread threadOne = new Thread(mainRunnable);
        Thread threadTwo = new Thread(mainRunnable);
        Thread threadThree = new Thread(mainRunnable);
        Thread threadFour = new Thread(mainRunnable);
        Thread threadFive = new Thread(mainRunnable);
        Thread threadSix = new Thread(mainRunnable);
        Thread threadSeven = new Thread(mainRunnable);
        Thread threadEight = new Thread(mainRunnable);
        Thread threadNine = new Thread(mainRunnable);
        Thread threadTen = new Thread(mainRunnable);
        Thread threadEleven = new Thread(mainRunnable);
        Thread threadTwelve = new Thread(mainRunnable);

        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();
        threadFive.start();
        threadSix.start();
        threadSeven.start();
        threadEight.start();
        threadNine.start();
        threadTen.start();
        threadEleven.start();
        threadTwelve.start();
    }
}
