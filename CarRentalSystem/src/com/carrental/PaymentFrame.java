package com.carrental;

import javax.swing.*;
import java.sql.*;

public class PaymentFrame extends JFrame {
    public PaymentFrame() {
        setTitle("Payment");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel nameLabel = new JLabel("Customer Name:");
        nameLabel.setBounds(10, 20, 120, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(140, 20, 130, 25);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(10, 60, 120, 25);
        JTextField amountField = new JTextField();
        amountField.setBounds(140, 60, 130, 25);

        JButton payButton = new JButton("Pay");
        payButton.setBounds(90, 100, 100, 30);

        payButton.addActionListener(e -> {
            try (Connection conn = DBConnection.connect();
                 PreparedStatement stmt = conn.prepareStatement("INSERT INTO payments (customerName, amount, date) VALUES (?, ?, CURDATE())")) {
                stmt.setString(1, nameField.getText());
                stmt.setDouble(2, Double.parseDouble(amountField.getText()));
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Payment Successful");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Payment Failed");
            }
        });

        add(nameLabel); add(nameField);
        add(amountLabel); add(amountField);
        add(payButton);

        setVisible(true);
    }
}
