package PearlJam;

import java.io.Serializable;
import java.util.*;

import defaultmap.Defaultmap;

public class Restaurant implements Serializable {
    String RestaurantName;
    List<Food> Menu;
    static Restaurant JadeGarden, CafeDeuxMagots, TrattoriaTrussardi, Libeccio, SavageGarden;
    public static List<Restaurant> resList;
    public static List<Sale> saleList;
    List<Customer> waitingList;
    int currentDayNumber;

    // Constructor
    public Restaurant(String RestaurantName, List<Customer> waitingList, int Day) {
        this.RestaurantName = RestaurantName;
        this.waitingList = waitingList;
    }

    public Restaurant(String RestaurantName, List<Food> Menu) {
        this.RestaurantName = RestaurantName;
        this.Menu = Menu;
    }

    // Empty constructor
    public Restaurant() {
    }

    // Getters
    public String getRestaurantName() {
        return RestaurantName;
    }

    public List<Food> getMenu() {
        return Menu;
    }

    // Setters
    public void setRestaurantName(String RestaurantName) {
        this.RestaurantName = RestaurantName;
    }

    public void setMenu(List<Food> Menu) {
        this.Menu = Menu;
    }

    public static void InitializeRestaurant() {
        System.out.println("\nLOADING...\n");
        Restaurant resTemp = new Restaurant();
        resTemp.InitializeRestaurantProcess(null);
    }

    public String[] InitializeRestaurantProcess() {
<<<<<<< HEAD
       
        // Create a HashMap to store the restaurant menu
    Map<String, List<String>> restaurantMenu = new HashMap<>();
=======
        return null;
    }

    public void InitializeRestaurantProcess(Void s) {
        // Jade Garden
        /*
         * ○ Braised Chicken in Black Bean Sauce ($15.00)
         * ○ Braised Goose Web with Vermicelli ($21.00)
         * ○ Deep-fried Hiroshima Oysters ($17.00)
         * ○ Poached Tofu with Dried Shrimps ($12.00)
         * ○ Scrambled Egg White with Milk ($10.00)
         */
        List<Food> foods1 = new ArrayList<Food>();
>>>>>>> f2d89c3cfdd737280f5c947b70f0eb4c6943c9aa

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

    // Split the menu item into name and price
    String[] menuItemParts = randomMenuItem.split("\\s+\\(");
    String menuItemName = menuItemParts[0];
    String menuItemPrice = menuItemParts[1].replaceAll("\\)", "");

    System.out.println("Separated Menu Item:");
    System.out.println("Restaurant: " + randomKey);
    System.out.println("Menu Item: " + menuItemName);
    System.out.println("Price: " + menuItemPrice);

    String[] randomMenu = {randomKey, menuItemName, menuItemPrice};

<<<<<<< HEAD
    return randomMenu;
    
=======
        foods3.add(CapreseSalad);
        foods3.add(CremeCaramel);
        foods3.add(LambChopsWithAppleSauce);
        foods3.add(SpaghettiAllaPuttanesca);

        Restaurant.TrattoriaTrussardi = new Restaurant("Trattoria Trussardi", foods3);

        // Libeccio
        /*
         * ○ Formaggio ($12.50)
         * ○ Ghiaccio ($1.01)
         * ○ Melone ($5.20)
         * ○ Prosciutto and Pesci ($20.23)
         * ○ Risotto ($13.14)
         * ○ Zucchero and Sale ($0.60)
         */

        List<Food> foods4 = new ArrayList<Food>();

        Food Formaggio = new Food("Sampling Matured Cheese Platter", 23.00);
        Food Ghiaccio = new Food("Spring Lobster Salad", 35.00);
        Food Melone = new Food("Spring Organic Omelette", 23.00);
        Food ProsciuttoAndPesci = new Food("Truffle-flavoured Poultry Supreme", 34.00);
        Food Risotto = new Food("Risotto", 13.14);
        Food ZuccheroAndSale = new Food("Zucchero and Sale", 0.60);

        foods4.add(Formaggio);
        foods4.add(Ghiaccio);
        foods4.add(Melone);
        foods4.add(ProsciuttoAndPesci);
        foods4.add(Risotto);
        foods4.add(ZuccheroAndSale);

        Restaurant.Libeccio = new Restaurant("Libeccio", foods4);

        // Savage Garden
        /*
         * ○ Abbacchio’s Tea ($1.00)
         * ○ DIO’s Bread ($36.14)
         * ○ Giorno’s Donuts ($6.66)
         * ○ Joseph’s Tequila ($35.00)
         * ○ Kakyoin’s Cherry ($3.50)
         * ○ Kakyoin’s Porridge ($4.44)
         */

        List<Food> foods5 = new ArrayList<Food>();

        Food AbbacchiosTea = new Food("Abbacchio's Tea", 1.00);
        Food DIOsBread = new Food("DIO's Bread", 36.14);
        Food GiornosDonuts = new Food("Giorno's Donuts", 6.66);
        Food JosephsTequila = new Food("Joseph's Tequila", 35.00);
        Food KakyoinsCherry = new Food("Kakyoin's Cherry", 3.50);
        Food KakyoinsPorridge = new Food("Kakyoin's Porridge", 4.44);

        foods5.add(AbbacchiosTea);
        foods5.add(DIOsBread);
        foods5.add(GiornosDonuts);
        foods5.add(JosephsTequila);
        foods5.add(KakyoinsCherry);
        foods5.add(KakyoinsPorridge);

        Restaurant.SavageGarden = new Restaurant("SavageGarden", foods5);

        // Add to list
        Restaurant.resList = new ArrayList<>();
        resList.add(JadeGarden);
        resList.add(CafeDeuxMagots);
        resList.add(TrattoriaTrussardi);
        resList.add(Libeccio);
        resList.add(SavageGarden);
        //System.out.println(resList.toString()); // <-check
        System.out.println("\nLOADING...\n");
>>>>>>> f2d89c3cfdd737280f5c947b70f0eb4c6943c9aa
    }

    public Restaurant getResByName(String RestaurantName) {
        for (int i = 0; i < Restaurant.resList.size(); i++) {
            if (Restaurant.resList.get(i).RestaurantName.equals(RestaurantName)) {
                return resList.get(i);
            }
        }
        return null;
    }

    public Food getFoodByName(String FoodName) {
        for (int i = 0; i < Menu.size(); i++) {
            if (Menu.get(i).FoodName.equals(FoodName)) {
                return Menu.get(i);
            }
        }
        return null;
    }

    public static Food getRandomFoodByRestaurantName(String RestaurantName) {
        Restaurant resTemp = new Restaurant();
        resTemp = resTemp.getResByName(RestaurantName);

        List<Food> foodList = resTemp.getMenu();

        Random rand = new Random();

        int randomNum = rand.nextInt((foodList.size() - 1) + 1);

        // System.out.println(foodList.get(randomNum).getFoodName());

        return foodList.get(randomNum);
    }

    public void removeFoodByName(String FoodName) {
        this.Menu.remove(this.getFoodByName(FoodName));
    }

    public void viewMenubyResName(String RestaurantName) {
        System.out.println();
        System.out.println("Menu for " + RestaurantName);
        ;
        System.out.println("//-------------------------------------//");
        System.out.println("Price\tMenu");
        for (int i = 0; i < getResByName(RestaurantName).Menu.size(); i++) {
            System.out.println(String.format("RM %.2f", getResByName(RestaurantName).Menu.get(i).getFoodPrice()) +
                    "\t" + getResByName(RestaurantName).Menu.get(i).getFoodName());
        }
        System.out.println();
        System.out.println("Press enter to continue");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    // Jade Garden rule: Process customers in pairs (first and last, second and
    // second-last, etc.)
    public void processJadeGarden() {
        List<Customer> tempList = waitingList;
        int start = 0;
        int end = tempList.size() - 1;

        while (start < end) {
            Customer first = tempList.get(start);
            Customer last = tempList.get(end);

            // Process first and last customers
            serveCustomer(first);
            serveCustomer(last);

            start++;
            end--;
        }

        if (start == end) {
            // Process the customer in the middle if there is one remaining
            Customer middle = tempList.get(start);
            serveCustomer(middle);
        }
    }

    // Cafe Deux Magots rule: Select oldest and youngest customers in turns until
    // everyone is served
    public void processCafeDeuxMagots() {
        List<Customer> tempList = new ArrayList<Customer>(), tempList2 = new ArrayList<Customer>();

        for (int i = 0; i < waitingList.size(); i++) {
            if (waitingList.get(i).age == -1) {
                tempList2.add(waitingList.get(i));
            } else if (waitingList.get(i).age > -1) {
                tempList.add(waitingList.get(i));
            }
        }
        tempList.sort(Comparator.comparingInt(c -> c.age));

        int start = 0;
        int end = tempList.size() - 1;

        while (start < end) {
            Customer youngest = tempList.get(start);
            Customer oldest = tempList.get(end);

            // Process youngest and oldest customers
            serveCustomer(youngest);
            serveCustomer(oldest);

            start++;
            end--;
        }

        if (start == end) {
            // Process the customer in the middle if there is one remaining
            Customer middle = tempList.get(start);
            serveCustomer(middle);
        }
        for (int i = 0; i < tempList2.size(); i++) {
            serveCustomer(tempList2.get(i));
        }
    }

    // Trattoria Trussardi rule: Serve youngest man, oldest woman, oldest man,
    // youngest woman, alternating genders
    public void processTrattoriaTrussardi() {
        List<Customer> tempList = new ArrayList<Customer>(), tempList2 = new ArrayList<>();

        for (int i = 0; i < waitingList.size(); i++) {
            if (waitingList.get(i).age == -1) {
                tempList2.add(waitingList.get(i));
            } else if (waitingList.get(i).age > -1) {
                tempList.add(waitingList.get(i));
            }
        }

        tempList.sort(Comparator.comparingInt(c -> c.age));
        // tempList.sort(Comparator.comparing(c -> c.gender.equals("male") ? 0 : 1));
        // tempList2.sort(Comparator.comparing(c -> c.gender.equals("male") ? 0 : 1));

        List<Customer> males = new LinkedList<>();
        List<Customer> females = new LinkedList<>();

        for (Customer customer : tempList) {
            if (customer.gender.equalsIgnoreCase("male")) {
                males.add(customer);
            } else if (customer.gender.equalsIgnoreCase("female")) {
                females.add(customer);
            }
        }

        System.out.println(males.isEmpty());
        System.out.println(females.isEmpty());

        while (!males.isEmpty() || !females.isEmpty()) {
            if (!males.isEmpty()) {
                // System.out.println("Serve youngest man");
                serveCustomer(males.get(0));
                males.remove(0);
            }
            if (!females.isEmpty()) {
                // System.out.println("Serve oldest woman");
                serveCustomer(females.get(females.size() - 1));
                females.remove(females.size() - 1);
            }
            if (!males.isEmpty()) {
                // System.out.println("Serve oldest man");
                serveCustomer(males.get(males.size() - 1));
                males.remove(males.size() - 1);
            }
            if (!females.isEmpty()) {
                // System.out.println("Serve youngest woman");
                serveCustomer(females.get(0));
                females.remove(0);
            }
        }

        for (Customer customer : tempList2) {
            if (customer.gender.equalsIgnoreCase("male")) {
                males.add(customer);
            } else if (customer.gender.equalsIgnoreCase("female")) {
                females.add(customer);
            }
        }
        while (!males.isEmpty() || !females.isEmpty()) {
            if (!males.isEmpty()) {
                // System.out.println("Serve youngest man");
                serveCustomer(males.get(0));
                males.remove(0);
            }
            if (!females.isEmpty()) {
                // System.out.println("Serve oldest woman");
                serveCustomer(females.get(females.size() - 1));
                females.remove(females.size() - 1);
            }
            if (!males.isEmpty()) {
                // System.out.println("Serve oldest man");
                serveCustomer(males.get(males.size() - 1));
                males.remove(males.size() - 1);
            }
            if (!females.isEmpty()) {
                // System.out.println("Serve youngest woman");
                serveCustomer(females.get(0));
                females.remove(0);
            }
        }
    }

    // Libeccio rule: Remove customers based on their numbers being multiples of the
    // current day number
    public void processLibeccio(int currentDayNumber) {
        this.currentDayNumber = currentDayNumber;
        List<Customer> tempList = waitingList;

        Stack<Customer> tempStack = new Stack<>();

        for (int i = 0; i < tempList.size(); i++) {
            if ((i + 1) % currentDayNumber == 0) {
                tempStack.push(tempList.get(i));
            } else {
                serveCustomer(tempList.get(i));
            }
        }
        while (!tempStack.isEmpty()) {
            serveCustomer(tempStack.pop());
        }
    }

    // Savage Garden rule: Serve customers based on their numbers matching the day
    // number
    public void processSavageGarden(int currentDayNumber) {
        this.currentDayNumber = currentDayNumber;
        List<Customer> tempList = waitingList;

        Stack<Customer> tempQ = new Stack<>();

        for (int i = 0; i < tempList.size(); i++) {
            if ((i + 1) % currentDayNumber == 0) {
                serveCustomer(tempList.get(i));
                // tempQ.push(waitingList.get(i));
            } else {
                tempQ.push(tempList.get(i));
                // serveCustomer(waitingList.get(i));
            }
        }
        for (int i = 0; i < tempQ.size() + 1; i++) {
            serveCustomer(tempQ.pop());
        }
    }

    private void serveCustomer(Customer customer) {
        System.out.println("Serving customer: " + customer.name + "\nFood ordered: " + customer.food.getFoodName());
        Sale sale = new Sale(Defaultmap.currentDay, Defaultmap.currentLocation.getName(), 1,
                customer.food.getFoodPrice());
        Sale.SaleList.add(sale);
        // Perform serving operations
    }

    void showWaitingList(String RestaurantName) {
        System.out.println("//---------------------------------------------//");
        for (int i = 0; i < waitingList.size(); i++) {
            System.out.println(waitingList.get(i).name + "\t" + waitingList.get(i).age + "\t" +
                    waitingList.get(i).gender + "\t" + waitingList.get(i).food);
        }
        System.out.println("//---------------------------------------------//");
    }
}

class Customer {
    String name;
    int age;
    String gender;
    Food food;

    public Customer(String name, int age, String gender, Food food) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.food = food;
    }
}