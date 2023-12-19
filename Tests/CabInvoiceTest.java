import com.bridgelabz.cabinvoicegenerator.CabInvoiceGenerator;
import com.bridgelabz.cabinvoicegenerator.EnhancedInvoice;
import com.bridgelabz.cabinvoicegenerator.Rides;
import org.junit.Test;

import static org.junit.Assert.*;

public class CabInvoiceTest {
    @Test
    public void calculateFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double cost = cabInvoiceGenerator.calculateFare(0.1, 1);
        assertEquals(5.0, cost, 0.0);

        cost = cabInvoiceGenerator.calculateFare(10, 5);
        assertEquals(105, cost, 0.0);
    }

    @Test
    public void getEnhancedInvoice(){
        Rides rides = new Rides();
        rides.addANewRide("userId1",10,2);
        rides.addANewRide("userId1",3,1);
        rides.addANewRide("userId1",15,10);
        EnhancedInvoice enhancedInvoice = new EnhancedInvoice(3,293.0,97.66666666666667);
        assertEquals(rides.getEnhancedInvoice("userId1").getTotalNumberOfRides(),enhancedInvoice.getTotalNumberOfRides());
        assertEquals(rides.getEnhancedInvoice("userId1").getTotalFares(),enhancedInvoice.getTotalFares(),0.0);
        assertEquals(rides.getEnhancedInvoice("userId1").getAvgFarePerRide(),enhancedInvoice.getAvgFarePerRide(),0.0);
    }
}
