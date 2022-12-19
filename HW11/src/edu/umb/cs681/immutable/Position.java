package edu.umb.cs681.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Position {
    private final double latitude;
    private final double longitude;
    private final double altitude;

    public Position(double latitude, double longitude, double altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getAltitude() {
        return this.altitude;
    }

    @Override
    public String toString() {
        return "Position --> (latitude: " + this.latitude + ", longitude: " + this.longitude + ", altitude: " + this.altitude + ")";
    }

    public boolean equals(Position position) {
        return this.toString().equals(position.toString());
    }

    List<Double> coordinate() {
        List<Double> coordinates = new ArrayList<>();
        Collections.addAll(coordinates, this.latitude, this.longitude, this.altitude);
        return coordinates;
    }

    Position change(double newLatitude, double newLongitude, double newAltitude) {
        return new Position(newLatitude, newLongitude, newAltitude);
    }

    double distanceTo(Position position) {
        return 0.0;
    }

}
