package com.carrental;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookCar extends JFrame {
    JTextField customerField, carIdField;
    JButton bookButton;

    public BookCar() {
        setTitle("Book a Car");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Customer Name:"));
        customerField = new JTextField();
        add(customerField);

        add(new JLabel("Car ID to Book:"));
        carIdField = new JTextField();
        add(carIdField);

        bookButton = new JButton("Book Car");
        add(bookButton);

        bookButton.addActionListener(e -> bookCar());

        setVisible(true);
    }

    private void bookCar() {
        String customer = customerField.getText();
        int carId = Integer.parseInt(carIdField.getText());

        try {
            Connection con = DBConnection.connect();

            // Check availability
            PreparedStatement checkStmt = con.prepareStatement("SELECT availability FROM cars WHERE id = ?");
            checkStmt.setInt(1, carId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next() && rs.getString("availability").equalsIgnoreCase("Available")) {
                // Update availability
                PreparedStatement updateStmt = con.prepareStatement("UPDATE cars SET availability='Booked' WHERE id=?");
                updateStmt.setInt(1, carId);
                updateStmt.executeUpdate();

                // Save booking
                PreparedStatement insertStmt = con.prepareStatement(
                        "INSERT INTO bookings (customer_name, car_id, booking_date) VALUES (?, ?, NOW())"
                );
                insertStmt.setString(1, customer);
                insertStmt.setInt(2, carId);
                insertStmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "Car booked successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Car not available or doesn't exist.");
            }

            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}