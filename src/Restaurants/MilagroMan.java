package Restaurants;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import defaultmap.Defaultmap;

public class MilagroMan {
    static int choice;
    static Scanner scanner = new Scanner(System.in);
    static int startDay, endDay;
    private String restaurantName;
    private Restaurant restaurant;

    public MilagroMan(String restaurantName) {
        this.restaurantName = restaurantName;
        this.restaurant = Restaurant.getResByName(restaurantName);
        // System.out.println(restaurant); <- checking
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

    public static void MenuHandler(String RestaurantName) {
        MilagroMan mm = new MilagroMan(RestaurantName);
        mm.Menu();
    }

    public void Menu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nRestaurant: " + this.restaurantName);
            System.out.println("[1] Add A New Food");
            System.out.println("[2] Modify Existing Food");
            System.out.println("[3] Experiment With Past Sales");
            System.out.println("[4] View Sales Information");
            System.out.println("[5] Exit Milagro Man");
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
                        System.out.println("Success: " + restaurant.getFoodByName(Foodname).getFoodName() +
                                " at $" + String.format("%.2f", restaurant.getFoodByName(Foodname).getFoodPrice()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("\n[" + choice + "] Modify Existing Food");
                    System.out.println("Food List:");
                    for (int i = 0; i < this.restaurant.getMenu().size(); i++) {
                        System.out.println("[" + (i + 1) + "] " + this.restaurant.getMenu().get(i).getFoodName());
                    }
                    System.out.println("Enter the number for the food you want to modify:");
                    int choice2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(this.restaurant.getMenu().get(choice2 - 1).getFoodName()
                            + " at $"
                            + String.format("%.2f", this.restaurant.getMenu().get(choice2 - 1).getFoodPrice()));
                    System.out.println("Enter the new price:");
                    Double prcChng = scanner.nextDouble();
                    scanner.nextLine();
                    try {
                        ModifyFood(choice2 - 1, prcChng);
                        System.out.println("Successful:");
                        System.out.println(this.restaurant.getMenu().get(choice2 - 1).getFoodName()
                                + " at $"
                                + String.format("%.2f", this.restaurant.getMenu().get(choice2 - 1).getFoodPrice()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    experimentalMode(this.restaurantName);
                    break;
                case 4:
                    System.out.println("\n[" + choice + "] Moody blues");
                    MoodyBlues.callMenu(this.restaurantName);
                    break;
                case 5:
                    System.out.println();
                    exit = true;
                    break;
                default:
                    System.out.println("Input error!");
                    break;
            }
        }
    }

    public void experimentalMode(String restaurantName) {
        boolean quit = false;
        HashMap<Integer, List<Sale>> hash = null;

        while (!quit) {
            System.out.println("\nRestaurant: " + this.restaurantName + " (Milagro Man Experimental Mode)");
            System.out.println("[1] Modify Food Prices");
            System.out.println("[2] View Sales Information");
            System.out.println("[3] Exit Experimental Mode");

            MilagroMan.choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("\n[" + choice + "] Modify Food Prices");
                    System.out.println("Food List:");
                    for (int i = 0; i < this.restaurant.getMenu().size(); i++) {
                        System.out.println("[" + (i + 1) + "] " + this.restaurant.getMenu().get(i).getFoodName());
                    }
                    System.out.println("Enter the number for the food you want to modify:");
                    int choice2 = scanner.nextInt();
                    scanner.nextLine();
                    Food food = this.restaurant.getMenu().get(choice2 - 1);
                    System.out.println(food.getFoodName() + " at $" + String.format("%.2f", food.getFoodPrice()));
                    System.out.println("Enter the new price:");
                    double prcChng = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Enter start day (Note: start day and end day have to be in the past):");
                    int startDay = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter end day (Note: start day and end day have to be in the past):");
                    int endDay = scanner.nextInt();
                    scanner.nextLine();
                    hash = getSaleHashMilagroMan(restaurantName, food, prcChng, startDay, endDay);
                    break;
                case 2:
                    if (hash == null) {
                        System.out.println("No experimental changes made.");
                    } else if (hash != null) {
                        callMenuMilagroMan(restaurantName, hash);
                    }
                    break;
                case 3:
                    System.out.println();
                    quit = true;
                    break;
                default:
                    System.out.println("Input error!");
                    break;
            }
        }
    }

    public static HashMap<Integer, List<Sale>> getSaleHashMilagroMan(String restaurantName, Food food, double price,
            int startDay, int endDay) {
        List<Sale> sales = new LinkedList<>();
        for (int i = 0; i < Sale.getSaleListByRestaurantName(restaurantName).size(); i++) {
            sales.add(new Sale(restaurantName,
                    Sale.getSaleListByRestaurantName(restaurantName).get(i).getDay(),
                    Sale.getSaleListByRestaurantName(restaurantName).get(i).getFood(),
                    Sale.getSaleListByRestaurantName(restaurantName).get(i).getQuantity(),
                    Sale.getSaleListByRestaurantName(restaurantName).get(i).getTotalPrice()));
        }
        for (int i = 0; i < sales.size(); i++) {
            if (sales.get(i).getFood().equals(food)) {
                if (sales.get(i).getDay() >= startDay && sales.get(i).getDay() <= endDay) {
                    int temp = sales.get(i).getQuantity();
                    sales.get(i).setTotalPrice(0.0);
                    for (int j = 0; j < temp; j++) {
                        sales.get(i).setTotalPrice(sales.get(i).getTotalPrice() + price);
                    }
                }
            }
        }
        HashMap<Integer, List<Sale>> newHash = new HashMap<>();
        for (int i = 0; i < Defaultmap.currentDay; i++) {
            List<Sale> temp = new LinkedList<>();
            for (int j = 0; j < sales.size(); j++) {
                if (sales.get(j).getDay() == (i + 1)) {
                    // System.out.println(sales.get(j).getFood().getFoodName() + " " +
                    // sales.get(j).getDay());
                    temp.add(sales.get(j));
                }
            }
            newHash.put(i + 1, temp);
        }
        sales.clear();

        /*
         * for (int i = 0; i < newHash.keySet().size(); i++) {
         * System.out.println("check");
         * for (int j = 0; j < newHash.get(i + 1).size(); j++) {
         * System.out.println(
         * newHash.get(i + 1).get(j).getFood().getFoodName() + " " + newHash.get(i +
         * 1).get(j).getDay());
         * }
         * }
         */

        return newHash;
    }

    public static void callMenuMilagroMan(String RestaurantName, Map<Integer, List<Sale>> salesData) {
        Scanner scanner = new Scanner(System.in);
        MoodyBlues mb = new MoodyBlues();
        int startDay = 0;
        int endDay = 0;

        boolean quit = false;
        while (!quit) {
            System.out.println("Restaurant: " + RestaurantName);
            System.out.println("Sales Information");
            System.out.println("[1] View Sales");
            System.out.println("[2] View Aggregated Information");
            System.out.println(" [A] Minimum Sales");
            System.out.println(" [B] Maximum Sales");
            System.out.println(" [C] Top k Highest Sales");
            System.out.println(" [D] Total and Average Sales");
            System.out.println("[3] Exit");
            System.out.print("Select: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter Day: ");
                int day = Integer.parseInt(scanner.nextLine());
                MoodyBlues.handleViewSales(salesData.get(day));
            } else if (choice.equals("2")) {
                System.out.print("Enter Start Day: ");
                startDay = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter End Day: ");
                endDay = Integer.parseInt(scanner.nextLine());
                MoodyBlues.displayAggregatedInformation(salesData, startDay, endDay);
            } else if (choice.equalsIgnoreCase("2A")) {
                System.out.print("Enter Start Day: ");
                startDay = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter End Day: ");
                endDay = Integer.parseInt(scanner.nextLine());
                MoodyBlues.displayMinimumSales(salesData, startDay, endDay);
            } else if (choice.equalsIgnoreCase("2B")) {
                System.out.print("Enter Start Day: ");
                startDay = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter End Day: ");
                endDay = Integer.parseInt(scanner.nextLine());
                MoodyBlues.displayMaximumSales(salesData, startDay, endDay);
            } else if (choice.equalsIgnoreCase("2C")) {
                System.out.print("Enter Start Day: ");
                startDay = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter End Day: ");
                endDay = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter value of k: ");
                int k = Integer.parseInt(scanner.nextLine());
                MoodyBlues.displayTopKHighestSales(salesData, k, startDay, endDay);
            } else if (choice.equalsIgnoreCase("2D")) {
                System.out.print("Enter Start Day: ");
                startDay = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter End Day: ");
                endDay = Integer.parseInt(scanner.nextLine());
                MoodyBlues.displayTotalAndAverageSales(salesData, startDay, endDay);
            } else if (choice.equals("3")) {
                quit = true;
                break;
            }

            System.out.println("======================================================================");
        }
    }
}