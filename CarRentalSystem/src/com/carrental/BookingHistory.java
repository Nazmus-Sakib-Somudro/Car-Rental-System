package com.carrental;

import javax.swing.*;

import java.io.Serializable;
import java.sql.*;

public class BookingHistory extends JFrame implements Serializable {
    
    private static final long serialVersionUID = 1L;

	public BookingHistory() {
        setTitle("Booking History");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM bookings")) {

            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append("Booking ID: ").append(rs.getInt("booking_id"))
                  .append(", Customer Name: ").append(rs.getString("customer_name"))
                  .append(", Car ID: ").append(rs.getInt("car_id"))
                  .append(", Booking Date: ").append(rs.getTimestamp("booking_date"))  // Use Timestamp for datetime column
                  .append("\n");
            }
            textArea.setText(sb.toString());

        } catch (Exception ex) {
            ex.printStackTrace();
            textArea.setText("Error loading booking history.");
        }

        setVisible(true);
    }
}