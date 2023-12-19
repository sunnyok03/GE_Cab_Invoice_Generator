package com.bridgelabz.cabinvoicegenerator;

public class EnhancedInvoice {
    private int totalNumberOfRides;
    private double totalFares;
    private double avgFarePerRide;

    //constructor
    public EnhancedInvoice(int totalNumberOfRides, double totalFares, double avgFarePerRide) {
        this.totalNumberOfRides = totalNumberOfRides;
        this.totalFares = totalFares;
        this.avgFarePerRide = avgFarePerRide;
    }

    /*
    @desc: get number of rides
    @params:
    @return: int
     */
    public int getTotalNumberOfRides() {
        return totalNumberOfRides;
    }

    /*
    @desc: set number of rides
    @params:int
    @return:
     */
    public void setTotalNumberOfRides(int totalNumberOfRides) {
        this.totalNumberOfRides = totalNumberOfRides;
    }

    /*
     @desc: get total fare
     @params:
     @return: double
  */
    public double getTotalFares() {
        return totalFares;
    }

    /*
   @desc: set total fare
   @params:double
   @return:
*/
    public void setTotalFares(double totalFares) {
        this.totalFares = totalFares;
    }

    /*
    @desc: get avg fare
    @params:
    @return: double
    */
    public double getAvgFarePerRide() {
        return avgFarePerRide;
    }

    /*
    @desc: set avg fare
    @params: double
    @return:
    */
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
