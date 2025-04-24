package com.carrental;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ViewCustomers extends JFrame {
    JTable table;
    DefaultTableModel model;

    public ViewCustomers() {
        setTitle("View Customers");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Email");

      
        loadCustomerData();

       
        add(new JScrollPane(table), BorderLayout.CENTER);
        setVisible(true);
    }

    private void loadCustomerData() {
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customers");
             ResultSet rs = stmt.executeQuery()) {

         
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading customers: " + e.getMessage());
        }
    }
}