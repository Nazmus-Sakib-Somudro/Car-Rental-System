package com.carrental;

import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JFrame {
    public AdminPanel() {
        setTitle("Admin Panel");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10)); // Added gaps for better spacing

        // Label
        JLabel label = new JLabel("Admin Panel - Manage Everything", SwingConstants.CENTER);
        
        // Buttons
        JButton addCarBtn = new JButton("Add Car");
        JButton addCustomerBtn = new JButton("Add Customer");
        JButton viewCarsBtn = new JButton("View Cars");
        JButton viewCustomersBtn = new JButton("View Customers");

        // Action listeners with error handling
        addCarBtn.addActionListener(e -> {
            try {
                new CarManager();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error opening Add Car: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        addCustomerBtn.addActionListener(e -> {
            try {
                new CustomerManager();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error opening Add Customer: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        viewCarsBtn.addActionListener(e -> {
            try {
                new ViewCars();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error opening View Cars: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        viewCustomersBtn.addActionListener(e -> {
            try {
                new ViewCustomers();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error opening View Customers: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        // Add components
        add(label);
        add(addCarBtn);
        add(addCustomerBtn);
        add(viewCarsBtn);
        add(viewCustomersBtn);

        setVisible(true);
    }
}