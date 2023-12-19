package com.bridgelabz.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
@desc: stores all the ride history of a given user
 */
public class Rides {
    Map<String, List<CabInvoiceGenerator>> rides;

    //constructor
    public Rides() {
        this.rides = new HashMap<>();
    }

    /*
    @desc: add a new ride of given userId
    @params: userId,distance,timeInMin
    @return:
     */
    public void addANewRide(String userId, double distance, double timeInMin) {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator(distance, timeInMin);
        if(rides.containsKey(userId)){
            List<CabInvoiceGenerator> list = rides.get(userId);
            list.add(cabInvoiceGenerator);
            rides.put(userId,list);
        }else{
            List<CabInvoiceGenerator> list = new ArrayList<>();
            list.add(cabInvoiceGenerator);
            rides.put(userId,list);
        }
    }

    /*
    @desc: returns list of given userId
     */
    private List<CabInvoiceGenerator> getRides(String userId){
        if(rides.containsKey(userId)){
            return rides.get(userId);
        }else{
            return new ArrayList<>();
        }
    }


    /*
    @desc: returns enhancedInvoice of given userId
    @params: userId
    @return: enhancedInvoice
     */
    public EnhancedInvoice getEnhancedInvoice(String userId){
        List<CabInvoiceGenerator> list = getRides(userId);
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        return cabInvoiceGenerator.calculateEnhancedInvoice(list);
    }
}
