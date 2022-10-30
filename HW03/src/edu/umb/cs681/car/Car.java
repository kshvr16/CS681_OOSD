package edu.umb.cs681.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Car {

    private final String model;
    private final String make;
    private final int mileage;
    private final int year;
    private final int price;
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
                this.mileage + ", year: " + this.year + ", price: " + price + ", Domination Count: " + dominationCount + "}";
    }

    public static Car getMedianObj(List<Car> cars) {
        int medianIndex = (int) Math.floor((cars.size()) / 2.0);
        return cars.get(medianIndex);
    }

    public static void main(String[] args) {
        Car carOne = new Car("BMW", "X3", 1000, 2021, 25000);
        Car carTwo = new Car("Audi", "A8", 4000, 2018, 20000);
        Car carThree = new Car("Tesla", "Y", 500, 2022, 50000);
        Car  carFour = new Car("Volvo", "XC60", 2000, 2021, 30000);
        Car carFive = new Car("Tesla", "X", 100, 2022, 55000);

        ArrayList<Car> carsList = new ArrayList<>();
        Collections.addAll(carsList, carOne, carTwo, carThree, carFour, carFive);
        for(Car car : carsList){
            car.setDominationCount(carsList);
        }

        // Sorting based on price
        System.out.println("Cars sorted based on price");
        List<Car> sortedCarsOnPrice = carsList.stream()
                                        .sorted(Comparator.comparing(Car::getPrice))
                                        .collect(Collectors.toList());
        for(Car car : sortedCarsOnPrice) {
            System.out.println(car);
        }

        // Sorting based on mileage
        System.out.println("\nCars sorted based on mileage");
        List<Car> sortedCarsOnMileage = carsList.stream()
                .sorted(Comparator.comparing(Car::getMileage))
                .collect(Collectors.toList());
        for(Car car : sortedCarsOnMileage) {
            System.out.println(car);
        }

        // Sorting based on year
        System.out.println("\nCars sorted based on year");
        List<Car> sortedCarsOnYear = carsList.stream()
                .sorted(Comparator.comparing(Car::getYear))
                .collect(Collectors.toList());
        for(Car car : sortedCarsOnYear) {
            System.out.println(car);
        }

        // Sorting based on pareto
        System.out.println("\nCars sorted based on Domination Count");
        List<Car> sortedCarsOnPareto = carsList.stream()
                .sorted(Comparator.comparing(Car::getDominationCount))
                .collect(Collectors.toList());
        for(Car car : sortedCarsOnPareto) {
            System.out.println(car);
        }

        // Finding median price
        int medianPrice = getMedianObj(sortedCarsOnPrice).getPrice();
        System.out.println("\nMedian Price: " + medianPrice);

        // Finding median mileage
        int medianMileage = getMedianObj(sortedCarsOnMileage).getMileage();
        System.out.println("Median Mileage: " + medianMileage);

        // Finding median year
        int medianYear = getMedianObj(sortedCarsOnYear).getYear();
        System.out.println("Median Year: " + medianYear);

        // Finding median domination count
        int medianDominationCount = getMedianObj(sortedCarsOnPareto).getDominationCount();
        System.out.println("Median Domination Count: " + medianDominationCount);
    }

}