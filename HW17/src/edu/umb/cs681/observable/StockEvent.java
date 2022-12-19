package edu.umb.cs681.observable;

public class StockEvent {
    private String ticker;
    private double quote;

    public StockEvent(String ticker, double quote) {
        this.ticker = ticker;
        this.quote = quote;
    }

    public String getTicker() {
        return this.ticker;
    }

    public double getQuote() {
        return this.quote;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setQuote(double quote) {
        this.quote = quote;
    }

}
