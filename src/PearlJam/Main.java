package PearlJam;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a sample waiting list
        List<Customer> waitingList = new ArrayList<>();
        waitingList.add(new Customer("John", 25, "male", "Pizza"));
        waitingList.add(new Customer("Emily", 30, "female", "Burger"));
        waitingList.add(new Customer("Michael", 40, "male", "Steak"));
        waitingList.add(new Customer("Sophia", 35, "female", "Salad"));
        waitingList.add(new Customer("Daniel", 20, "male", "Pasta"));

        Restaurant restaurant = new Restaurant(null, waitingList, 1);

        restaurant.showWaitingList(null);

        System.out.println("Processing Jade Garden rule:");
        restaurant.processJadeGarden();

        System.out.println("\nProcessing Cafe Deux Magots rule:");
        restaurant.processCafeDeuxMagots();

        System.out.println("\nProcessing Trattoria Trussardi rule:");
        restaurant.processTrattoriaTrussardi();

        System.out.println("\nProcessing Libeccio rule:");
        restaurant.processLibeccio(2); // Assuming the current day number is 3

        System.out.println("\nProcessing Savage Garden rule:");
        restaurant.processSavageGarden(4); // Assuming the current day number is 4
    }
}