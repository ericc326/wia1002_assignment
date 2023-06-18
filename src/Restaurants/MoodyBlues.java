package Restaurants;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//package GroupAssignment;

/**
 *
 * @author firdausazman
 */
import java.util.*;

public class MoodyBlues {
    static String RestaurantName;

    public static void main(String[] args) {
        System.out.println("Enter restaurant name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        callMenu(name);
    }

    public static void callMenu(String RestaurantName) {
        MoodyBlues.RestaurantName = RestaurantName;
        Restaurant restaurant = Restaurant.getResByName(RestaurantName);
        

        Scanner scanner = new Scanner(System.in);
        Map<Integer, List<Sale>> salesData = Sale.getSaleHash(RestaurantName);

        int startDay = 0;
        int endDay = 0;

        while (true) {
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
                handleViewSales(salesData.get(day));
            } else if (choice.equals("2")) {
                System.out.print("Enter Start Day: ");
                startDay = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter End Day: ");
                endDay = Integer.parseInt(scanner.nextLine());
                displayAggregatedInformation(salesData, startDay, endDay);
            } else if (choice.equals("2A")) {
                System.out.print("Enter Start Day: ");
                startDay = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter End Day: ");
                endDay = Integer.parseInt(scanner.nextLine());
                displayMinimumSales(salesData, startDay, endDay);
            } else if (choice.equals("2B")) {
                System.out.print("Enter Start Day: ");
                startDay = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter End Day: ");
                endDay = Integer.parseInt(scanner.nextLine());
                displayMaximumSales(salesData, startDay, endDay);
            } else if (choice.equals("2C")) {
                System.out.print("Enter Start Day: ");
                startDay = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter End Day: ");
                endDay = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter value of k: ");
                int k = Integer.parseInt(scanner.nextLine());
                displayTopKHighestSales(salesData, k, startDay, endDay);
            } else if (choice.equals("2D")) {
                System.out.print("Enter Start Day: ");
                startDay = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter End Day: ");
                endDay = Integer.parseInt(scanner.nextLine());
                displayTotalAndAverageSales(salesData, startDay, endDay);
            } else if (choice.equals("3")) {
                break;
            }

            System.out.println("======================================================================");
        }
    }

    private static void handleViewSales(List<Sale> sales) {
        if (sales == null) {
            System.out.println("No sales data available for the specified day.");
            return;
        }

        System.out.println("Day " + sales.get(0).getDay() + " Sales");
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.println("| Food                                | Quantity | Total Price |");
        System.out.println("+-------------------------------------+----------+-------------+");

        for (Sale sale : sales) {
            System.out.printf("| %-35s | %8d | $%9.2f |\n", sale.getFood().getFoodName(), sale.getQuantity(), sale.getTotalPrice());
        }

        System.out.println("+-------------------------------------+----------+-------------+");

        double totalSales = sales.stream().mapToDouble(Sale::getTotalPrice).sum();
        System.out.printf("| Total Sales                         |          | $%9.2f |\n", totalSales);
        System.out.println("+-------------------------------------+----------+-------------+");
    }

    private static void displayAggregatedInformation(Map<Integer, List<Sale>> salesData, int startDay, int endDay) {
        // code for displaying aggregated information
    }

    private static void displayTotalAndAverageSales(Map<Integer, List<Sale>> salesData, int startDay, int endDay) {
        List<Sale> aggregatedSales = new ArrayList<>();

        for (int day = startDay; day <= endDay; day++) {
            List<Sale> sales = salesData.get(day);
            if (sales != null) {
                aggregatedSales.addAll(sales);
            }
        }

        if (aggregatedSales.isEmpty()) {
            System.out.println("No sales data available for the specified range of days.");
            return;
        }

        System.out.println("Total and Average Sales (Day " + startDay + " - " + endDay + ")");
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.println("| Food                                | Quantity | Total Price |");
        System.out.println("+-------------------------------------+----------+-------------+");

        for (Sale sale : aggregatedSales) {
            System.out.printf("| %-35s | %8d | $%9.2f |\n", sale.getFood().getFoodName(), sale.getQuantity(), sale.getTotalPrice());
        }

        System.out.println("+-------------------------------------+----------+-------------+");

        double totalSales = aggregatedSales.stream().mapToDouble(Sale::getTotalPrice).sum();
        double averageSales = totalSales / aggregatedSales.size();

        System.out.printf("| Total Sales                         |          | $%9.2f |\n", totalSales);
        System.out.printf("| Average Sales                       |          | $%9.2f |\n", averageSales);
        System.out.println("+-------------------------------------+----------+-------------+");
    }

    private static void displayMinimumSales(Map<Integer, List<Sale>> salesData, int startDay, int endDay) {
        List<Sale> salesInRange = new ArrayList<>();

        for (int day = startDay; day <= endDay; day++) {
            List<Sale> sales = salesData.get(day);
            if (sales != null) {
                salesInRange.addAll(sales);
            }
        }

        if (salesInRange.isEmpty()) {
            System.out.println("No sales data available for the specified range of days.");
            return;
        }

        Optional<Sale> minSale = salesInRange.stream()
                .min(Comparator.comparingDouble(Sale::getTotalPrice));

        if (minSale.isPresent()) {
            System.out.println("Minimum Sales (Day " + startDay + " - " + endDay + ")");
            System.out.println("+-------------------------------------+----------+-------------+");
            System.out.println("| Food                                | Quantity | Total Price |");
            System.out.println("+-------------------------------------+----------+-------------+");
            Sale sale = minSale.get();
            System.out.printf("| %-35s | %8d | $%9.2f |\n", sale.getFood().getFoodName(), sale.getQuantity(), sale.getTotalPrice());
            System.out.println("+-------------------------------------+----------+-------------+");
        } else {
            System.out.println("No sales data available for the specified range of days.");
        }
    }

    private static void displayMaximumSales(Map<Integer, List<Sale>> salesData, int startDay, int endDay) {
        List<Sale> salesInRange = new ArrayList<>();

        for (int day = startDay; day <= endDay; day++) {
            List<Sale> sales = salesData.get(day);
            if (sales != null) {
                salesInRange.addAll(sales);
            }
        }

        if (salesInRange.isEmpty()) {
            System.out.println("No sales data available for the specified range of days.");
            return;
        }

        Optional<Sale> maxSale = salesInRange.stream()
                .max(Comparator.comparingDouble(Sale::getTotalPrice));

        if (maxSale.isPresent()) {
            System.out.println("Maximum Sales (Day " + startDay + " - " + endDay + ")");
            System.out.println("+-------------------------------------+----------+-------------+");
            System.out.println("| Food                                | Quantity | Total Price |");
            System.out.println("+-------------------------------------+----------+-------------+");
            Sale sale = maxSale.get();
            System.out.printf("| %-35s | %8d | $%9.2f |\n", sale.getFood().getFoodName(), sale.getQuantity(), sale.getTotalPrice());
            System.out.println("+-------------------------------------+----------+-------------+");
        } else {
            System.out.println("No sales data available for the specified range of days.");
        }
    }

    private static void displayTopKHighestSales(Map<Integer, List<Sale>> salesData, int k, int startDay, int endDay) {
        List<Sale> salesInRange = new ArrayList<>();

        for (int day = startDay; day <= endDay; day++) {
            List<Sale> sales = salesData.get(day);
            if (sales != null) {
                salesInRange.addAll(sales);
            }
        }

        if (salesInRange.isEmpty()) {
            System.out.println("No sales data available for the specified range of days.");
            return;
        }

        if (k > salesInRange.size()) {
            System.out.println("Invalid value of k. There are fewer sales records available.");
            return;
        }

        salesInRange.sort(Comparator.comparingDouble(Sale::getTotalPrice).reversed());

        System.out.println("Top " + k + " Highest Sales (Day " + startDay + " - " + endDay + ")");
        System.out.println("+-------------------------------------+----------+-------------+");
        System.out.println("| Food                                | Quantity | Total Price |");
        System.out.println("+-------------------------------------+----------+-------------+");

        for (int i = 0; i < k; i++) {
            Sale sale = salesInRange.get(i);
            System.out.printf("| %-35s | %8d | $%9.2f |\n", sale.getFood().getFoodName(), sale.getQuantity(), sale.getTotalPrice());
        }

        System.out.println("+-------------------------------------+----------+-------------+");
    }
}
