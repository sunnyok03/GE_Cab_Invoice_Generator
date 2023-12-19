package com.bridgelabz.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.List;

public class CabInvoiceGenerator {
    private double distance;
    private double timeInMin;
    private final double NORMAL_FARE_PER_KILOMETER = 10;
    private final double NORMAL_FARE_PER_MINUTE = 1;
    private final double NORMAL_MIN_FARE = 5;
    private final double PREMIUM_FARE_PER_KILOMETER = 10;
    private final double PREMIUM_FARE_PER_MINUTE = 2;
    private final double PREMIUM_MIN_FARE = 5;

    public CabInvoiceGenerator(double distance, double timeInMin) {
        this.distance = distance;
        this.timeInMin = timeInMin;
    }

    public CabInvoiceGenerator() {
    }

    /*
    @desc: given distance and time returns fare of current object
    @params:
    @return: total fare
     */
    public double calculateFare() {
        return Math.max(NORMAL_FARE_PER_KILOMETER * this.distance + this.timeInMin * NORMAL_FARE_PER_MINUTE, NORMAL_MIN_FARE);
    }

    /*
    @desc: given distance and time returns fare
    @params: distance, time in mins
    @return: total fare
     */
    public double calculateFare(double distance, double timeInMin) {
        return Math.max(NORMAL_FARE_PER_KILOMETER * distance + timeInMin * NORMAL_FARE_PER_MINUTE, NORMAL_MIN_FARE);
    }

    /*
       @desc: given distance and time and rideType returns fare
       @params: distance, time in mins ,rideType
       @return: total fare
        */
    public double calculateFare(double distance, double timeInMin, RideType rideType) {
        if (rideType == RideType.NORMAL) {
            return Math.max(NORMAL_FARE_PER_KILOMETER * distance + timeInMin * NORMAL_FARE_PER_MINUTE, NORMAL_MIN_FARE);
        } else {
            return Math.max(PREMIUM_FARE_PER_KILOMETER * distance + PREMIUM_FARE_PER_MINUTE*timeInMin * NORMAL_FARE_PER_MINUTE, PREMIUM_MIN_FARE);
        }
    }

    /*
    @desc: given distance and time of multiple trips returns total fare
    @params: distance, time in mins
    @return: total fare
 */
    public double calculateTotal(List<Double> distances, List<Double> timesInMin) {
        double totalCost = 0;
        for (int i = 0; i < distances.size(); i++) {
            totalCost += calculateFare(distances.get(i), timesInMin.get(i));
        }
        return totalCost;
    }

    /*
    @desc: given distance and time of multiple trips returns enhancedInvoice
    @params: distance, time in mins
    @return: enhancedInvoice
*/
    public EnhancedInvoice calculateEnhancedInvoice(List<Double> distances, List<Double> timesInMin) {
        int totalNumberOfRides = distances.size();
        double totalFares = calculateTotal(distances, timesInMin);
        double avgFarePerRide = totalFares / totalNumberOfRides;

        return new EnhancedInvoice(totalNumberOfRides, totalFares, avgFarePerRide);
    }

    /*
    @desc: given rideList of a userId returns enhancedInvoice
    @params: rideList
    @return: enhancedInvoice
*/
    public EnhancedInvoice calculateEnhancedInvoice(List<CabInvoiceGenerator> rideList) {
        List<Double> distances = new ArrayList<>();
        for (CabInvoiceGenerator cabInvoiceGenerator : rideList) {
            distances.add(cabInvoiceGenerator.distance);
        }
        List<Double> timesInMin = new ArrayList<>();
        for (CabInvoiceGenerator cabInvoiceGenerator : rideList) {
            timesInMin.add(cabInvoiceGenerator.timeInMin);
        }
        return calculateEnhancedInvoice(distances, timesInMin);
    }
}
