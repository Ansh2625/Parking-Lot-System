# Parking Lot System - Low Level Design (LLD) <br>

A LLD implementation of real world parking lot management system using OOPS, SOLID principles and Design patterns. <br> <br>

## Problem Statement <br>

Design a Parking Lot System with following Requirements: <br>

- Have Entry and Exit gate. <br>
- Have multiple floors in the parking lot.<br>
- Vehicles Allowed : Motorcycle, Cars, Trucks, Vans. <br>
- Four types of parking spots based on Vehicle Type. <br>
- Disallow vehicle entry if parking lot reaches full capacity. <br>
- A vehicle can be parked only at the spot for its vehicle type. <br>
- Generate parking tickets with duration tracking. <br>
- Payment methods : Cash, Credit Card and UPI. <br>
- Parking charges based on Hourly Rate. <br><br>

## UML Diagrams <br>

### Use Case Diagram <br>
![Use Case](Parking-Lot-System/diagrams/Usecase_Diagram.png) <br>

### Class Diagram <br>
![Class](Parking-Lot-System/diagrams/Class_Diagram.png)<br><br>

## Design Patterns used <br>

### Factory Design Pattern <br>
- It provides a way to create objects without exposing the instantiation logic to the client. It promotes loose coupling by delegating the object creation to a specific class. <br>
- In this project, Vehicle Factory is used to create instances of different types of vehicles (Bike, Car, Van, Truck) based on parking requirement. <br>
- Advantage - Extensibility & Loose Coupling. <br>

### Strategy Design Pattern <br>
- It is used to define a group of interchangeable algorithms and choose one at runtime. <br>
- In this project, PaymentStrategy is used to support multiple payment methods like Cash, CreditCard, UPI. PaymentService uses the chosen one at runtime. <br>
- Advantage - Flexible & Interchangeable logic. <br>