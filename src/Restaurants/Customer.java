package Restaurants;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import PartSal2.Residents_P2;

public class Customer implements Serializable {
    public String name;
    public int age;
    public String gender;
    public Food food;
    public List<Food> orderHistory = new LinkedList<>();
    public HashMap<Food, Integer> foodFrequency = new HashMap<>();
    public HashMap<Restaurant, Integer> restaurantFrequency;
    public static List<Customer> waitingList = new LinkedList<>(),
            JadeList = new LinkedList<>(),
            CafeList = new LinkedList<>(),
            TTList = new LinkedList<>(),
            LibeccioList = new LinkedList<>(),
            SavageList = new LinkedList<>();
    public static Residents_P2 rP2 = new Residents_P2();

    public Customer(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Customer() {
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Food getFoodFromOrderHistory(String string) {
        for (int i = 0; i < this.orderHistory.size(); i++) {
            if (this.orderHistory.get(i).getFoodName().equals(string)) {
                return this.orderHistory.get(i);
            }
        }
        return null;
    }

    public void setOrderHistory(List<Food> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public static void getAllResidentAsCustomer() {
        rP2.readRes();
        // currentLocation = Defaultmap.currentLocation.getName();
        // currentLocation = restaurantName
        for (int i = 0; i < rP2.list1.size(); i++) {
            // System.out.println(rP2.list1.get(rP2.Name.get(i)));
            // food = Restaurant.getRandomFoodByRestaurantName(restaurantName);

            if (rP2.Age.get(i).equals("N/A")) {
                waitingList.add(new Customer(rP2.Name.get(i), -1, rP2.Gender.get(i)));
            } else {
                waitingList.add(new Customer(rP2.Name.get(i), Integer.parseInt(rP2.Age.get(i)), rP2.Gender.get(i)));
            }
        }
    }

    public static void assignFood() {
        for (int i = 0; i < waitingList.size(); i++) {
            Customer customer = waitingList.get(i);
            switch (customer.name) {
                case "Jonathan Joestar":
                    JonathanOrder(customer);
                    break;
                case "Joseph Joestar":
                    JosephOrder(customer);
                    break;
                case "Jotaro Kujo":
                    JotaroOrder(customer);
                    break;
                case "Josuke Higashikata":
                    JosukeOrder(customer);
                    break;
                case "Giorno Giovanna":
                    GiornoOrder(customer);
                    break;
                case "Jolyne Cujoh":
                    JolyneOrder(customer);
                    break;
                default:
                Restaurant res = Restaurant.getRandomRestaurant();
                Food food = Restaurant.getRandomFoodByRestaurantName(res.getRestaurantName());
                customer.setFood(food);
                if (customer.orderHistory.contains(food)) {
                    Integer z = customer.foodFrequency.get(food) + 1;
                    customer.foodFrequency.replace(food, z);
                } else {
                    customer.orderHistory.add(food);
                    customer.foodFrequency.put(food, 1);
                }
                addToRestaurantList(res.getRestaurantName(), customer);
                    break;
            }
        }
    }

    public static void addToRestaurantList(String restaurantName, Customer customer) {
        switch (restaurantName) {
            case "Jade Garden":
                JadeList.add(customer);
                break;
            case "Cafe Deux Magots":
                CafeList.add(customer);
                break;
            case "Trattoria Trussardi":
                TTList.add(customer);
                break;
            case "Libeccio":
                LibeccioList.add(customer);
                break;
            case "SavageGarden":
                SavageList.add(customer);
                break;
            default:
                break;
        }
    }

    public static void JonathanOrder(Customer customer) {
        Restaurant res = Restaurant.getRandomRestaurant();
        Food food = Restaurant.getRandomFoodByRestaurantName(res.getRestaurantName());
        customer.setFood(food);
        if (customer.orderHistory.contains(food)) {
            Integer i = customer.foodFrequency.get(food) + 1;
            customer.foodFrequency.replace(food, i);
        } else {
            customer.orderHistory.add(food);
            customer.foodFrequency.put(food, 1);
        }
        addToRestaurantList(res.getRestaurantName(), customer);
    }

    public static void JosephOrder(Customer customer) {
        Restaurant res = Restaurant.getRandomRestaurant();
        Food food = Restaurant.getRandomFoodByRestaurantName(res.getRestaurantName());
        customer.setFood(food);
        if (customer.orderHistory.contains(food)) {
            Integer i = customer.foodFrequency.get(food) + 1;
            customer.foodFrequency.replace(food, i);
        } else {
            customer.orderHistory.add(food);
            customer.foodFrequency.put(food, 1);
        }
        addToRestaurantList(res.getRestaurantName(), customer);
    }

    public static void JotaroOrder(Customer customer) {
        Restaurant res = Restaurant.getRandomRestaurant();
        Food food = Restaurant.getRandomFoodByRestaurantName(res.getRestaurantName());
        customer.setFood(food);
        if (customer.orderHistory.contains(food)) {
            Integer i = customer.foodFrequency.get(food) + 1;
            customer.foodFrequency.replace(food, i);
        } else {
            customer.orderHistory.add(food);
            customer.foodFrequency.put(food, 1);
        }
        addToRestaurantList(res.getRestaurantName(), customer);
    }

    public static void JosukeOrder(Customer customer) {
        Restaurant res = Restaurant.getRandomRestaurant();
        Food food = Restaurant.getRandomFoodByRestaurantName(res.getRestaurantName());
        customer.setFood(food);
        if (customer.orderHistory.contains(food)) {
            Integer i = customer.foodFrequency.get(food) + 1;
            customer.foodFrequency.replace(food, i);
        } else {
            customer.orderHistory.add(food);
            customer.foodFrequency.put(food, 1);
        }
        addToRestaurantList(res.getRestaurantName(), customer);
    }

    public static void GiornoOrder(Customer customer) {
        Restaurant res = Restaurant.getRandomRestaurant();
        Food food = Restaurant.getRandomFoodByRestaurantName(res.getRestaurantName());
        customer.setFood(food);
        if (customer.orderHistory.contains(food)) {
            Integer i = customer.foodFrequency.get(food) + 1;
            customer.foodFrequency.replace(food, i);
        } else {
            customer.orderHistory.add(food);
            customer.foodFrequency.put(food, 1);
        }
        addToRestaurantList(res.getRestaurantName(), customer);
    }

    public static void JolyneOrder(Customer customer) {
        Restaurant res = Restaurant.getRandomRestaurant();
        Food food = Restaurant.getRandomFoodByRestaurantName(res.getRestaurantName());
        customer.setFood(food);
        if (customer.orderHistory.contains(food)) {
            Integer i = customer.foodFrequency.get(food) + 1;
            customer.foodFrequency.replace(food, i);
        } else {
            customer.orderHistory.add(food);
            customer.foodFrequency.put(food, 1);
        }
        addToRestaurantList(res.getRestaurantName(), customer);
    }
}
