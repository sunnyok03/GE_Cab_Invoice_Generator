package com.bridgelabz.cabinvoicegenerator;

public class EnhancedInvoice {
    private int totalNumberOfRides;
    private double totalFares;
    private double avgFarePerRide;

    public EnhancedInvoice(int totalNumberOfRides, double totalFares, double avgFarePerRide) {
        this.totalNumberOfRides = totalNumberOfRides;
        this.totalFares = totalFares;
        this.avgFarePerRide = avgFarePerRide;
    }

    public int getTotalNumberOfRides() {
        return totalNumberOfRides;
    }

    public void setTotalNumberOfRides(int totalNumberOfRides) {
        this.totalNumberOfRides = totalNumberOfRides;
    }

    public double getTotalFares() {
        return totalFares;
    }

    public void setTotalFares(double totalFares) {
        this.totalFares = totalFares;
    }

    public double getAvgFarePerRide() {
        return avgFarePerRide;
    }

    public void setAvgFarePerRide(double avgFarePerRide) {
        this.avgFarePerRide = avgFarePerRide;
    }

    @Override
    public String toString() {
        return "EnhancedInvoice{" +
                "totalNumberOfRides=" + totalNumberOfRides +
                ", totalFares=" + totalFares +
                ", avgFarePerRide=" + avgFarePerRide +
                '}';
    }
}
