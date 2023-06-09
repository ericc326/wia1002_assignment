package PearlJam;

import java.io.Serializable;

public class Food implements Serializable{
    String FoodName;
    Double FoodPrice;

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

    //setters
    public void setFoodName(String FoodName){
        this.FoodName=FoodName;
    }
    public void setFoodPrice(Double FoodPrice){
        this.FoodPrice=FoodPrice;
    }
}
