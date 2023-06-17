package Restaurants;

import java.util.List;

public class SaleDisplay {
    public static void displaySalesByDay(int day, String restaurantName) {
        List<Sale> list = Sale.getSaleHash(restaurantName).get(day);
        
    }
}
