package com.bridgelabz.cabinvoicegenerator;

public class Main {
    public static void main(String[] args) {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        System.out.println(cabInvoiceGenerator.calculateFare(0.1,1));
    }
}