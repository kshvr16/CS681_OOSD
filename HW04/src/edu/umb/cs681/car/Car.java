package edu.umb.cs681.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Car {

    private String model;
    private String make;
    private int mileage;
    private int year;
    private int price;
    private int dominationCount;

    public Car(String model, String make, int mileage, int year, int price) {
        this.model = model;
        this.make = make;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    public String getModel() {
        return this.model;
    }

    public String getMake() {
        return this.make;
    }

    public int getMileage() {
        return this.mileage;
    }

    public int getYear() {
        return this.year;
    }

    public int getPrice() {
        return this.price;
    }

    public int getDominationCount() {
        return this.dominationCount;
    }

    public void setDominationCount(ArrayList<Car> cars) {
        int dominationCount = 0;
        for(Car car : cars) {
            if(!car.equals(this)) {
                if((this.getPrice() <= car.getPrice() && this.getYear() >= car.getYear() && this.getMileage() <= car.getMileage())
                        && (this.getPrice() < car.getPrice() || this.getYear() > car.getYear() || this.getMileage() < car.getMileage())) {
                    dominationCount++;
                }
            }
        }
        this.dominationCount = dominationCount;
    }

    @Override
    public String toString() {
        return "Car --> {model: " + this.model + ", make: " + this.make + ", mileage: " +
                this.mileage + ", year: " + this.year + ", price: " + price + "}";
    }

    public static void main(String[] args) {

        Car carOne = new Car("BMW", "X3", 1000, 2021, 40000);
        Car carTwo = new Car("Audi", "A8", 4000, 2018, 20000);
        Car carThree = new Car("Tesla", "Y", 500, 2022, 50000);
        Car  carFour = new Car("Volvo", "XC60", 2000, 2021, 30000);
        Car carFive = new Car("Tesla", "X", 100, 2022, 55000);

        ArrayList<Car> carsList = new ArrayList<>();
        Collections.addAll(carsList, carOne, carTwo, carThree, carFour, carFive);
        for(Car car : carsList){
            car.setDominationCount(carsList);
        }

        // getting the minimum price of given list of prices using min() and streams
        Integer minPrice = carsList.stream().map(Car::getPrice).min(Comparator.comparing(price -> price)).get();
        System.out.println("The minimum price in the given list of prices is: " + minPrice);

        // getting the maximum price of given list of prices using min() and streams
        Integer maxPrice = carsList.stream().map(Car::getPrice).max(Comparator.comparing(price -> price)).get();
        System.out.println("The maximum price in the given list of prices is: " + maxPrice);

        // Computing average price of all the prices using 3rd version of reduce
        Integer averagePrice = carsList.stream().map(Car::getPrice).reduce(new int[2], (result, price) -> {
                                int[] res = new int[2];
                                res[1] = ((result[0] * result[1]) + price) / ++result[0];
                                res[0] = result[0];
                                return res;
                }, (finalResult, intermediateResult) -> finalResult)[1];

        System.out.println("The average price of the given prices is: " + averagePrice);

    }

}