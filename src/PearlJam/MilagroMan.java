package PearlJam;

import java.util.Scanner;

public class MilagroMan /* extends MoodyBlues and/or PearlJam */ {
    static int choice;
    static Scanner scanner = new Scanner(System.in);
    static boolean exit;
    private String restaurantName;
    private Restaurant restaurant;

    public MilagroMan(String restaurantName) {
        this.restaurantName = restaurantName;
        this.restaurant = new Restaurant().getResByName(restaurantName);
        //System.out.println(restaurant); <- checking
    }

    public void CreateFood(String foodName, Double price) {
        Food newFood = new Food(foodName, price);
        this.restaurant.getMenu().add(newFood);
    }

    public void ModifyFood(String foodName, Double price, int dayStart, int dayEnd) {
        this.restaurant.getFoodByName(foodName).setFoodPrice(price);
    }

    public void ModifyFood(int foodNum, Double price) {
        this.restaurant.getMenu().get(foodNum).setFoodPrice(price);
    }

    public void RemoveFood(String FoodName) {
        this.restaurant.removeFoodByName(FoodName);
    }

    public static void MenuHandler(String RestaurantName){
        MilagroMan mm = new MilagroMan(RestaurantName);
        mm.Menu();
    }

    // public void Menu(String restaurantName){
    public void Menu() {
        while (!exit) {
            System.out.println("\nRestaurant: " + this.restaurantName + " (Milagro Man Mode)");
            System.out.println("[1] Add A New Food");
            System.out.println("[2] Modify Food Prices");
            System.out.println("[3] Moody Blues");
            System.out.println("[4] Exit Milagro Man");
            MilagroMan.choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("\n[" + choice + "] Add New Food");
                    System.out.println("Food List:");
                    for (int i = 0; i < this.restaurant.getMenu().size(); i++) {
                        System.out.println("[" + (i + 1) + "] " + this.restaurant.getMenu().get(i).getFoodName());
                    }
                    System.out.println("Enter food name: ");
                    String Foodname = scanner.nextLine();
                    System.out.println("Enter food price");
                    double FoodPrice = scanner.nextDouble();
                    scanner.nextLine();
                    try {
                        System.out.println("Creating new food");
                        CreateFood(Foodname, FoodPrice);
                        System.out.println("Success: " + restaurant.getFoodByName(Foodname).FoodName +
                                " at $" + String.format("%.2f", restaurant.getFoodByName(Foodname).getFoodPrice()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("\n[" + choice + "] Modify Food Prices");
                    System.out.println("Food List:");
                    for (int i = 0; i < this.restaurant.getMenu().size(); i++) {
                        System.out.println("[" + (i + 1) + "] " + this.restaurant.getMenu().get(i).getFoodName());
                    }
                    System.out.println("Enter the number for the food you want to modify:");
                    int choice2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(this.restaurant.getMenu().get(choice2 - 1).FoodName
                            + " at $" + String.format("%.2f",this.restaurant.getMenu().get(choice2 - 1).getFoodPrice()));
                    System.out.println("Enter the new price:");
                    Double prcChng = scanner.nextDouble();
                    scanner.nextLine();
                    try {
                        ModifyFood(choice2 - 1, prcChng);
                        System.out.println("Successful:");
                        System.out.println(this.restaurant.getMenu().get(choice2 - 1).getFoodName()
                                + " at $" + String.format("%.2f",this.restaurant.getMenu().get(choice2 - 1).getFoodPrice()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("\n["+choice+"] Moody blues");
                    MoodyBlues.callMenu();
                    break;
                case 4:
                    System.out.println("\n[" + choice + "] Arivederci");
                    exit = true;
                    break;
                default:
                    System.out.println("Input error!");
                    break;
            }
        }
        scanner.close();
    }
}