package com.carrental;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ViewCars extends JFrame {
    JTable table;
    DefaultTableModel model;

    public ViewCars() {
        setTitle("Available Cars");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("ID");
        model.addColumn("Model");
        model.addColumn("Number");
        model.addColumn("Type");
        model.addColumn("Price");
        model.addColumn("Availability");

        loadCarData();

        add(new JScrollPane(table), BorderLayout.CENTER);
        setVisible(true);
    }

    private void loadCarData() {
        try {
            Connection con = DBConnection.connect();
            String query = "SELECT * FROM cars";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("model"),
                        rs.getString("number"),
                        rs.getString("type"),
                        rs.getDouble("price"),
                        rs.getString("availability")
                });
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
        }
    }
}
