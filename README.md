# Car-Rental-System
Car Rental System
A desktop application built using Java Swing and MySQL (via XAMPP), designed to manage car rental operations for administrators and customers.

# Features
Add, view, and manage cars (admin)

Add and view customers

Book cars (customer)

View available cars

Make payments for bookings

View booking history

Admin panel for system control

# Project Structure
src/com/carrental/

MainFrame.java: Main navigation window with access to all features

AdminPanel.java: Admin controls for managing cars and customers

CarManager.java: Interface to add new cars to the system

CustomerManager.java: Interface to add customers

BookCar.java: Booking window for users to rent a car

PaymentFrame.java: Interface to record payments

BookingHistory.java: View past bookings

ViewCars.java: Display list of all cars

ViewCustomers.java: Display list of all customers

DBConnection.java: Handles MySQL connection using JDBC

# Diagrams
 Use Case Diagram
 Visualizes user interaction (Customer and Admin) with the system's functionalities.
 
![Screenshot 2025-04-23 235654](https://github.com/user-attachments/assets/99f8720b-5d6e-42a9-ac5a-1c6a9211c72d)

Activity Diagram
Illustrates the process of booking a car and making a payment.

![Screenshot 2025-04-23 235728](https://github.com/user-attachments/assets/bb933b63-251c-4803-ba0d-3bd8e26d66a6)

Class Diagram
Represents relationships between all Java classes, including model classes and interface logic.

![Screenshot 2025-04-23 235926](https://github.com/user-attachments/assets/5911a2ba-4ee7-476a-9567-9beaa1cd3a6a)


# Usage Guide
Add Car (Admin):

Open Admin Panel → Click Add Car

Enter car details (model, number, type, price, availability)

Click "Add Car"

Add Customer (Admin):

Open Admin Panel → Click Add Customer

Enter customer name and email

Click "Save"

Book a Car (Customer):

Click Book Car → Choose available car and enter booking details

Confirm to save booking

Make Payment:

Click Payment → Enter customer name and payment amount

Click "Pay"

View Cars / Customers / History:

Navigate using respective buttons from the main frame

Data is retrieved dynamically from the MySQL database


