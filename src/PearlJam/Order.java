package PearlJam;

import java.util.*;
import PartSal2.*;
import defaultmap.*;

public class Order {
    public static List<Customer> waitingList = new ArrayList<>();
    public static Residents_P2 rP2 = new Residents_P2();
    static Food food;
    static String currentLocation;

    public static void getAllResidentAsCustomer(String restaurantName){
        rP2.readRes();
        //currentLocation = Defaultmap.currentLocation.getName();
        //currentLocation = restaurantName
        currentLocation="Jade Garden";
        for (int i = 0; i < rP2.list1.size(); i++) {
            //System.out.println(rP2.list1.get(rP2.Name.get(i)));

            food = Restaurant.getRandomFoodByRestaurantName(currentLocation);

            if (rP2.Age.get(i).equals("N/A")) {
                waitingList.add(new Customer(rP2.Name.get(i), -1, rP2.Gender.get(i), food));
            } else {
                waitingList.add(new Customer(rP2.Name.get(i), Integer.parseInt(rP2.Age.get(i)), rP2.Gender.get(i), food));   
            }
        }
    }
}
