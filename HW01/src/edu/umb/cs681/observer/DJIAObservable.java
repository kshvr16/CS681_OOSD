package edu.umb.cs681.observer;

public class DJIAObservable extends Observable<Double> {
    private double quote;

    public void changeQuote(double q) {
        quote = q;
        notifyObservers(quote);
    }

    public static void main(String[] args) {
        DJIAObservable observable = new DJIAObservable();

        Observer<Double> observerOne = (Observable<Double> sender, Double event) ->
                System.out.println("Event: " + event + ", Sender: " + sender);
        Observer<Double> observerTwo = (Observable<Double> sender, Double event) ->
                System.out.println("Sender: " + sender + ", Event: " + event);

        System.out.println("Initial Observers count: " + observable.countObservers() + "\n");

        observable.addObserver(observerOne);
        System.out.println("Observers count after first subscriber: " + observable.countObservers());
        observable.addObserver(observerTwo);
        System.out.println("Observers count after second subscriber: " + observable.countObservers() + "\n");

        System.out.println("Current Subscriptions: " + observable.getObservers() + "\n");

        System.out.println("-----First change quote-----notifies observers-----");
        observable.changeQuote(30000.00);

        System.out.println("\n-----Second change quote-----notifies observers-----");
        observable.changeQuote(45500.00);

        observable.removeObserver(observerOne);
        System.out.println("\nObservers count after first removal: " + observable.countObservers());
        observable.clearObservers();
        System.out.println("Final Observers count after clearing: " + observable.countObservers());

    }

}
