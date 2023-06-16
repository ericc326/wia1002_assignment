package Restaurants;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package GroupAssignment;

import java.io.*;
import java.util.*;

/**
 *
 * @author firdausazman
 */
public class Sale implements Serializable{
    private int day;
    private Food food;
    private int quantity;
    private double totalPrice;
    public static List<Food> foodList;
    public static HashMap<Sale> SaleList;
    
    public Sale(int day, Food food, double totalPrice) {
        this.day = day;
        this.food = food;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
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

    public static void updateSaleList(Sale sale){
        for (Food food : foodList) {
            
            
        }
    }
    
    public static Sale getSaleByFood(Food food){
        for (int i = 0; i < SaleList.size(); i++) {
            if(SaleList.get(i).food.equals(food)){
                return SaleList.get(i);
            }
        }
        return null;
    }
}


