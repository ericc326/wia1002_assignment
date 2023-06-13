package LatestMap_Combined;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package GroupAssignment;

import java.io.Serializable;

/**
 *
 * @author firdausazman
 */
public class Sale implements Serializable{
    private int day;
    private String food;
    private int quantity;
    private double totalPrice;
    
    public Sale(int day, String food, int quantity, double totalPrice) {
        this.day = day;
        this.food = food;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
    
    public int getDay() {
        return day;
    }
    
    public String getFood() {
        return food;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }
}


