package com.carrental;

import javax.swing.*;
import java.sql.*;

public class CarManager extends JFrame {
    public CarManager() {
        setTitle("Add Car");
        setSize(300, 300); // Increased size to accommodate new fields
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Labels
        JLabel modelLabel = new JLabel("Car Model:");
        modelLabel.setBounds(10, 20, 100, 25);
        JLabel numberLabel = new JLabel("Car Number:");
        numberLabel.setBounds(10, 60, 100, 25);
        JLabel typeLabel = new JLabel("Car Type:");
        typeLabel.setBounds(10, 100, 100, 25);
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(10, 140, 100, 25);
        JLabel availabilityLabel = new JLabel("Availability:");
        availabilityLabel.setBounds(10, 180, 100, 25);

        // Text Fields
        JTextField modelField = new JTextField();
        modelField.setBounds(120, 20, 150, 25);
        JTextField numberField = new JTextField();
        numberField.setBounds(120, 60, 150, 25);
        JTextField typeField = new JTextField();
        typeField.setBounds(120, 100, 150, 25);
        JTextField priceField = new JTextField();
        priceField.setBounds(120, 140, 150, 25);
        JTextField availabilityField = new JTextField();
        availabilityField.setBounds(120, 180, 150, 25);

        // Add Car Button
        JButton addCarBtn = new JButton("Add Car");
        addCarBtn.setBounds(90, 220, 100, 30);

        addCarBtn.addActionListener(e -> {
            try (Connection conn = DBConnection.connect();
                 PreparedStatement stmt = conn.prepareStatement(
                         "INSERT INTO cars (model, number, type, price, availability) VALUES (?, ?, ?, ?, ?)")) {
                stmt.setString(1, modelField.getText());
                stmt.setString(2, numberField.getText());
                stmt.setString(3, typeField.getText());
                stmt.setDouble(4, Double.parseDouble(priceField.getText())); // Assuming the price is a valid double
                stmt.setString(5, availabilityField.getText());

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Car Added");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error adding car");
            }
        });

        // Add components to frame
        add(modelLabel); add(modelField);
        add(numberLabel); add(numberField);
        add(typeLabel); add(typeField);
        add(priceLabel); add(priceField);
        add(availabilityLabel); add(availabilityField);
        add(addCarBtn);

        setVisible(true);
    }
}
