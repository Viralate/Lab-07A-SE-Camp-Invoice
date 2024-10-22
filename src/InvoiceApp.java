import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvoiceApp {
    // Make Invoice a class-level field
    private static Invoice invoice = new Invoice(null); // Initialize with null, set later

    public static void main(String[] args) {
        JFrame frame = new JFrame("Invoice Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));

        // Customer details input
        JLabel lblCustomerName = new JLabel("Customer Name:");
        JTextField txtCustomerName = new JTextField();
        panel.add(lblCustomerName);
        panel.add(txtCustomerName);

        JLabel lblStreet = new JLabel("Street:");
        JTextField txtStreet = new JTextField();
        panel.add(lblStreet);
        panel.add(txtStreet);

        JLabel lblCity = new JLabel("City:");
        JTextField txtCity = new JTextField();
        panel.add(lblCity);
        panel.add(txtCity);

        JLabel lblState = new JLabel("State:");
        JTextField txtState = new JTextField();
        panel.add(lblState);
        panel.add(txtState);

        JLabel lblZip = new JLabel("Zip Code:");
        JTextField txtZip = new JTextField();
        panel.add(lblZip);
        panel.add(txtZip);

        // Product and line item details input
        JLabel lblProductName = new JLabel("Product Name:");
        JTextField txtProductName = new JTextField();
        panel.add(lblProductName);
        panel.add(txtProductName);

        JLabel lblUnitPrice = new JLabel("Unit Price:");
        JTextField txtUnitPrice = new JTextField();
        panel.add(lblUnitPrice);
        panel.add(txtUnitPrice);

        JLabel lblQuantity = new JLabel("Quantity:");
        JTextField txtQuantity = new JTextField();
        panel.add(lblQuantity);
        panel.add(txtQuantity);

        // Buttons and output area
        JButton btnAddLineItem = new JButton("Add Line Item");
        JButton btnDisplayInvoice = new JButton("Display Invoice");
        panel.add(btnAddLineItem);
        panel.add(btnDisplayInvoice);

        JTextArea txtInvoiceDisplay = new JTextArea();
        txtInvoiceDisplay.setEditable(false);
        txtInvoiceDisplay.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JScrollPane scrollPane = new JScrollPane(txtInvoiceDisplay);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.NORTH);

        // Button actions
        btnAddLineItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String productName = txtProductName.getText();
                double unitPrice = Double.parseDouble(txtUnitPrice.getText());
                int quantity = Integer.parseInt(txtQuantity.getText());
                Product product = new Product(productName, unitPrice);
                LineItem item = new LineItem(product, quantity);
                invoice.addLineItem(item);
                txtProductName.setText("");
                txtUnitPrice.setText("");
                txtQuantity.setText("");
            }
        });

        btnDisplayInvoice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = txtCustomerName.getText();
                Address address = new Address(txtStreet.getText(), txtCity.getText(), txtState.getText(), txtZip.getText());
                Customer customer = new Customer(name, address);
                invoice = new Invoice(customer); // Update the class-level Invoice
                invoice.setCustomerAddress(address.toString()); // Set the address using the setter
                txtInvoiceDisplay.setText(invoice.toString());
            }
        });

        frame.setVisible(true);
    }
}
