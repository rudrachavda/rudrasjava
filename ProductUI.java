import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProductUI extends JFrame {

    private JLabel titleLabel, priceLabel, qtyLabel, totalLabel;
    private JTextField priceField, qtyField, totalField;
    private JComboBox<String> productBox;
    private JButton addButton, checkoutButton;
    private JPanel contentPanel, productPanel, cartPanel;

    // List of products
    private String[] products = {"Product 1", "Product 2", "Product 3"};

    // Price of each product
    private double[] prices = {10.0, 20.0, 30.0};

    public ProductUI() {
        // Set up the UI
        this.setTitle("Product Store");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);

        // Create the content panel
        contentPanel = new JPanel(new BorderLayout());

        // Create the product panel
        productPanel = new JPanel(new GridLayout(4, 2));

        // Create the product combo box
        productBox = new JComboBox<>(products);
        productPanel.add(new JLabel("Product:"));
        productPanel.add(productBox);

        // Create the price label and field
        priceLabel = new JLabel("Price:");
        productPanel.add(priceLabel);
        priceField = new JTextField(10);
        productPanel.add(priceField);

        // Create the quantity label and field
        qtyLabel = new JLabel("Quantity:");
        productPanel.add(qtyLabel);
        qtyField = new JTextField(10);
        productPanel.add(qtyField);

        // Create the add button
        addButton = new JButton("Add to cart");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected product and price
                int selectedProductIndex = productBox.getSelectedIndex();
                double selectedProductPrice = prices[selectedProductIndex];

                // Get the quantity
                int qty = Integer.parseInt(qtyField.getText());

                // Calculate the total price
                double total = selectedProductPrice * qty;

                // Update the total field
                totalField.setText(String.valueOf(total));
            }
        });
        productPanel.add(addButton);

        // Add the product panel to the content panel
        contentPanel.add(productPanel, BorderLayout.NORTH);

        // Create the cart panel
        cartPanel = new JPanel(new GridLayout(2, 2));

        // Create the total label and field
        totalLabel = new JLabel("Total:");
        cartPanel.add(totalLabel);
        totalField = new JTextField(10);
        cartPanel.add(totalField);

        // Create the checkout button
        checkoutButton = new JButton("Checkout");
        cartPanel.add(checkoutButton);

        // Add the cart panel to the content panel
        contentPanel.add(cartPanel, BorderLayout.SOUTH);

        // Add the content panel to the frame
        this.add(contentPanel);

        // Display the UI
        this.setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of the UI
        ProductUI ui = new ProductUI();
    }
}
