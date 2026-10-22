# Smart-Parking-Management-System
Smart Parking Management System

Data Structures Mini Project

Project description

The Smart Parking Management System is a menu-driven Java console application that demonstrates fundamental data structures through basic parking operations. A separate HTML/CSS interface is included as a front-end demonstration.

Data structures used

- Array: Stores parking slot information and vehicle numbers.
- Singly linked list: Maintains the records of currently parked vehicles.
- Circular queue (FIFO): Stores waiting vehicles in the order they arrive when all parking slots are occupied.
- Stack (LIFO): Stores parking history, including vehicle parking and removal activities.
- Linear search: Searches for a vehicle by its registration number.

Features

- Park a vehicle in an available parking slot.
- Remove a vehicle from the parking area.
- Automatically assign an available slot to the oldest waiting vehicle.
- Display all parking slots and their availability.
- Search for a vehicle by registration number.
- Display the waiting vehicle queue.
- Display current parking records using a linked list.
- Display parking history using a stack.

Requirements

- Java Development Kit (JDK 8 or later)
- Terminal / Command Prompt or a Java IDE
- Web browser for the HTML/CSS interface

Compile and run

Open a terminal in the folder containing "SmartParkingManagementSystem.java", then run:

javac SmartParkingManagementSystem.java
java SmartParkingManagementSystem

Website

Open "index.html" in a browser to view the parking dashboard. The website uses "style.css" for styling.

Important: The website is a separate front-end demonstration and is not connected to the Java console program or a database. The data structures assessed for this project are implemented in "SmartParkingManagementSystem.java".

Sample test plan

1. Display the initial five parking slots.
2. Park vehicle "KL05AB1234" in an available slot.
3. Park additional vehicles until all five slots are occupied.
4. Enter another vehicle and verify that it is added to the waiting queue.
5. Remove a parked vehicle and check whether the oldest waiting vehicle receives the empty slot.
6. Search for a parked vehicle by its registration number.
7. Display the current parking records, waiting queue, and parking history.

Limitations

- Parking slots, vehicle records, and history are stored in memory and reset when the program exits.
- The system supports five parking slots and a maximum of twenty waiting vehicles.
- The website is a visual front-end demonstration and does not perform actual parking operations.
- This is an educational data structures project, not a production parking management system.
