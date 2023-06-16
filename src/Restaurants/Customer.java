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
    public Stack<Food> orderHistory;
    public HashMap<Food, Integer> foodFrequency;
    public Stack<Restaurant> restaurantHistory;
    public HashMap<Restaurant, Integer> restaurantFrequency;
    public static List<Customer> waitingList = new LinkedList<>(),
            JadeList = new LinkedList<>(),
            CafeList = new LinkedList<>(),
            TTList = new LinkedList<>(),
            LibeccioList = new LinkedList<>(),
            SavageList = new LinkedList<>();
    public static Residents residents = new Residents();
    public static Restaurant JotaroRestaurant;
    public static Stack<Restaurant> JolyneHistory = new Stack<>();
    private static Double JosukeBudget = 100.00;
    private static List<Double> JosukeDebt = new LinkedList<>();

    public Customer(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.orderHistory = new Stack<>();
        this.foodFrequency = new HashMap<>();
        this.restaurantHistory = new Stack<>();
        this.restaurantFrequency = new HashMap<>();
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
        JadeList.clear();
        CafeList.clear();
        TTList.clear();
        LibeccioList.clear();
        SavageList.clear();
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
                    setFood(res, customer, food);
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
        int check = 0;
        if (!customer.foodFrequency.isEmpty()) {
            if (customer.foodFrequency.containsKey(food)) {
                for (int i = 0; i < res.getMenu().size(); i++) {
                    check = customer.foodFrequency.get(food);
                    if (customer.foodFrequency.containsKey(res.getMenu().get(i))) {
                        if (check - customer.foodFrequency.get(res.getMenu().get(i)) >= 1) {
                            food = res.getMenu().get(i);
                        }
                    }
                }
            }
        }
        customer.foodFrequency.put(food, check + 1);
        setFood(res, customer, food);
    }

    public static void JosephOrder(Customer customer) {
        Restaurant res = Restaurant.getRandomRestaurant();
        Food food = Restaurant.getRandomFoodByRestaurantName(res.getRestaurantName());
        while (customer.orderHistory.contains(food)) {
            res = Restaurant.getRandomRestaurant();
            food = Restaurant.getRandomFoodByRestaurantName(res.getRestaurantName());
        }

        setFood(res, customer, food);
    }

    public static void JotaroOrder(Customer customer) {
        Restaurant res = Restaurant.getRandomRestaurant();
        Food food = Restaurant.getRandomFoodByRestaurantName(res.getRestaurantName());
        if (!customer.orderHistory.isEmpty()) {
            if (customer.orderHistory.containsAll(JotaroRestaurant.getMenu())) {
                res = JotaroRestaurant;
                food = Restaurant.getRandomFoodByRestaurantName(res.getRestaurantName());
                while (customer.orderHistory.contains(food)) {
                    food = Restaurant.getRandomFoodByRestaurantName(res.getRestaurantName());
                }
            }
        }
        JotaroRestaurant = res;
        setFood(res, customer, food);
    }

    public static void JosukeOrder(Customer customer) {
        Double price = Double.MAX_VALUE;
        if (Defaultmap.currentDay % 8 == 0) {
            JosukeBudget = 100.00;
        }
        Restaurant res = Restaurant.getRandomRestaurant();
        Food food = res.getMenu().get(0);
        for (int i = 0; i < res.getMenu().size(); i++) {
            food = res.getMenu().get(i);
            if (price > food.FoodPrice) {
                price = food.FoodPrice;
            }
        }
        if (JosukeBudget < price) {
            JosukeDebt.add(price - JosukeBudget);
            JosukeBudget = 0.0;
        } else {
            JosukeBudget = JosukeBudget - price;
        }
        setFood(res, customer, food);
    }

    public static void GiornoOrder(Customer customer) {
        String day = Defaultmap.getDayOfWeek(Defaultmap.currentDay);
        Restaurant res = new Restaurant().getResByName("Trattoria Trussardi");
        int temp;
        Food food = null;
        switch (day) {
            case "Friday":
                if (customer.restaurantFrequency.containsKey(res)) {
                    temp = customer.restaurantFrequency.get(res);
                    if (temp < 2) {
                        food = customer.orderHistory.peek();
                        while (food.equals(customer.orderHistory.peek())) {
                            food = Restaurant.getRandomFoodByRestaurantName(res.getRestaurantName());
                        }
                    } else {
                        res = Restaurant.getRandomRestaurant();
                        food = Restaurant.getRandomFoodByRestaurantName(res.getRestaurantName());
                    }
                } else {
                    food = customer.orderHistory.peek();
                    while (food.equals(customer.orderHistory.peek())) {
                        food = Restaurant.getRandomFoodByRestaurantName(res.getRestaurantName());
                    }
                }
                break;
            case "Saturday":
                if (customer.restaurantFrequency.containsKey(res)) {
                    temp = customer.restaurantFrequency.get(res);
                    if (temp < 1) {
                        food = customer.orderHistory.peek();
                        while (food.equals(customer.orderHistory.peek())) {
                            food = Restaurant.getRandomFoodByRestaurantName(res.getRestaurantName());
                        }
                    } else {
                        res = Restaurant.getRandomRestaurant();
                        food = Restaurant.getRandomFoodByRestaurantName(res.getRestaurantName());
                    }
                } else {
                    food = customer.orderHistory.peek();
                    while (food.equals(customer.orderHistory.peek())) {
                        food = Restaurant.getRandomFoodByRestaurantName(res.getRestaurantName());
                    }
                }
                break;
            default:
                res = Restaurant.getRandomRestaurant();
                food = Restaurant.getRandomFoodByRestaurantName(res.getRestaurantName());
                break;
        }
        if (customer.restaurantFrequency.containsKey(res)) {
            Integer i = customer.restaurantFrequency.get(res) + 1;
            customer.restaurantFrequency.replace(res, i);
        } else {
            customer.restaurantFrequency.put(res, 1);
        }
        setFood(res, customer, food);
    }

    public static void JolyneOrder(Customer customer) {
        Restaurant res;
        switch (Defaultmap.getDayOfWeek(Defaultmap.currentDay)) {
            case "Saturday":
                res = JotaroRestaurant;
                customer.restaurantHistory.push(res);
                break;
            case "Friday":
                res = Restaurant.getRandomRestaurant();
                while (res.equals(JotaroRestaurant) || res.equals(customer.restaurantHistory.peek())) {
                    res = Restaurant.getRandomRestaurant();
                }
                customer.restaurantHistory.push(res);
                break;
            default:
                res = Restaurant.getRandomRestaurant();
                if (!customer.restaurantHistory.empty()) {
                    while (res.equals(customer.restaurantHistory.peek())) {
                        res = Restaurant.getRandomRestaurant();
                    }
                }
                customer.restaurantHistory.push(res);
                break;
        }
        Food food = Restaurant.getRandomFoodByRestaurantName(res.getRestaurantName());
        setFood(res, customer, food);
    }

    private static void setFood(Restaurant res, Customer customer, Food food) {
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

    public static Customer getCustomerbyName(String CusName) {
        for (int i = 0; i < waitingList.size(); i++) {
            if (waitingList.get(i).name.equals(CusName)) {
                return waitingList.get(i);
            }
        }
        return null;
    }

    public static void showRestaurantList(String RestaurantName) {
        List<Customer> temp;
        switch (RestaurantName) {
            case "Jade Garden":
                temp = JadeList;
                break;
            case "Cafe Deux Magots":
                temp = CafeList;
                break;
            case "Trattoria Trussardi":
                temp = TTList;
                break;
            case "Libeccio":
                temp = LibeccioList;
                break;
            case "SavageGarden":
                temp = SavageList;
                break;
            default:
                temp = waitingList;
                break;
        }
        System.out.println("Waiting list for " + RestaurantName);
        System.out.println(
                "+-----+----------------------------------------------+----------------+---------------------------------+");
        System.out.println(
                "+ No |        Customer                                  |   Price        |      Food                 |");
        System.out.println(
                "+-----+----------------------------------------------+----------------+---------------------------------+");
        if (!temp.isEmpty()) {
            for (int i = 0; i < temp.size(); i++) {
                System.out.printf("| %-4s| %-45s| %-15s| %-32s| \n", i + 1, temp.get(i).name,
                temp.get(i).food.FoodPrice, temp.get(i).food.FoodName);
            }
        }

        System.out.println(
                "+-----+----------------------------------------------+----------------+---------------------------------+");
    }

    public static DataCustomer CustomerDataSave() {
        DataCustomer data = new DataCustomer(waitingList, JotaroRestaurant, JolyneHistory, JosukeBudget, JosukeDebt);
        return data;
    }

    public static void CustomerDataLoad(DataCustomer datac) {
        Customer.waitingList = datac.waitingList;
        Customer.JotaroRestaurant = datac.JotaroRestaurant;
        Customer.JolyneHistory = datac.JolyneHistory;
        Customer.JosukeBudget = datac.JosukeBudget;
        Customer.JosukeDebt = datac.JosukeDebt;
    }
}

class DataCustomer {
    List<Customer> waitingList;
    Restaurant JotaroRestaurant;
    Stack<Restaurant> JolyneHistory;
    Double JosukeBudget;
    List<Double> JosukeDebt;

    public DataCustomer(List<Customer> waitingList, Restaurant JotaroRestaurant,
            Stack<Restaurant> JolyneHistory, Double JosukeBudget, List<Double> JosukeDebt) {
        this.waitingList = waitingList;
        this.JotaroRestaurant = JotaroRestaurant;
        this.JolyneHistory = JolyneHistory;
        this.JosukeBudget = JosukeBudget;
        this.JosukeDebt = JosukeDebt;
    }
}
