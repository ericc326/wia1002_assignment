package Restaurants;

import java.util.*;
<<<<<<< HEAD

public class Main {
    public static void main(String[] args) {
        List<Customer> waitingList = new ArrayList<>();
        Residents rP2 = new Residents();
        rP2.readRes();
        for (int i = 0; i < rP2.list1.size(); i++) {
            System.out.println(rP2.list1.get(rP2.Name.get(i)));
            if (rP2.Age.get(i).equals("N/A")) {
                waitingList.add(new Customer(rP2.Name.get(i), -1, rP2.Gender.get(i), null));
            } else {
                waitingList.add(new Customer(rP2.Name.get(i), Integer.parseInt(rP2.Age.get(i)), rP2.Gender.get(i), null));   
            }
        }
=======
import PartSal2.*;
import Restaurants.*;
import defaultmap.Defaultmap;

public class ProcessOrder {
    public static void doProcess() {
        Restaurant.InitializeRestaurant();
        //Restaurant.getRandomFoodByRestaurantName("Jade Garden");
>>>>>>> f2d89c3cfdd737280f5c947b70f0eb4c6943c9aa

        Customer.getAllResidentAsCustomer();
        Customer.assignFood();

        Restaurant restaurant = new Restaurant();
        Restaurant.setWaitingList(Customer.waitingList);

        restaurant.showWaitingList();
        System.out.println("Processing Jade Garden rule:");
        restaurant.processJadeGarden();

        System.out.println("\nProcessing Cafe Deux Magots rule:");
        restaurant.processCafeDeuxMagots();

        System.out.println("\nProcessing Trattoria Trussardi rule:");
        restaurant.processTrattoriaTrussardi();

        System.out.println("\nProcessing Libeccio rule:");
        restaurant.processLibeccio(Defaultmap.currentDay);

        System.out.println("\nProcessing Savage Garden rule:");
        restaurant.processSavageGarden(Defaultmap.currentDay);
    }
}