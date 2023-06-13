package PearlJam;

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
import PearlJam.*;

public class Main {
    public static void main(String[] args) {
        Restaurant.InitializeRestaurant();
        //Restaurant.getRandomFoodByRestaurantName("Jade Garden");
>>>>>>> f2d89c3cfdd737280f5c947b70f0eb4c6943c9aa

        Order.getAllResidentAsCustomer("Jade Garden");

        Restaurant restaurant = new Restaurant(null, Order.waitingList, 1);

        //restaurant.showWaitingList(null);

        System.out.println("Processing Jade Garden rule:");
        restaurant.processJadeGarden();

        System.out.println("\nProcessing Cafe Deux Magots rule:");
        restaurant.processCafeDeuxMagots();

        System.out.println("\nProcessing Trattoria Trussardi rule:");
        restaurant.processTrattoriaTrussardi();

        System.out.println("\nProcessing Libeccio rule:");
        restaurant.processLibeccio(2); // Assuming the current day number is 3

        System.out.println("\nProcessing Savage Garden rule:");
        restaurant.processSavageGarden(4); // Assuming the current day number is 4*/
    }
}