package PearlJam;

import java.util.*;

public class Restaurant {
    String RestaurantName;
    List<Food> Menu;
    Restaurant JadeGarden, CafeDeuxMagots, TrattoriaTrussardi, Liberrio, SavageGarden;
    static List<Restaurant> resList;
    
    //Constructor
    public Restaurant(String RestaurantName, List<Food> Menu){
        this.RestaurantName=RestaurantName;
        this.Menu=Menu;
    }
    //Empty constructor
    public Restaurant(){}

    //Getters
    public String getRestaurantName() {
        return RestaurantName;
    }
    public List<Food> getMenu(){
        return Menu;
    }

    //Setters
    public void setRestaurantName(String RestaurantName) {
        this.RestaurantName = RestaurantName;
    }
    public void setMenu(List<Food> Menu) {
        this.Menu = Menu;
    }

    public static void InitializeRestaurant(){
        Restaurant resTemp = new Restaurant();
        resTemp.InitializeRestaurantProcess();
    }

    public void InitializeRestaurantProcess(){
        //Jade Garden
        /*
        ○ Braised Chicken in Black Bean Sauce ($15.00)
        ○ Braised Goose Web with Vermicelli ($21.00)
        ○ Deep-fried Hiroshima Oysters ($17.00)
        ○ Poached Tofu with Dried Shrimps ($12.00)
        ○ Scrambled Egg White with Milk ($10.00)
        */
        List<Food> foods1 = new ArrayList<Food>();
    
        Food BraisedChickenInBlackBeanSauce = new Food("Braised Chicken in Black Bean Sauce", 15.00);
        Food BraisedGooseWebWithVermicelli = new Food("Braised Goose Web with Vermicelli", 21.00);
        Food DeepFriedHiroshimaOysters = new Food("Deep Fried Hiroshima Oysters", 17.00);
        Food PoachedTofuWithDriedShrimp = new Food("Poached Tofu with Dried Shrimp", 12.00);
        Food ScrambledEggWhiteWithMilk = new Food("ScrambledEggWhiteWithMilk", 10.00);

        foods1.add(BraisedChickenInBlackBeanSauce);
        foods1.add(BraisedGooseWebWithVermicelli);
        foods1.add(DeepFriedHiroshimaOysters);
        foods1.add(PoachedTofuWithDriedShrimp);
        foods1.add(ScrambledEggWhiteWithMilk);

        this.JadeGarden = new Restaurant("Jade Garden", foods1);

        //Cafe Deux Magots
        /*
        ○ Sampling Matured Cheese Platter ($23.00)
        ○ Spring Lobster Salad ($35.00)
        ○ Spring Organic Omelette ($23.00)
        ○ Truffle-flavoured Poultry Supreme ($34.00)
        ○ White Asparagus ($26.00)
        */
        List<Food> foods2 = new ArrayList<Food>();
    
        Food SamplingMaturedCheesePlatter = new Food("Sampling Matured Cheese Platter", 23.00);
        Food SpringLobsterSalad = new Food("Spring Lobster Salad", 35.00);
        Food SpringOrganicOmelette = new Food("Spring Organic Omelette", 23.00);
        Food TruffleFlavouredPoultrySupreme = new Food("Truffle-flavoured Poultry Supreme", 34.00);
        Food WhiteAsparagus = new Food("White Asparagus", 26.00);

        foods2.add(SamplingMaturedCheesePlatter);
        foods2.add(SpringLobsterSalad);
        foods2.add(SpringOrganicOmelette);
        foods2.add(TruffleFlavouredPoultrySupreme);
        foods2.add(WhiteAsparagus);

        this.CafeDeuxMagots = new Restaurant("Cafe Deux Magots", foods2);

        //Trattoria Trussardi
        /*
        ○ Caprese Salad ($10.00)
        ○ Creme caramel ($6.50)
        ○ Lamb Chops with Apple Sauce ($25.00)
        ○ Spaghetti alla Puttanesca ($15.00) 
        */

        List<Food> foods3 = new ArrayList<Food>();

        Food CapreseSalad = new Food("Caprese Salad", 10.00);
        Food CremeCaramel = new Food("Creme caramel", 6.50);
        Food LambChopsWithAppleSauce = new Food("Lamb Chops with Apple Sauce", 25.00);
        Food SpaghettiAllaPuttanesca = new Food("Spaghetti alla Puttanesca", 15.00);

        foods3.add(CapreseSalad);
        foods3.add(CremeCaramel);
        foods3.add(LambChopsWithAppleSauce);
        foods3.add(SpaghettiAllaPuttanesca);

        this.TrattoriaTrussardi = new Restaurant("Trattoria Trussardi", foods3);

        //Liberrio
        /*
        ○ Formaggio ($12.50)
        ○ Ghiaccio ($1.01)
        ○ Melone ($5.20)
        ○ Prosciutto and Pesci ($20.23)
        ○ Risotto ($13.14)
        ○ Zucchero and Sale ($0.60)
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

        this.Liberrio = new Restaurant("Liberrio", foods4);

        //Savage Garden
        /*
        ○ Abbacchio’s Tea ($1.00)
        ○ DIO’s Bread ($36.14)
        ○ Giorno’s Donuts ($6.66)
        ○ Joseph’s Tequila ($35.00)
        ○ Kakyoin’s Cherry ($3.50)
        ○ Kakyoin’s Porridge ($4.44)
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

        this.SavageGarden = new Restaurant("Savage Garden", foods5);

        //Add to list
        Restaurant.resList = new ArrayList<>();
        resList.add(JadeGarden);
        resList.add(CafeDeuxMagots);
        resList.add(TrattoriaTrussardi);
        resList.add(Liberrio);
        resList.add(SavageGarden);
        System.out.println(resList.toString());
    }

    public Restaurant getResByName(String RestaurantName){
        for (int i = 0; i < Restaurant.resList.size(); i++) {
            if(Restaurant.resList.get(i).RestaurantName.equals(RestaurantName)){
                return resList.get(i);
            }
        }
        return null;
    }

    public Food getFoodByName(String FoodName){
        for (int i = 0; i < Menu.size(); i++) {
            if(Menu.get(i).FoodName.equals(FoodName)){
                return Menu.get(i);
            }
        }
        return null;
    }

    public void removeFoodByName(String FoodName){
        this.Menu.remove(this.getFoodByName(FoodName));
    }
}
