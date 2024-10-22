import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class InvoiceTest {

    @Test
    public void testAddLineItem() {
        Invoice invoice = new Invoice("1234 Elm Street");
        Product product = new Product("Desk Chair", 85.00);
        LineItem lineItem = new LineItem(product, 2);
        
        invoice.addLineItem(lineItem);
        ArrayList<LineItem> lineItems = invoice.getLineItems();
        assertEquals(1, lineItems.size());
        assertEquals(lineItem, lineItems.get(0));
    }

    @Test
    public void testGetTotalAmountDue() {
        Invoice invoice = new Invoice("5678 Maple Avenue");
        Product product1 = new Product("Bookshelf", 120.00);
        Product product2 = new Product("Lamp", 30.00);
        
        LineItem lineItem1 = new LineItem(product1, 1);
        LineItem lineItem2 = new LineItem(product2, 3);
        
        invoice.addLineItem(lineItem1);
        invoice.addLineItem(lineItem2);
        
        assertEquals(210.00, invoice.getTotalAmountDue(), 0.001);
    }

    @Test
    public void testInvoiceToString() {
        Invoice invoice = new Invoice("910 Oak Lane");
        Product product = new Product("Table", 200.00);
        LineItem lineItem = new LineItem(product, 1);
        
        invoice.addLineItem(lineItem);
        
        String expectedOutput = "Customer Address: 910 Oak Lane\n" +
                                "Line Items:\n" +
                                "1 x Table ($200.0) = $200.0\n" +
                                "Total Amount Due: $200.0";
                                
        assertEquals(expectedOutput, invoice.toString());
    }
}
