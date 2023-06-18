package Restaurants;

import java.util.*;

import defaultmap.*;

public class Sale {
    private String restaurantName;
    private int day;
    private Food food;
    private int quantity;
    private double totalPrice;
    public static List<Sale> saleList = new LinkedList<>();

    public Sale(String restaurantName, int day, Food food, int quantity, double totalPrice) {
        this.restaurantName = restaurantName;
        this.day = day;
        this.food = food;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public static void addSale(String restaurantName, int day, Food food, int quantity, double totalPrice) {
        if (!saleList.isEmpty()) {
            for (int i = 0; i < saleList.size(); i++) {
                if (saleList.get(i).food.equals(food)) {
                    saleList.get(i).quantity++;
                    saleList.get(i).totalPrice += food.getFoodPrice();
                    return;
                }
            }
        } else {
            saleList.add(new Sale(restaurantName, day, food, quantity, totalPrice));
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

    public static HashMap<Integer, List<Sale>> getSaleHash(String restaurantName){
        List<Sale> sales = getSaleListByRestaurantName(restaurantName);
        HashMap<Integer, List<Sale>> newHash = new HashMap<>();
        List<Sale> temp = new LinkedList<>();
        for (int i = 0; i < Defaultmap.currentDay; i++) {
            for (int j = 0; j < sales.size(); j++) {
                if (sales.get(j).getDay()==(i+1)) {
                    temp.add(sales.get(j));
                }
            }
            newHash.put(i, temp);
            temp.clear();
        }
        System.out.println(newHash);
        return newHash;
    }
}