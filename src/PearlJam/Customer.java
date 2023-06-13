package PearlJam;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import PartSal2.Residents_P2;

public class Customer implements Serializable {
    public String name;
    public int age;
    public String gender;
    public Food food;
    public List<Food> orderHistory = new LinkedList<>();
    public static List<Customer> waitingList = new LinkedList<>();
    public static Residents_P2 rP2 = new Residents_P2();
    static String restaurantName;

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

    public void assignFood(String restaurantName) {
        for (int i = 0; i < waitingList.size(); i++) {
            Customer customer = waitingList.get(i);
            switch (customer.name) {
                case "Jonathan Joestar":
                    JonathanOrder(restaurantName);
                    break;
                case "Joseph Joestar":
                    JosephOrder(restaurantName);
                    break;
                case "Jotaro Kujo":
                    JotaroOrder(restaurantName);
                    break;
                case "Josuke Higashikata":
                    JosukeOrder(restaurantName);
                    break;
                case "Giorno Giovanna":
                    GiornoOrder(restaurantName);
                    break;
                case "Jolyne Cujoh":
                    JolyneOrder(restaurantName);
                    break;
                default:
                    food = Restaurant.getRandomFoodByRestaurantName(restaurantName);
                    customer.setFood(food);
                    customer.orderHistory.add(food);
                    break;
            }
        }
    }

    public void JonathanOrder(String restaurantName) {
    }

    public void JosephOrder(String restaurantName) {
    }

    public void JotaroOrder(String restaurantName) {
    }

    public void JosukeOrder(String restaurantName) {
    }

    public void GiornoOrder(String restaurantName) {
    }

    public void JolyneOrder(String restaurantName) {
    }
}
