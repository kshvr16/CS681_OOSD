package edu.umb.cs681.immutable;

public class AircraftRunnable implements Runnable {

    @Override
    public void run() {
        Aircraft aircraft = new Aircraft(new Position(15.0, 30.0, 10.0));
        Position currPosition = aircraft.getPosition();
        System.out.println("Current Position of aircraft is: " + currPosition);
        aircraft.setPosition(22.0, 22.0, 22.0);
        currPosition = aircraft.getPosition();
        System.out.println("Current Position of aircraft is: " + currPosition);
    }

    public static void main(String[] args) {
        AircraftRunnable aircraftOne = new AircraftRunnable();
        Thread threadAircraftOne = new Thread(aircraftOne);
        Thread threadAircraftTwo = new Thread(aircraftOne);
        Thread threadAircraftThree = new Thread(aircraftOne);
        Thread threadAircraftFour = new Thread(aircraftOne);
        Thread threadAircraftFive = new Thread(aircraftOne);

        threadAircraftOne.start();
        threadAircraftTwo.start();
        threadAircraftThree.start();
        threadAircraftFour.start();
        threadAircraftFive.start();

        try {
            threadAircraftOne.join();
            threadAircraftTwo.join();
            threadAircraftThree.join();
            threadAircraftFour.join();
            threadAircraftFive.join();
        } catch(InterruptedException exception) {
            System.out.println(exception);
        }

    }

}
