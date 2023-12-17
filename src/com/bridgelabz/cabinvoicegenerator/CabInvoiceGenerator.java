package com.bridgelabz.cabinvoicegenerator;

public class CabInvoiceGenerator {

    /*
    @desc: given distance and time return cost
    @params: distance, time in mins
    @return: total fare
     */
    public double calculateFare(double distance,double timeInMin){
        double cost = 5;
        cost = Math.max(10*distance + timeInMin,cost);
        return cost;
    }
}
