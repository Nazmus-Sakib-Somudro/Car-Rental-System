package com.carrental;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Car Rental System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        JButton adminBtn = new JButton("Admin Panel");
        JButton customerBtn = new JButton("Add Customer");
        JButton carBtn = new JButton("Add Car");
        JButton paymentBtn = new JButton("Payment");
        JButton bookingHistoryBtn = new JButton("Booking History");
        JButton viewCarsBtn = new JButton("View Cars");
        JButton bookCarBtn = new JButton("Book Car");
        JButton viewCustomersBtn = new JButton("View Customers");
        
        adminBtn.addActionListener(e -> new AdminPanel());
        customerBtn.addActionListener(e -> new CustomerManager());
        carBtn.addActionListener(e -> new CarManager());
        paymentBtn.addActionListener(e -> new PaymentFrame());
        bookingHistoryBtn.addActionListener(e -> new BookingHistory());
        viewCarsBtn.addActionListener(e -> new ViewCars());
        bookCarBtn.addActionListener(e -> new BookCar());
        viewCustomersBtn.addActionListener(e -> new ViewCustomers());
        
        add(adminBtn);
        add(customerBtn);
        add(carBtn);
        add(paymentBtn);
        add(bookingHistoryBtn);
        add(viewCarsBtn);
        add(bookCarBtn);
        add(viewCustomersBtn);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
