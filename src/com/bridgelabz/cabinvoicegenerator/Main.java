package com.bridgelabz.cabinvoicegenerator;

public class Main {
    public static void main(String[] args) {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator(0.1,1);
        System.out.println(cabInvoiceGenerator.calculateFare());

        Rides rides = new Rides();
        rides.addANewRide("userId1",10,2);
        rides.addANewRide("userId1",3,1);
        rides.addANewRide("userId1",15,10);
        EnhancedInvoice enhancedInvoice = rides.getEnhancedInvoice("userId1");
        System.out.println(enhancedInvoice);
    }
}