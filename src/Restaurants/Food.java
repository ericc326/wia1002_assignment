package Restaurants;

import java.io.Serializable;

public class Food implements Serializable{
    String FoodName;
    Double FoodPrice;
    int frequency;

    //constructors
    public Food(String FoodName, Double FoodPrice){
        this.FoodName=FoodName;
        this.FoodPrice=FoodPrice;
    }

    //getters
    public String getFoodName(){
        return FoodName;
    }
    public Double getFoodPrice(){
        return FoodPrice;
    }
    public int getFrequency() {
        return frequency;
    }

    //setters
    public void setFoodName(String FoodName){
        this.FoodName=FoodName;
    }
    public void setFoodPrice(Double FoodPrice){
        this.FoodPrice=FoodPrice;
    }
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
