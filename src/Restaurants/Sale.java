package Restaurants;

import java.util.*;

import defaultmap.Defaultmap;

public class Sale {
    private String restaurantName;
    private int day;
    private Food food;
    private int quantity;
    private double totalPrice;
    public static List<Sale> saleList;

    public Sale(String restaurantName, int day, Food food, int quantity, double totalPrice) {
        this.restaurantName = restaurantName;
        this.day = day;
        this.food = food;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public static void addSale(String restaurantName, int day, Food food, int quantity, double totalPrice) {
        if (saleList == null) {
            saleList = new LinkedList<>();
            saleList.add(new Sale(restaurantName, day, food, quantity, totalPrice));
            // System.out.println(saleList);
        } else {
            // System.out.println(saleList.size());
            int pos = -1;
            boolean listContains = false;
            for (int i = 0; i < saleList.size(); i++) {
                // System.out.println(i);
                if (saleList.get(i).getFood().equals(food)) {
                    pos = i;
                    listContains = true;
                }
            }
            if (listContains) {
                saleList.get(pos).quantity++;
                saleList.get(pos).totalPrice += food.getFoodPrice();
            } else {
                saleList.add(new Sale(restaurantName, day, food, quantity, totalPrice));
            }

        }
    }

    public int getDay() {
        return day;
    }

    public Food getFood() {
        return food;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public static Sale getSaleByFood(Food food) {
        for (int i = 0; i < saleList.size(); i++) {
            if (saleList.get(i).food.equals(food)) {
                return saleList.get(i);
            }
        }
        return null;
    }

    public static List<Sale> getSaleListByRestaurantName(String restaurantName) {
        List<Sale> temp = new LinkedList<>();
        for (int i = 0; i < saleList.size(); i++) {
            if (saleList.get(i).restaurantName.equals(restaurantName)) {
                temp.add(saleList.get(i));
            }
        }
        return temp;
    }

    public static HashMap<Integer, List<Sale>> getSaleHash(String restaurantName) {
        List<Sale> sales = getSaleListByRestaurantName(restaurantName);
        HashMap<Integer, List<Sale>> newHash = new HashMap<>();
        List<Sale> temp = new LinkedList<>();
        for (int i = 0; i < Defaultmap.currentDay; i++) {
            temp.clear();
            for (int j = 0; j < sales.size(); j++) {
                if (sales.get(j).getDay() == (i + 1)) {
                    temp.add(sales.get(j));
                }
            }
            newHash.put(i + 1, temp);
        }
        /*
         * for (int i = 0; i < newHash.keySet().size(); i++) {
         * System.out.println("check");
         * for (int j = 0; j < newHash.get(i+1).size(); j++) {
         * System.out.println(newHash.get(i+1).get(j).getFood().getFoodName());
         * }
         * }
         */
        return newHash;
    }
}