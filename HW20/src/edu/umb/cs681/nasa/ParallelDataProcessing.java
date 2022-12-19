package edu.umb.cs681.nasa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import edu.umb.cs681.distance.Distance;

public class ParallelDataProcessing {

    public static void main(String[] args) throws IOException {
        String file_name = "/Users/harshavardhan/IdeaProjects/CS681/HW20/data_files/nasa_power_";

        // Used for storing all different latitude and longitude locations
        List<List<Double>> lat_long_data = new ArrayList<>();

        // Reading 10 files
        for(int file_no = 1; file_no <= 10; file_no++) {
            String file_path = file_name + file_no + ".csv";
            Path path = Paths.get(file_path);

            Stream<String> lines = Files.lines(path);
            List<List<String>> matrix = lines.map(line -> Stream.of(line.split(","))
                    .collect(Collectors.toList())).collect(Collectors.toList());

            // Extracting latitude and longitude for the file in process
            List<String> splitter = matrix.get(3);
            String location = splitter.get(0);
            List<Double> curr_lat_long = new ArrayList<>();
            String[] loc = location.split(" ");
            curr_lat_long.add(Double.valueOf(loc[3]));
            curr_lat_long.add(Double.valueOf(loc[7]));
            lat_long_data.add(curr_lat_long);

            // Extracting temperature, precipitation, surface pressure for the current location
            List<Double> temp_at_2m = new ArrayList<>();
            List<Double> precipitation = new ArrayList<>();
            List<Double> surface_pressure = new ArrayList<>();
            for(int i = 12; i < matrix.size(); i++) {
                List<String> data = matrix.get(i);
                temp_at_2m.add(Double.valueOf(data.get(3)));
                precipitation.add(Double.valueOf(data.get(4)));
                surface_pressure.add(Double.valueOf(data.get(5)));
            }

            // Calculating minimum, maximum and average temperature for the current location
            Double minTemp = temp_at_2m.stream().parallel().min(Comparator.comparing(value -> value)).get();
            Double maxTemp = temp_at_2m.stream().parallel().max(Comparator.comparing(value -> value)).get();
            Double avgTemp = temp_at_2m.stream().parallel().reduce(new double[2], (result, temp) -> {
                double[] res = new double[2];
                res[1] = ((result[0] * result[1]) + temp) / ++result[0];
                res[0] = result[0];
                return res;
            }, (finalResult, intermediateResult) -> finalResult)[1];

            // Calculating minimum, maximum and average precipitation for the current location
            Double minPre = precipitation.stream().parallel().min(Comparator.comparing(value -> value)).get();
            Double maxPre = precipitation.stream().parallel().max(Comparator.comparing(value -> value)).get();
            Double avgPre = precipitation.stream().parallel().reduce(new double[2], (result, temp) -> {
                double[] res = new double[2];
                res[1] = ((result[0] * result[1]) + temp) / ++result[0];
                res[0] = result[0];
                return res;
            }, (finalResult, intermediateResult) -> finalResult)[1];

            // Calculating minimum, maximum and average surface pressure for the current location
            Double minSp = surface_pressure.stream().parallel().min(Comparator.comparing(value -> value)).get();
            Double maxSp = surface_pressure.stream().parallel().max(Comparator.comparing(value -> value)).get();
            Double avgSp = surface_pressure.stream().parallel().reduce(new double[2], (result, temp) -> {
                double[] res = new double[2];
                res[1] = ((result[0] * result[1]) + temp) / ++result[0];
                res[0] = result[0];
                return res;
            }, (finalResult, intermediateResult) -> finalResult)[1];

            System.out.println("Below is the processed data for the current latitude " + curr_lat_long.get(0) +
                    " and current longitude " + curr_lat_long.get(1));
            System.out.println("Minimum Temperature at 2 meters: " + minTemp);
            System.out.println("Maximum Temperature at 2 meters: " + maxTemp);
            System.out.println("Average Temperature at 2 meters: " + avgTemp);
            System.out.println("\nMinimum Precipitation: " + minPre);
            System.out.println("Maximum Precipitation: " + maxPre);
            System.out.println("Average Precipitation: " + avgPre);
            System.out.println("\nMinimum Surface Pressure: " + minSp);
            System.out.println("Maximum Surface Pressure: " + maxSp);
            System.out.println("Average Surface Pressure: " + avgSp);
            System.out.println("-------------------------------------------");
        }

        // Distance between two points using Manhattan metric
        // I'm using Manhattan metric because it's more accurate to calculate as longitude might be in negatives
        System.out.println("I'm using Manhattan metric because it's more accurate to calculate " +
                "as longitude might be in negatives");
        List<Double> locationOne = lat_long_data.get(0);
        List<Double> locationTwo = lat_long_data.get(5);
        double distanceBetweenTwoLocations = Distance.get(locationOne, locationTwo, (List<Double> point1, List<Double> point2) -> {
            double distance = 0.0;
            for (int i = 0; i < point1.size(); i++) {
                distance += Math.abs(point1.get(i) - point2.get(i));
            }
            return distance;
        });
        System.out.println("\nManhattan distance between two locations is " + distanceBetweenTwoLocations);

        // Distance matrix of all the locations
        List<List<Double>> manhattanDistanceMatrix = Distance.matrix(lat_long_data,
                (List<Double> point1, List<Double> point2) -> {
                    double distance = 0;
                    for (int i = 0; i < point1.size(); i++) {
                        distance += Math.abs(point1.get(i) - point2.get(i));
                    }
                    return distance;
                });
        System.out.println("\nManhattan distance matrix of all the locations:");
        for(List<Double> metrics : manhattanDistanceMatrix) {
            System.out.println(metrics);
        }
    }

}
