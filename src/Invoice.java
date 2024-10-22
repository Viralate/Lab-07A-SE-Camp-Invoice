import java.util.ArrayList;

public class Invoice {
    private ArrayList<LineItem> lineItems;
    private Customer customer;
    private String customerAddress; // Assuming you have this attribute in your class

    public Invoice(Customer customer) {
        this.customer = customer;
        this.lineItems = new ArrayList<>();
    }

    // Setter method for customerAddress
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void addLineItem(LineItem item) {
        lineItems.add(item);
    }

    public double getTotalAmountDue() {
        return lineItems.stream().mapToDouble(LineItem::getTotal).sum();
    }

    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Customer: ").append(customer.toString()).append("\n");
        builder.append("Address: ").append(customerAddress).append("\n"); // Include the address
        builder.append("Line Items:\n");
        for (LineItem item : lineItems) {
            builder.append(item.toString()).append("\n");
        }
        builder.append("Total Amount Due: $").append(getTotalAmountDue());
        return builder.toString();
    }
}
