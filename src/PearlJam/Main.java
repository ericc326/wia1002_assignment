package PearlJam;

import java.util.*;
import PartSal2.*;
import PearlJam.*;

public class Main {
    public static void main(String[] args) {
        Restaurant.InitializeRestaurant();
        //Restaurant.getRandomFoodByRestaurantName("Jade Garden");

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