package com.carrental;

import javax.swing.*;
import java.sql.*;

public class CustomerManager extends JFrame {
    public CustomerManager() {
        setTitle("Add Customer");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 100, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(120, 20, 150, 25);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 60, 100, 25);
        JTextField emailField = new JTextField();
        emailField.setBounds(120, 60, 150, 25);

        JButton saveBtn = new JButton("Save");
        saveBtn.setBounds(90, 100, 100, 30);

        saveBtn.addActionListener(e -> {
            try (Connection conn = DBConnection.connect();
                 PreparedStatement stmt = conn.prepareStatement("INSERT INTO customers (name, email) VALUES (?, ?)")) {
                stmt.setString(1, nameField.getText());
                stmt.setString(2, emailField.getText());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Customer Added");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error adding customer");
            }
        });

        add(nameLabel); add(nameField);
        add(emailLabel); add(emailField);
        add(saveBtn);

        setVisible(true);
    }
}
