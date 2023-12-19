package com.bridgelabz.cabinvoicegenerator;

import java.util.List;

public class CabInvoiceGenerator {
    /*
    @desc: given distance and time returns fare
    @params: distance, time in mins
    @return: total fare
     */
    public double calculateFare(double distance, double timeInMin) {
        return Math.max(10 * distance + timeInMin, 5);
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
    @return: total fare
*/
    public EnhancedInvoice calculateEnhancedInvoice(List<Double> distances, List<Double> timesInMin) {
        int totalNumberOfRides = distances.size();
        double totalFares = calculateTotal(distances,timesInMin);
        double avgFarePerRide;

        avgFarePerRide = totalFares / totalNumberOfRides;

        return new EnhancedInvoice(totalNumberOfRides, totalFares, avgFarePerRide);
    }
}
