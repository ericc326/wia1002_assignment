import java.util.Scanner;

import PearlJam.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        //MoodyBlues.callMenu();
        Restaurant.InitializeRestaurant();
        System.out.println("\nEnter restaurant name:");
        Scanner scanner = new Scanner(System.in);
        String restaurantName = scanner.nextLine();
        MilagroMan mg = new MilagroMan(restaurantName);
        mg.Menu();
        scanner.close();
    }
}