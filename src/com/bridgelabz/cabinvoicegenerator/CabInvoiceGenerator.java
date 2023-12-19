package com.bridgelabz.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.List;

public class CabInvoiceGenerator {
    private double distance;
    private double timeInMin;
    private final double FARE_PER_KILOMETER = 10;
    private final double MIN_FARE = 5;

    public CabInvoiceGenerator(double distance, double timeInMin){
        this.distance = distance;
        this.timeInMin = timeInMin;
    }
    public CabInvoiceGenerator(){
    }

    /*
    @desc: given distance and time returns fare of current object
    @params:
    @return: total fare
     */
    public double calculateFare() {
        return Math.max(FARE_PER_KILOMETER * this.distance + this.timeInMin, MIN_FARE);
    }

    /*
    @desc: given distance and time returns fare
    @params: distance, time in mins
    @return: total fare
     */
    public double calculateFare(double distance, double timeInMin) {
        return Math.max(FARE_PER_KILOMETER * distance + timeInMin, MIN_FARE);
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
        double totalFares = calculateTotal(distances,timesInMin);
        double avgFarePerRide = totalFares/totalNumberOfRides;

        return new EnhancedInvoice(totalNumberOfRides, totalFares, avgFarePerRide);
    }

    /*
    @desc: given rideList of a userId returns enhancedInvoice
    @params: rideList
    @return: enhancedInvoice
*/
    public EnhancedInvoice calculateEnhancedInvoice(List<CabInvoiceGenerator> rideList){
        List<Double> distances = new ArrayList<>();
        for(CabInvoiceGenerator cabInvoiceGenerator : rideList){
            distances.add(cabInvoiceGenerator.distance);
        }
        List<Double> timesInMin = new ArrayList<>();
        for(CabInvoiceGenerator cabInvoiceGenerator : rideList){
            timesInMin.add(cabInvoiceGenerator.timeInMin);
        }
        return calculateEnhancedInvoice(distances,timesInMin);
    }
}
