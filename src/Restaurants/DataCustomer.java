package Restaurants;

import java.util.List;
import java.util.Stack;

public class DataCustomer {
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