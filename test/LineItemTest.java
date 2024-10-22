import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LineItemTest {

    @Test
    public void testLineItemTotalCalculation() {
        Product product = new Product("Monitor", 150.00);
        LineItem lineItem = new LineItem(product, 3);
        assertEquals(450.00, lineItem.getTotal(), 0.001);
    }

    @Test
    public void testLineItemGetters() {
        Product product = new Product("Keyboard", 25.00);
        LineItem lineItem = new LineItem(product, 2);
        assertEquals(product, lineItem.getProduct());
        assertEquals(2, lineItem.getQuantity());
    }

    @Test
    public void testLineItemToString() {
        Product product = new Product("Mouse", 20.00);
        LineItem lineItem = new LineItem(product, 4);
        assertEquals("4 x Mouse ($20.00) = $80.0", lineItem.toString());
    }
}
