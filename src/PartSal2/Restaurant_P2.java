/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PartSal2;

/**
 *
 * @author USER
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;




public class Restaurant_P2{
    private String place;
    private String name;
    private double price;
    private Map<String, Double> menu;
    HashMap<String,List<String>> waitingList;

         
    static class MenuItem {
        private String name;
        private double price;

        public MenuItem(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
    public static void main(String[] args) {
        
        String place = "Jade Garden";
        Restaurant_P2 rest1 = new Restaurant_P2(place);
        rest1.customerSort(place);
    }

    public void customerSort(String place){
        
        switch(place){
            
            case "Jade Garden":System.out.println("daijn");
                               handleSortJD();
                               break;
            case "Cafe Deux Magots":handleCDM();
                                    break;
            case "Trattoria Trussardi":handleTT();
                                       break;
            case "Savage Garden":handleSG();
            
        }
    }
    
     public Restaurant_P2() {
        this.place = place;
        this.menu = new HashMap<>();
        this. waitingList = new HashMap<>();
    }
    
    public Restaurant_P2(String place) {
        this.place = place;
        this.menu = new HashMap<>();
        this. waitingList = new HashMap<>();
    }

    public String getPlace() {
        return place;
    }

    public void addItemToMenu(String item, double price) {
        menu.put(item, price);
    }

    public Map<String, Double> getMenu() {
        return menu;
    }
    
    public void infoResEat(){
        
    }
    
     public String[] addItemsToMenu() {
        
         // Create a HashMap to store the restaurant menu
        Map<String, List<String>> restaurantMenu = new HashMap<>();

        // Jade Garden
        List<String> jadeGardenMenu = Arrays.asList(
            "Braised Chicken in Black Bean Sauce ($15.00)",
            "Braised Goose Web with Vermicelli ($21.00)",
            "Deep-fried Hiroshima Oysters ($17.00)",
            "Poached Tofu with Dried Shrimps ($12.00)",
            "Scrambled Egg White with Milk ($10.00)"
        );
        restaurantMenu.put("Jade Garden", jadeGardenMenu);

        // Cafe Deux Magots
        List<String> cafeDeuxMagotsMenu = Arrays.asList(
            "Sampling Matured Cheese Platter ($23.00)",
            "Spring Lobster Salad ($35.00)",
            "Spring Organic Omelette ($23.00)",
            "Truffle-flavoured Poultry Supreme ($34.00)",
            "White Asparagus ($26.00)"
        );
        restaurantMenu.put("Cafe Deux Magots", cafeDeuxMagotsMenu);

        // Trattoria Trussardi
        List<String> trattoriaTrussardiMenu = Arrays.asList(
            "Caprese Salad ($10.00)",
            "Creme caramel ($6.50)",
            "Lamb Chops with Apple Sauce ($25.00)",
            "Spaghetti alla Puttanesca ($15.00)"
        );
        restaurantMenu.put("Trattoria Trussardi", trattoriaTrussardiMenu);

        // Liberrio
        List<String> liberrioMenu = Arrays.asList(
            "Formaggio ($12.50)",
            "Ghiaccio ($1.01)",
            "Melone ($5.20)",
            "Prosciutto and Pesci ($20.23)",
            "Risotto ($13.14)",
            "Zucchero and Sale ($0.60)"
        );
        restaurantMenu.put("Liberrio", liberrioMenu);

        // Savage Garden
        List<String> savageGardenMenu = Arrays.asList(
            "Abbacchio’s Tea ($1.00)",
            "DIO’s Bread ($36.14)",
            "Giorno’s Donuts ($6.66)",
            "Joseph’s Tequila ($35.00)",
            "Kakyoin’s Cherry ($3.50)",
            "Kakyoin’s Porridge ($4.44)"
        );
        restaurantMenu.put("Savage Garden", savageGardenMenu);

                // Get a random menu item from the restaurantMenu HashMap
        List<String> keys = new ArrayList<>(restaurantMenu.keySet());
        Random random = new Random();
        String randomKey = keys.get(random.nextInt(keys.size()));
        List<String> randomValues = restaurantMenu.get(randomKey);
        String randomMenuItem = randomValues.get(random.nextInt(randomValues.size()));

        System.out.println("Random Menu Item:");
        System.out.println("Restaurant: " + randomKey);
        System.out.println("Menu Item: " + randomMenuItem);
        
        String randomMenu[] = {randomKey,randomMenuItem};
        
        return randomMenu;

        
    }
    
    
    
    
    public void handleSortJD(){
    
        waitingList();
        
      
     
    }
    
    public void handleCDM(){
        waitingList();
    }
    
    public void handleTT(){
       waitingList();
        
    }
    
    public void handleSG(){
        waitingList();
    }
    
    
    public void waitingList(){
        
         
    }

   
}

