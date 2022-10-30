package edu.umb.cs681.distance;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Distance {
    // default using Euclidean metric
    public static double get(List<Double> p1, List<Double> p2) {
        return Distance.get(p1, p2, (List<Double> point1, List<Double> point2) -> {
            double distance = 0.0;
            for (int i = 0; i < point1.size(); i++) {
                distance += Math.pow(point1.get(i) - point2.get(i), 2);
            }
            return Math.sqrt(distance);
        });
    }

    public static double get(List<Double> p1, List<Double> p2, DistanceMetric metric) {
        return metric.distance(p1, p2);
    }

    public static List<List<Double>> matrix(List<List<Double>> points) {
        return Distance.matrix(points, (List<Double> point1, List<Double> point2) -> {
            double distance = 0.0;
            for (int i = 0; i < point1.size(); i++) {
                distance += Math.pow(point1.get(i) - point2.get(i), 2);
            }
            return Math.sqrt(distance);
        });
    }

    public static List<List<Double>> matrix(List<List<Double>> points, DistanceMetric metric) {
        int numOfPoints = points.size();
        List<List<Double>> distanceMatrix = Distance.initDistanceMatrix(numOfPoints);
        List<Double> current, peer;

        for (int i = 0; i < numOfPoints; i++) {
            current = points.get(i);
            for (int j = 0; j < numOfPoints; j++) {
                peer = points.get(j);
                double distance = Distance.get(current, peer, metric);
                distanceMatrix.get(i).set(j, distance);
            }
        }
        return distanceMatrix;
    }

    private static List<List<Double>> initDistanceMatrix(int numOfPoints) {
        List<List<Double>> distanceMatrix = new ArrayList<>(numOfPoints);
        for (int i = 0; i < numOfPoints; i++) {
            Double[] vector = new Double[numOfPoints];
            Arrays.fill(vector, 0.0);
            distanceMatrix.add(Arrays.asList(vector));
        }
        return distanceMatrix;
    }

    public static void main(String[] args) {
        List<Double> p1 = new ArrayList<>();
        Collections.addAll(p1, 10.0, 30.0, 50.0);

        List<Double> p2 = new ArrayList<>();
        Collections.addAll(p2, 20.0, 40.0, 60.0);

        // Euclidean Distance
        double euclideanDistance = Distance.get(p1, p2);
        System.out.println("Euclidean Distance between two points is: " + euclideanDistance);

        // Manhattan Distance using Lambda Expression
        double manhattanDistance = Distance.get(p1, p2, (List<Double> point1, List<Double> point2) -> {
            double distance = 0.0;
            for (int i = 0; i < point1.size(); i++) {
                distance += Math.abs(point1.get(i) - point2.get(i));
            }
            return distance;
        });
        System.out.println("-----------------------------------------------------------");
        System.out.println("Manhattan Distance between two points is: " + manhattanDistance);

        List<List<Double>> points = new ArrayList<>();
        Collections.addAll(points, Arrays.asList(2.0, 4.0, 8.0), Arrays.asList(3.0, 6.0, 12.0),
                Arrays.asList(4.0, 8.0, 16.0), Arrays.asList(5.0, 10.0, 20.0), Arrays.asList(6.0, 12.0, 24.0));

        List<List<Double>> euclideanDistanceMatrix = Distance.matrix(points);
        System.out.println("-----------------------------------------------------------");
        System.out.println("The Euclidean Distance Matrix for the given 5 point matrix is: ");
        System.out.println(euclideanDistanceMatrix);

        // Manhattan Distance Using Lambda Expression
        List<List<Double>> manhattanDistanceMatrix = Distance.matrix(points,
                (List<Double> point1, List<Double> point2) -> {
                    double distance = 0;
                    for (int i = 0; i < point1.size(); i++) {
                        distance += Math.abs(point1.get(i) - point2.get(i));
                    }
                    return distance;
                });
        System.out.println("-----------------------------------------------------------");
        System.out.println("The Manhattan Distance Matrix for the given 5 point matrix is: ");
        System.out.println(manhattanDistanceMatrix);
    }

}