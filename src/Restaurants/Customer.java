package Restaurants;

import java.io.*;
import java.util.*;
import PartSal2.Residents;
import defaultmap.Defaultmap;

public class Customer implements Serializable {
    public String name;
    public int age;
    public String gender;
    public Food food;
    public Stack<Food> orderHistory = new Stack<>();
    public HashMap<Food, Integer> foodFrequency = new HashMap<>();
    public Stack<Restaurant> restaurantHistory = new Stack<>();
    public HashMap<Restaurant, Integer> restaurantFrequency = new HashMap<>();
    public static List<Customer> waitingList = new LinkedList<>(),
            JadeList = new LinkedList<>(),
            CafeList = new LinkedList<>(),
            TTList = new LinkedList<>(),
            LibeccioList = new LinkedList<>(),
            SavageList = new LinkedList<>();
    public static Residents residents = new Residents();
    public static Restaurant JotaroRestaurant;

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
        this.orderHistory.addAll(orderHistory);
    }

    public static void getAllResidentAsCustomer() {
        residents.readRes();
        // currentLocation = Defaultmap.currentLocation.getName();
        // currentLocation = restaurantName
        for (int i = 0; i < residents.list1.size(); i++) {
            // System.out.println(rP2.list1.get(rP2.Name.get(i)));
            // food = Restaurant.getRandomFoodByRestaurantName(restaurantName);

            if (residents.Age.get(i).equals("N/A")) {
                waitingList.add(new Customer(residents.Name.get(i), -1, residents.Gender.get(i)));
            } else {
                waitingList.add(new Customer(residents.Name.get(i), Integer.parseInt(residents.Age.get(i)),
                        residents.Gender.get(i)));
            }
        }
    }

    public static void assignRestaurantAndFood() {
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
                    setRandomFood(res, customer);
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
        /*
         * Set<Food> dishes = customer.foodFrequency.keySet();
         * int minFrequency = Integer.MAX_VALUE;
         * int maxFrequency = Integer.MIN_VALUE;
         * 
         * for (Food dish : dishes) {
         * int frequency = customer.foodFrequency.getOrDefault(dish, 0);
         * minFrequency = Math.min(minFrequency, frequency);
         * maxFrequency = Math.max(maxFrequency, frequency);
         * }
         * 
         * for (Food dish : dishes) {
         * int frequency = customer.foodFrequency.getOrDefault(dish, 0);
         * if (maxFrequency - frequency <= 1) {
         * selectedDish = dish;
         * break;
         * }
         * }
         * 
         * if (selectedDish != null) {
         * dishFrequency.put(selectedDish, dishFrequency.getOrDefault(selectedDish, 0) +
         * 1);
         * }
         */
        setRandomFood(res, customer);
    }

    public static void JosephOrder(Customer customer) {
        /*
         * List<String> dishes = restaurant.getDishes();
         * allAvailableDishes.addAll(dishes);
         * allAvailableDishes.removeAll(eatenDishes);
         * 
         * if (allAvailableDishes.isEmpty()) {
         * // Reset eaten dishes list if all dishes have been tried
         * eatenDishes.clear();
         * allAvailableDishes.addAll(dishes);
         * }
         * 
         * Random random = new Random();
         * int randomIndex = random.nextInt(allAvailableDishes.size());
         * String selectedDish = allAvailableDishes.get(randomIndex);
         * eatenDishes.add(selectedDish);
         */

        Restaurant res = Restaurant.getRandomRestaurant();
        setRandomFood(res, customer);
    }

    public static void JotaroOrder(Customer customer) {
        /*
         * List<String> dishes = restaurant.getDishes();
         * for (String dish : dishes) {
         * // Try every dish at the current restaurant
         * // You can perform any action with the dish here
         * System.out.println("Tasting " + dish);
         * }
         * visitedRestaurants.add(restaurant.getName());
         * return null;
         */
        Restaurant res = Restaurant.getRandomRestaurant();
        JotaroRestaurant = res;
        setRandomFood(res, customer);
    }

    public static void JosukeOrder(Customer customer) {
        Double budget = 100.00;
        List<Double> debt;
        /*
         * List<String> dishes = restaurant.getDishes();
         * Random random = new Random();
         * int randomIndex = random.nextInt(dishes.size());
         * String selectedDish = dishes.get(randomIndex);
         * double dishCost = getDishCost(selectedDish);
         * 
         * if (dishCost > budget) {
         * double remainingCost = dishCost - budget;
         * double borrowAmount = remainingCost - getRemainingBudget();
         * borrowedAmounts.add(borrowAmount);
         * budget += borrowAmount;
         * }
         * 
         * budget -= dishCost;
         */
        Restaurant res = Restaurant.getRandomRestaurant();
        setRandomFood(res, customer);
    }

    public static void GiornoOrder(Customer customer) {
        String day = Defaultmap.getDayOfWeek(Defaultmap.currentDay);
        Restaurant res = new Restaurant();
        switch (day) {
            case "Friday":
            res = res.getResByName("Restaurant res");
                if (customer.restaurantFrequency.get(res)<2) {
                       
                }
                break;
            case "Saturday":
                res = res.getResByName("Restaurant res");
                break;
            default:
                res = Restaurant.getRandomRestaurant();
                break;
        }
        if (customer.restaurantFrequency.containsKey(res)) {
            Integer i = customer.restaurantFrequency.get(res) + 1;
            customer.restaurantFrequency.replace(res, i);
        } else {
            customer.restaurantHistory.add(res);
            customer.restaurantFrequency.put(res, 1);
        }
        /*
         * List<String> dishes = restaurant.getDishes();
         * 
         * if (dishes.size() == 1) {
         * return dishes.get(0);
         * }
         * 
         * Random random = new Random();
         * String selectedDish;
         * do {
         * selectedDish = dishes.get(random.nextInt(dishes.size()));
         * } while (selectedDish.equals(lastVisitedDish));
         * 
         * lastVisitedDish = selectedDish;
         */
        setRandomFood(res, customer);
    }

    public static void JolyneOrder(Customer customer) {
        Restaurant res;
        if (Defaultmap.getDayOfWeek(Defaultmap.currentDay).equals("Saturday")
                && !JotaroRestaurant.equals(customer.restaurantHistory.peek())) {
            res = JotaroRestaurant;
            customer.restaurantHistory.push(res);
        } else {
            res = Restaurant.getRandomRestaurant();
            while (res.equals(customer.restaurantHistory.peek())) {
                res = Restaurant.getRandomRestaurant();
            }
            customer.restaurantHistory.push(res);
        }
        setRandomFood(res, customer);
    }

    private static void setRandomFood(Restaurant res, Customer customer){
        Food food = Restaurant.getRandomFoodByRestaurantName(res.getRestaurantName());
        customer.setFood(food);
        if (customer.orderHistory.contains(food)) {
            Integer i = customer.foodFrequency.get(food) + 1;
            customer.orderHistory.push(food);
            customer.foodFrequency.replace(food, i);
        } else {
            customer.orderHistory.push(food);
            customer.foodFrequency.put(food, 1);
        }
        addToRestaurantList(res.getRestaurantName(), customer);
    }
}
