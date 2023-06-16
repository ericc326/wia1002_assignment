package Restaurants;

import java.util.*;
import PartSal2.*;
import Restaurants.*;
import defaultmap.Defaultmap;

public class ProcessOrder {
    public static void doProcess() {
        Customer.assignRestaurantAndFood();

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