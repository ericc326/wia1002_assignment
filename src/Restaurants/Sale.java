package Restaurants;

import java.io.Serializable;
import java.util.*;

import defaultmap.*;

public class Sale implements Serializable{
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
            boolean exist = false;
            for (int i = 0; i < saleList.size(); i++) {
                // System.out.println(saleList.get(i).getDay() + "\t" + day);
                if (saleList.get(i).getFood().equals(food) && saleList.get(i).getDay() == day) {
                    saleList.get(i).quantity++;
                    saleList.get(i).totalPrice += food.getFoodPrice();
                    exist = true;
                }
            }
            if (!exist) {
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
        for (int i = 0; i < Defaultmap.currentDay; i++) {
            List<Sale> temp = new LinkedList<>();
            for (int j = 0; j < sales.size(); j++) {
                if (sales.get(j).getDay() == (i + 1)) {
                    temp.add(sales.get(j));
                }
            }
            newHash.put(i + 1, temp);
        }
        return newHash;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public static List<Sale> getSaleList() {
        return saleList;
    }

    public static void setSaleList(List<Sale> saleList) {
        Sale.saleList = saleList;
    }
}