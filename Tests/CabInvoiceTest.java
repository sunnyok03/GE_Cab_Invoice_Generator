import com.bridgelabz.cabinvoicegenerator.CabInvoiceGenerator;
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
}
