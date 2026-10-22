import java.util.Scanner;

class SmartParkingManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static String[] parking = new String[5];

    static String[] waiting = new String[20];
    static int front = 0, rear = -1, count = 0;

    static String[] history = new String[100];
    static int top = -1;

    static class Node {
        String vehicle;
        Node next;

        Node(String vehicle) {
            this.vehicle = vehicle;
            next = null;
        }
    }

    static Node head = null;

    static boolean vehicleExists(String vehicle) {
        for (int i = 0; i < parking.length; i++) {
            if (parking[i] != null &&
                parking[i].equalsIgnoreCase(vehicle))
                return true;
        }

        for (int i = 0; i < count; i++) {
            int pos = (front + i) % waiting.length;
            if (waiting[pos].equalsIgnoreCase(vehicle))
                return true;
        }

        return false;
    }

    static void addRecord(String vehicle) {
        Node newNode = new Node(vehicle);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != null)
                temp = temp.next;

            temp.next = newNode;
        }
    }

    static void deleteRecord(String vehicle) {
        if (head == null)
            return;

        if (head.vehicle.equalsIgnoreCase(vehicle)) {
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            if (temp.next.vehicle.equalsIgnoreCase(vehicle)) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    static void addHistory(String message) {
        if (top < history.length - 1)
            history[++top] = message;
    }

    static void parkVehicle() {
        System.out.print("Enter vehicle number: ");
        String vehicle = sc.nextLine().trim();

        if (vehicle.isEmpty()) {
            System.out.println("Enter a valid vehicle number.");
            return;
        }

        if (vehicleExists(vehicle)) {
            System.out.println("Vehicle already registered.");
            return;
        }

        for (int i = 0; i < parking.length; i++) {
            if (parking[i] == null) {
                parking[i] = vehicle;
                addRecord(vehicle);
                addHistory("Parked: " + vehicle);

                System.out.println("Vehicle parked in slot " + (i + 1));
                return;
            }
        }

        if (count == waiting.length) {
            System.out.println("Parking and waiting queue are full.");
            return;
        }

        rear = (rear + 1) % waiting.length;
        waiting[rear] = vehicle;
        count++;

        System.out.println("Parking is full.");
        System.out.println("Vehicle added to waiting queue.");
    }

    static void removeVehicle() {
        System.out.print("Enter vehicle number to remove: ");
        String vehicle = sc.nextLine().trim();

        for (int i = 0; i < parking.length; i++) {
            if (parking[i] != null &&
                parking[i].equalsIgnoreCase(vehicle)) {

                parking[i] = null;
                deleteRecord(vehicle);
                addHistory("Removed: " + vehicle);

                System.out.println("Vehicle removed from slot " + (i + 1));

                if (count > 0) {
                    String nextVehicle = waiting[front];
                    waiting[front] = null;
                    front = (front + 1) % waiting.length;
                    count--;

                    parking[i] = nextVehicle;
                    addRecord(nextVehicle);
                    addHistory("Parked: " + nextVehicle);

                    System.out.println(nextVehicle +
                        " moved from waiting queue to slot " + (i + 1));
                }

                return;
            }
        }

        System.out.println("Vehicle not found in parking.");
    }

    static void displayParking() {
        System.out.println("\n--- Parking Slots ---");

        for (int i = 0; i < parking.length; i++) {
            if (parking[i] == null)
                System.out.println("Slot " + (i + 1) + ": Empty");
            else
                System.out.println("Slot " + (i + 1) + ": " + parking[i]);
        }
    }

    static void searchVehicle() {
        System.out.print("Enter vehicle number to search: ");
        String vehicle = sc.nextLine().trim();

        for (int i = 0; i < parking.length; i++) {
            if (parking[i] != null &&
                parking[i].equalsIgnoreCase(vehicle)) {
                System.out.println("Vehicle found in slot " + (i + 1));
                return;
            }
        }

        System.out.println("Vehicle not found in parking.");
    }

    static void displayWaiting() {
        System.out.println("\n--- Waiting Vehicles ---");

        if (count == 0) {
            System.out.println("No vehicles waiting.");
            return;
        }

        for (int i = 0; i < count; i++) {
            int pos = (front + i) % waiting.length;
            System.out.println(waiting[pos]);
        }
    }

    static void displayRecords() {
        System.out.println("\n--- Current Parking Records ---");

        if (head == null) {
            System.out.println("No vehicles parked.");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.vehicle + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    static void displayHistory() {
        System.out.println("\n--- Parking History (Latest First) ---");

        if (top == -1) {
            System.out.println("No history available.");
            return;
        }

        for (int i = top; i >= 0; i--)
            System.out.println(history[i]);
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n==================================");
            System.out.println(" SMART PARKING MANAGEMENT SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Display Parking Slots");
            System.out.println("4. Search Vehicle");
            System.out.println("5. Display Waiting Vehicles");
            System.out.println("6. Display Parking Records");
            System.out.println("7. Display Parking History");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Enter a valid menu number.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    parkVehicle();
                    break;

                case 2:
                    removeVehicle();
                    break;

                case 3:
                    displayParking();
                    break;

                case 4:
                    searchVehicle();
                    break;

                case 5:
                    displayWaiting();
                    break;

                case 6:
                    displayRecords();
                    break;

                case 7:
                    displayHistory();
                    break;

                case 8:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);

        sc.close();
    }
}