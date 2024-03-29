/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package defaultmap;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import PartSal2.Residents;
import Restaurants.Customer;
import Restaurants.MilagroMan;
import Restaurants.MoodyBlues;
import Restaurants.Restaurant;
import Restaurants.Sale;
import extrafeatures.BiteTheDust;
import extrafeatures.TheGoldenSpirit;
import extrafeatures.VentoAureo;
import extrafeatures.TheGoldenSpirit;

/**
 *
 * @author Asus
 */
public class Defaultmap implements Serializable {
    public static LinkedList<map.Location.AdjacentLocation> adjacentLocations;
    public static map.Location currentLocation;
    public static int currentDay;
    public static map defaultMap, parallelMap, alternateMap, gameMap;
    public static String saveID = "gamejojo";
    private static Stack<map.Location> locationHistory;
    private static Stack<map.Location> ForwardLocationHistory;
    private static Scanner scanner;
    private static Residents residents = new Residents();
    private static Residents r = new Residents();

    public static void main(String[] args) throws IOException, ParseException {
        initializeGame();
        playGame();
    }

    public static void start() throws IOException, ParseException {
        initializeGame();
        playGame();
    }

    private static void initializeGame() throws IOException, ParseException {
        currentDay = 1;
        gameMap = new map();
        currentLocation = gameMap.townHall;
        locationHistory = new Stack<>();
        ForwardLocationHistory = new Stack<>();
        initializeMaps();
        showMainMenu();
    }

    private static void initializeMaps() {
        defaultMap = new map();
        parallelMap = new map();
        alternateMap = new map();
    }

    private static void showMainMenu() throws ParseException, IOException {
        System.out.println("Welcome to the fantastical realm of JOJOLands.");
        System.out.println("[1] Start Game");
        System.out.println("[2] Load Game");
        System.out.println("[3] Exit");
        System.out.print("Select: ");

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.println("======================================================================");

        switch (choice) {
            case 1:
                selectMap();
                break;
            case 2:
                handleLoadGame();
                // Continue the game from the loaded state
                break;
            case 3:
                System.out.println("Exiting the game...");
                System.exit(0); // Terminate the application
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                showMainMenu();
                break;
        }

    }

    private static void selectMap() {
        Restaurant.InitializeRestaurant();
        Customer.getAllResidentAsCustomer();
        Customer.doProcess();
        System.out.println("Select a map:");
        System.out.println("[1] Default Map");
        System.out.println("[2] Parallel Map");
        System.out.println("[3] Alternate Map");
        System.out.print("Select: ");

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.println("======================================================================");

        switch (choice) {
            case 1:
                startGame(defaultMap);
                break;
            case 2:
                startGame(parallelMap);
                break;
            case 3:
                startGame(alternateMap);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

    }

    private static void startGame(map selectedMap) {
        gameMap = selectedMap;

        // Set the correct townHall based on the selected map
        if (selectedMap == defaultMap) {
            currentLocation = defaultMap.townHall;
        } else if (selectedMap == parallelMap) {
            currentLocation = parallelMap.townHall1;
        } else if (selectedMap == alternateMap) {
            currentLocation = alternateMap.townHall2;
        }

        playGame();
    }

    public static void selectMap(map selectedMap) {
        gameMap = selectedMap;

        // Set the correct townHall based on the selected map
        if (selectedMap == defaultMap) {
            currentLocation = defaultMap.townHall;
        } else if (selectedMap == parallelMap) {
            currentLocation = parallelMap.townHall1;
        } else if (selectedMap == alternateMap) {
            currentLocation = alternateMap.townHall2;
        }
        // System.out.println("check");
    }

    public static void loadGame() {
        System.out.print("Enter the path of your save file: ");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
    }

    public static void handleLoad() {
        gameSaveLoad data = (gameSaveLoad) gameSaveLoad.load(saveID);
        String gameMapString = data.getGameMap();
        Restaurant.resList = data.getResList();
        Sale.saleList = data.getSaleList();
        Customer.CustomerDataLoad(data.getCustomerData());
        Defaultmap.currentLocation = data.getCurrentLocation();
        Defaultmap.currentDay = data.getCurrentDay();
        Defaultmap.locationHistory = data.getLocationHistory();
        Defaultmap.ForwardLocationHistory = data.getForwardLocationHistory();

        switch (gameMapString) {
            case "default":
                Defaultmap.gameMap = defaultMap;
                break;
            case "parallel":
                Defaultmap.gameMap = parallelMap;
                break;
            case "alternative":
                Defaultmap.gameMap = alternateMap;
                break;
            default:
                break;
        }
    }

    public static void handleLoadGame() {
        handleLoad();
        playGame();
    }

    private static void playGame() {
        boolean exitGame = false;
        while (!exitGame) {
            System.out.println(
                    "It's Day " + currentDay + " (" + getDayOfWeek(currentDay) + ") of our journey in JOJOLands!");
            System.out.println("Current Location: " + currentLocation.getName());
            System.out.println("[1] Move To:");

            LinkedList<map.Location.AdjacentLocation> adjacentLocations = currentLocation.getAdjacentLocations();
            for (int i = 0; i < adjacentLocations.size(); i++) {
                map.Location.AdjacentLocation adjacentLocation = adjacentLocations.get(i);
                String option = String.valueOf((char) ('A' + i));
                System.out.print("    [" + option + "] " + adjacentLocation.getLocation().getName() + "  ");
            }
            System.out.println();
            displayLocationOptions();
            if (exitGame) {
                break;
            }
        }
    }

    private static void displayLocationOptions() {

        // Check the current location and display options accordingly
        switch (currentLocation.getName()) {
            case "Town Hall":
                displayTownHallOptions();
                break;
            case "Cafe Deux Magots":
                displayCafeOptions();
                break;
            case "Jade Garden":
                displayCafeOptions();
                break;
            case "Morioh Grand Hotel":
                displayHotelOptions();
                break;
            case "Trattoria Trussardi":
                displayCafeOptions();
                break;
            case "Polnareff Land":
                displaPLOptions();
                break;
            case "Joestar Mansion":
                displayJMOptions();
                break;
            case "Angelo Rock":
                displayAROptions();
                break;
            case "San Giorgio Maggiore":
                displaySGMOptions();
                break;
            case "Green Dolphin Street Prison":
                displayGDSPOptions();
                break;
            case "Libeccio":
                displayCafeOptions();
                break;
            case "Vineyard":
                displayVineyardOptions();
                break;
            case "DIO's Mansion":
                displayDIOsMansionOptions();
                break;
            case "SavageGarden":
                displayCafeOptions();
                break;
            default:
                System.out.println("No options available at this location.");
                break;
        }
    }

    // Display options for the Town Hall location
    private static void displayTownHallOptions() {
        int i = 2;
        if (!locationHistory.isEmpty()) {
            System.out.printf("[%d] Back to (%s)\n", i, locationHistory.peek());
            i++;
        }
        if (!ForwardLocationHistory.isEmpty()) {
            System.out.printf("[%d] Forward (%s)\n", i, ForwardLocationHistory.peek());
            i++;
        }
        System.out.printf("[%d] Advance to Next Day\n", i);
        i++;
        System.out.printf("[%d] Save Game\n", i);
        i++;
        System.out.printf("[%d] Exit\n\n", i);

        System.out.print("\nSelect:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        switch (input.toUpperCase()) {
            case "1":
                handleMoveTo();
                break;
            case "2":
                if (!locationHistory.isEmpty()) {
                    System.out.println(!locationHistory.isEmpty());
                    handleReturnToPreviousLocation();
                } else if (locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleForwardToNewLocation();
                else if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                    handleAdvanceToNextDay();
                break;
            case "3":
                if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                    handleSaveGame();
                else if ((!locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                        || locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleAdvanceToNextDay();
                else if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleForwardToNewLocation();
                break;
            case "4":
                if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty()) {
                    System.out.println("Exiting the game......");
                    System.exit(0);
                } else if ((!locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                        || (!locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())) {
                    handleSaveGame();
                } else if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleAdvanceToNextDay();
                break;
            case "5":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleSaveGame();
                else if ((!locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                        || (locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())) {
                    System.out.println("Exiting the game......");
                    System.exit(0);
                } else if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                    System.out.println("Invalid input. Please choose again\n");
                break;
            case "6":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                    System.out.println("Exiting the game......");
                    System.exit(0);
                } else {
                    System.out.println("Invalid input. Please choose again\n");
                }
                break;
            default:
                System.out.println("Invalid input. Please choose again\n");
                break;
        }
        System.out.println("======================================================================");
    }

    // Display options for the five restaurant, Cafe Deux Magots, Trattoria
    // Trussardi, Jade Garden, Libeccio, Savage Garden
    private static void displayCafeOptions() {
        int i = 6;
        System.out.println("[2] View Waiting List and Order Processing List");
        System.out.println("[3] View Menu");
        System.out.println("[4] View Sales Information");
        System.out.println("[5] Milagro Man");
        if (!locationHistory.isEmpty()) {
            System.out.printf("[%d] Back (%s)\n", i, locationHistory.peek());
            i++;
        }
        if (!ForwardLocationHistory.isEmpty()) {
            System.out.printf("[%d] Forward (%s)\n", i, ForwardLocationHistory.peek());
            i++;
        }
        System.out.printf("[%d] Back to Town Hall\n\n", i);
        System.out.print("\nSelect:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        switch (input.toUpperCase()) {
            case "1":
                handleMoveTo();
                break;
            case "2":
                // jump to Pearl Jam (basic feature 3)
                handleWaitingList();
                break;
            case "3":
                // jump to Pearl Jam (basic feature 3)
                handleViewMenu();
                break;
            case "4":
                // jump to Moody Blue (basic feature 5)
                handleViewSales();
                break;
            case "5":
                // jump to Milagro Man (basic feature 6)
                handleMilagroMan();
                break;
            case "6":
                if (!locationHistory.isEmpty())
                    handleReturnToPreviousLocation();
                else if (locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleForwardToNewLocation();
                else if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                    handleDirectBackToTownHall();
                break;
            case "7":
                if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty()) {
                    System.out.println("Invalid input. Please choose again\n");
                } else if ((!locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                        || (locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())) {
                    handleDirectBackToTownHall();
                } else if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleForwardToNewLocation();
                break;
            case "8":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                    handleDirectBackToTownHall();
                }
                break;
            default:
                System.out.println("Invalid input. Please choose again\n");
                break;
        }
        System.out.println("======================================================================");
    }

    // Display options for the Morioh Grand Hotel location
    private static void displayHotelOptions() {
        int i = 4;
        System.out.println("[2] View Resident Information");
        System.out.println("[3] The Hand");
        if (!locationHistory.isEmpty()) {
            System.out.printf("[%d] Back (%s)\n", i, locationHistory.peek());
            i++;
        }
        if (!ForwardLocationHistory.isEmpty()) {
            System.out.printf("[%d] Forward (%s)\n", i, ForwardLocationHistory.peek());
            i++;
        }
        System.out.printf("[%d] Back to Town Hall\n\n", i);
        System.out.print("\nSelect:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        switch (input.toUpperCase()) {
            case "1":
                handleMoveTo();
                break;
            case "2":
                // jump to Heaven's Door (basic feature 2)
                handleViewResidentInformation(currentLocation.getName());
                break;
            case "3":
                // jump to Super Fly (basic feature 7);
                handleTheHand();
                break;
            case "4":
                if (!locationHistory.isEmpty())
                    handleReturnToPreviousLocation();
                else if (locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleForwardToNewLocation();
                else if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                    handleDirectBackToTownHall();
                break;
            case "5":
                if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty()) {
                    System.out.println("Invalid input. Please choose again\n");
                } else if ((!locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                        || (locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())) {
                    handleDirectBackToTownHall();
                } else if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleForwardToNewLocation();
                break;
            case "6":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleDirectBackToTownHall();
                else {
                    System.out.println("Invalid input. Please choose again\n");
                }
                break;
            default:
                System.out.println("Invalid input. Please choose again\n");
                break;
        }

        System.out.println("======================================================================");
    }

    // polnareff land
    private static void displaPLOptions() {
        int i = 3;
        System.out.println("[2] View Resident Information");
        if (!locationHistory.isEmpty()) {
            System.out.printf("[%d] Back (%s)\n", i, locationHistory.peek());
            i++;
        }
        if (!ForwardLocationHistory.isEmpty()) {
            System.out.printf("[%d] Forward (%s)\n", i, ForwardLocationHistory.peek());
            i++;
        }
        System.out.printf("[%d] Back to Town Hall\n\n", i);
        System.out.print("\nSelect:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        switch (input.toUpperCase()) {
            case "1":
                handleMoveTo();
                break;
            case "2":
                // jump to Heaven's Door (basic feature 2)
                handleViewResidentInformation(currentLocation.getName());
                break;
            case "3":
                r.r.clear();
                if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                } else if (locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                    handleForwardToNewLocation();
                } else if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty()) {
                    handleDirectBackToTownHall();
                }
                break;
            case "4":
                if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty()) {
                    System.out.println("Invalid input. Please choose again\n");
                } else if ((!locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                        || (locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())) {
                    handleDirectBackToTownHall();
                } else if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleForwardToNewLocation();
                break;
            case "5":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                    handleDirectBackToTownHall();
                } else {
                    System.out.println("Invalid input. Please choose again\n");
                }
                break;
            default:
                System.out.println("Invalid input. Please choose again\n");
                break;
        }
        System.out.println("======================================================================");
    }

    private static void displayJMOptions() {
        int i = 4;
        System.out.println("[2] View Resident Information");
        System.out.println("[3] The Golden Spirit");
        if (!locationHistory.isEmpty()) {
            System.out.printf("[%d] Back (%s)\n", i, locationHistory.peek());
            i++;
        }
        if (!ForwardLocationHistory.isEmpty()) {
            System.out.printf("[%d] Forward (%s)\n", i, ForwardLocationHistory.peek());
            i++;
        }
        System.out.printf("[%d] Back to Town Hall\n\n", i);
        System.out.print("\nSelect:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        switch (input.toUpperCase()) {
            case "1":
                handleMoveTo();
                break;
            case "2":
                // jump to basic feature 4
                handleViewResidentInformation(currentLocation.getName());
                break;
            case "3":
                // jump to extra feature 7
                TheGoldenSpirit();
                break;
            case "4":
                r.r.clear();
                if (!locationHistory.isEmpty())
                    handleReturnToPreviousLocation();
                else if (locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleForwardToNewLocation();
                else if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                    handleDirectBackToTownHall();
                break;
            case "5":
                if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty()) {
                    System.out.println("Invalid input. Please choose again\n");
                } else if ((!locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                        || (locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())) {
                    handleDirectBackToTownHall();
                } else if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleForwardToNewLocation();
                break;
            case "6":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleDirectBackToTownHall();
                else {
                    System.out.println("Invalid input. Please choose again\n");
                }
                break;
            default:
                System.out.println("Invalid input. Please choose again\n");
                break;
        }
        System.out.println("======================================================================");
    }

    // angelo rock
    private static void displayAROptions() {
        int i = 5;
        System.out.println("[2] View Resident Information");
        System.out.println("[3] Red Hot Chili Pepper");
        System.out.println("[4] Another One Bites the Dust");
        if (!locationHistory.isEmpty()) {
            System.out.printf("[%d] Back (%s)\n", i, locationHistory.peek());
            i++;
        }
        if (!ForwardLocationHistory.isEmpty()) {
            System.out.printf("[%d] Forward (%s)\n", i, ForwardLocationHistory.peek());
            i++;
        }
        System.out.printf("[%d] Back to Town Hall\n\n", i);
        System.out.print("\nSelect:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        switch (input.toUpperCase()) {
            case "1":
                handleMoveTo();
                break;
            case "2":
                handleViewResidentInformation(currentLocation.getName());
                break;
            case "3":
                r.r.clear();
                handleRedHotChiliPepper();
                break;
            case "4":
                AnotherOneBites();
                break;
            case "5":
                r.r.clear();
                if (!locationHistory.isEmpty())
                    handleReturnToPreviousLocation();
                else if (locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleForwardToNewLocation();
                else if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                    handleDirectBackToTownHall();
                break;
            case "6":
                if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty()) {
                    System.out.println("Invalid input. Please choose again\n");

                } else if ((!locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                        || (locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())) {
                    handleDirectBackToTownHall();
                } else if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleForwardToNewLocation();
                break;
            case "7":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleDirectBackToTownHall();
                else {
                    System.out.println("Invalid input. Please choose again\n");
                }
                break;
            default:
                System.out.println("Invalid input. Please choose again\n");
                break;
        }
        System.out.println("======================================================================");
    }

    // san giorgio maggiore
    private static void displaySGMOptions() {
        int i = 3;
        System.out.println("[2] View Resident Information");
        if (!locationHistory.isEmpty()) {
            System.out.printf("[%d] Back (%s)\n", i, locationHistory.peek());
            i++;
        }
        if (!ForwardLocationHistory.isEmpty()) {
            System.out.printf("[%d] Forward (%s)\n", i, ForwardLocationHistory.peek());
            i++;
        }
        System.out.printf("[%d] Back to Town Hall\n\n", i);
        System.out.print("\nSelect:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        switch (input.toUpperCase()) {
            case "1":
                handleMoveTo();
                break;
            case "2":
                // jump to Heaven's Door (basic feature 2)
                handleViewResidentInformation(currentLocation.getName());
                break;
            case "3":
                r.r.clear();
                if (!locationHistory.isEmpty())
                    handleReturnToPreviousLocation();
                else if (locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleForwardToNewLocation();
                else if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                    handleDirectBackToTownHall();
                break;
            case "4":
                if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty()) {
                    System.out.println("Invalid input. Please choose again\n");
                } else if ((!locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                        || (locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())) {
                    handleDirectBackToTownHall();
                } else if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleForwardToNewLocation();
                break;
            case "5":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleDirectBackToTownHall();
                else {
                    System.out.println("Invalid input. Please choose again\n");
                }
                break;
            default:
                System.out.println("Invalid input. Please choose again\n");
                break;
        }
        System.out.println("======================================================================");
    }

    // Green Dolphin Street Prison
    private static void displayGDSPOptions() {
        int i = 4;
        System.out.println("[2] View Resident Information");
        System.out.println("[3] Dirty Deeds Done Dirt Cheap");
        if (!locationHistory.isEmpty()) {
            System.out.printf("[%d] Back (%s)\n", i, locationHistory.peek());
            i++;
        }
        if (!ForwardLocationHistory.isEmpty()) {
            System.out.printf("[%d] Forward (%s)\n", i, ForwardLocationHistory.peek());
            i++;
        }
        System.out.printf("[%d] Back to Town Hall\n\n", i);
        System.out.print("\nSelect:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        switch (input.toUpperCase()) {
            case "1":
                handleMoveTo();
                break;
            case "2":
                // jump to Heaven's Door (basic feature 2)
                handleViewResidentInformation(currentLocation.getName());
                break;
            case "3":
                // jump to extra feature 4
                handleDirtyDeedsDoneDirtCheap();
                break;
            case "4":
                r.r.clear();
                if (!locationHistory.isEmpty())
                    handleReturnToPreviousLocation();
                else if (locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleForwardToNewLocation();
                else if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                    handleDirectBackToTownHall();
                break;
            case "5":
                if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty()) {
                    System.out.println("Invalid input. Please choose again\n");
                } else if ((!locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                        || (locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())) {
                    handleDirectBackToTownHall();
                } else if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleForwardToNewLocation();
                break;
            case "6":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleDirectBackToTownHall();
                else {
                    System.out.println("Invalid input. Please choose again\n");
                }
                break;
            default:
                System.out.println("Invalid input. Please choose again\n");
                break;
        }
        System.out.println("======================================================================");
    }

    private static void displayVineyardOptions() {
        int i = 4;
        System.out.println("[2] View Resident Information");
        System.out.println("[3] Vento Aureo");
        if (!locationHistory.isEmpty()) {
            System.out.printf("[%d] Back (%s)\n", i, locationHistory.peek());
            i++;
        }
        if (!ForwardLocationHistory.isEmpty()) {
            System.out.printf("[%d] Forward (%s)\n", i, ForwardLocationHistory.peek());
            i++;
        }
        System.out.printf("[%d] Back to Town Hall\n\n", i);
        System.out.print("\nSelect:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        switch (input.toUpperCase()) {
            case "1":
                handleMoveTo();
                break;
            case "2":
                // jump to Heaven's Door (basic feature 2)
                handleViewResidentInformation(currentLocation.getName());
                break;
            case "3":
                handleVentoAureo();
                break;
            case "4":
                r.r.clear();
                if (!locationHistory.isEmpty())
                    handleReturnToPreviousLocation();
                else if (locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleForwardToNewLocation();
                else if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                    handleDirectBackToTownHall();
                break;
            case "5":
                if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty()) {
                    System.out.println("Invalid input. Please choose again\n");
                } else if ((!locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                        || (locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())) {
                    handleDirectBackToTownHall();
                } else if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleForwardToNewLocation();
                break;
            case "6":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleDirectBackToTownHall();
                else {
                    System.out.println("Invalid input. Please choose again\n");
                }
                break;
            default:
                System.out.println("Invalid input. Please choose again\n");
                break;
        }
        System.out.println("======================================================================");
    }

    private static void displayDIOsMansionOptions() {
        int i = 3;
        System.out.println("[2] View Resident Information");
        if (!locationHistory.isEmpty()) {
            System.out.printf("[%d] Back (%s)\n", i, locationHistory.peek());
            i++;
        }
        if (!ForwardLocationHistory.isEmpty()) {
            System.out.printf("[%d] Forward (%s)\n", i, ForwardLocationHistory.peek());
            i++;
        }
        System.out.printf("[%d] Back to Town Hall\n\n", i);
        System.out.print("\nSelect:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        switch (input.toUpperCase()) {
            case "1":
                handleMoveTo();
                break;
            case "2":
                // jump to Heaven's Door (basic feature 2)
                handleViewResidentInformation(currentLocation.getName());
                break;
            case "3":
                if (!locationHistory.isEmpty())
                    handleReturnToPreviousLocation();
                else if (locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleForwardToNewLocation();
                else if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                    handleDirectBackToTownHall();
                break;
            case "4":
                if (locationHistory.isEmpty() && ForwardLocationHistory.isEmpty()) {
                    System.out.println("Invalid input. Please choose again\n");
                } else if ((!locationHistory.isEmpty() && ForwardLocationHistory.isEmpty())
                        || (locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())) {
                    handleDirectBackToTownHall();
                } else if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleForwardToNewLocation();
                break;
            case "5":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty())
                    handleDirectBackToTownHall();
                else {
                    System.out.println("Invalid input. Please choose again\n");
                }
                break;
            default:
                System.out.println("Invalid input. Please choose again\n");
                break;
        }
        System.out.println("======================================================================");
    }

    private static void handleMoveTo() {
        System.out.print("Enter the destination: ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().toUpperCase();

        if (input.length() != 1) {
            System.out.println("Invalid input. Please try again.");
            return;
        }

        char option = input.charAt(0);
        int index = option - 'A';

        if (index >= 0 && index < currentLocation.getAdjacentLocations().size()) {
            map.Location nextLocation = currentLocation.getAdjacentLocations().get(index).getLocation();
            moveToNextLocation(nextLocation);
        } else {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void moveToNextLocation(map.Location nextLocation) {
        locationHistory.push(currentLocation);
        ForwardLocationHistory.clear(); // Clear the ForwardLocationHistory stack before adding the new location
        currentLocation = nextLocation;
        System.out.println("Moving to " + currentLocation.getName() + ".");
    }

    public static void handleAdvanceToNextDay() {
        currentDay++;
        // r.readForMenu(currentDay);
        Customer.doProcess();
        // Set the currentLocation based on the selected map
        if (gameMap == defaultMap) {
            currentLocation = defaultMap.townHall;
        } else if (gameMap == parallelMap) {
            currentLocation = parallelMap.townHall1;
        } else if (gameMap == alternateMap) {
            currentLocation = alternateMap.townHall2;
        }
        locationHistory.clear();
        ForwardLocationHistory.clear();

    }

    public static String getDayOfWeek(int day) {
        String[] daysOfWeek = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

        if (day >= 1 && day <= 7) {
            return daysOfWeek[day - 1];
        } else {
            int normalizedDay = (day - 1) % 7;
            if (normalizedDay < 0) {
                normalizedDay += 7;
            }
            return daysOfWeek[normalizedDay];
        }
    }

    private static void handleSaveGame() {
        try {
            handleSave();
            System.out.println("Game saved successfully.");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("SAVE FAILED!");
            return;
        }
    }

    public static void handleSave() {
        String gameMapString = null;
        if (gameMap.equals(defaultMap)) {
            gameMapString = "default";
        } else if (gameMap.equals(parallelMap)) {
            gameMapString = "parallel";
        } else if (gameMap.equals(alternateMap)) {
            gameMapString = "alternative";
        }
        gameSaveLoad gsl = new gameSaveLoad(gameMapString, Restaurant.resList, Sale.saleList,
                Customer.CustomerDataSave(),
                currentLocation, currentDay, locationHistory, ForwardLocationHistory);
        System.out.println(locationHistory);
        System.out.println(ForwardLocationHistory);
        gameSaveLoad.save(gsl, saveID);
    }

    // method to move backward
    public static void handleReturnToPreviousLocation() {
        // System.out.println(!locationHistory.isEmpty());
        /*
         * if (!ForwardLocationHistory.isEmpty()) {
         * ForwardLocationHistory.clear();
         * }
         */
        map.Location reverseLocation = locationHistory.pop();
        if (!reverseLocation.equals(currentLocation)) {
            ForwardLocationHistory.push(currentLocation);
        }
        currentLocation = reverseLocation;

        System.out.println("Returning to " + currentLocation.getName() + ".");
    }

    // method to move ForwardLocationHistory
    public static void handleForwardToNewLocation() {
        locationHistory.push(currentLocation);
        currentLocation = ForwardLocationHistory.pop();
        System.out.println("Moving forward to " + currentLocation.getName() + ".");
        if (!ForwardLocationHistory.isEmpty()) {
            ForwardLocationHistory.clear();
        }
    }

    private static void handleDirectBackToTownHall() {
        // check if Town Hall is the backward/ForwardLocationHistory adjacent location
        if (!locationHistory.isEmpty() && locationHistory.peek().equals("Town Hall")) {
            locationHistory.pop();
            ForwardLocationHistory.push(currentLocation);
        } else if (!ForwardLocationHistory.isEmpty() && ForwardLocationHistory.peek().equals("Town Hall")) {
            locationHistory.push(currentLocation);
            ForwardLocationHistory.clear();
        } else {
            locationHistory.push(currentLocation);
            if (!ForwardLocationHistory.isEmpty())
                ForwardLocationHistory.clear();
        }
        // Set the currentLocation based on the selected map
        if (gameMap == defaultMap) {
            currentLocation = defaultMap.townHall;
        } else if (gameMap == parallelMap) {
            currentLocation = parallelMap.townHall1;
        } else if (gameMap == alternateMap) {
            currentLocation = alternateMap.townHall2;
        }
    }

    private static void handleWaitingList() {
        Customer.showRestaurantList(currentLocation.getName());
    }

    private static void handleViewMenu() {
        Restaurant res = new Restaurant();
        res.viewMenubyResName(currentLocation.getName());
    }

    private static void handleViewSales() {
        MoodyBlues.callMenu(currentLocation.getName());
    }

    private static void handleMilagroMan() {
        MilagroMan.MenuHandler(currentLocation.getName());
    }

    private static void handleViewResidentInformation(String place) {
        residents.readRes();
        residents.printRes(place);
        residents.r.clear();
    }

    private static void handleTheHand() {
        map myMap = new map();

        if (gameMap.equals(defaultMap)) {
            map.Location townHall = myMap.townHall;
            TheHand theHand = new TheHand(townHall);

            theHand.waterConnection();
        } else if (gameMap.equals(parallelMap)) {
            map.Location townHall = myMap.townHall1;
            TheHand theHand = new TheHand(townHall);

            theHand.waterConnection();
        } else {
            map.Location townHall = myMap.townHall2;
            TheHand theHand = new TheHand(townHall);

            theHand.waterConnection();
        }
    }

    private static void handleRedHotChiliPepper() {
        map myMap = new map();

        // Create an instance of RedHotChiliPepper using AngeloRock
        if (gameMap.equals(defaultMap)) {
            map.Location angeloRock = myMap.AngeloRock;
            RedHotChiliPepper chiliPepper = new RedHotChiliPepper(angeloRock);
            chiliPepper.necessaryPowerCable();
        } else if (gameMap.equals(parallelMap)) {
            map.Location angeloRock = myMap.AngeloRock1;
            RedHotChiliPepper chiliPepper = new RedHotChiliPepper(angeloRock);
            chiliPepper.necessaryPowerCable();
        } else {
            map.Location angeloRock = myMap.AngeloRock2;
            RedHotChiliPepper chiliPepper = new RedHotChiliPepper(angeloRock);
            chiliPepper.necessaryPowerCable();
        }
    }

    // method for Another One Bites the Dust
    public static void AnotherOneBites() {
        BiteTheDust bite = new BiteTheDust();
        bite.run();
    }

    private static void TheGoldenSpirit() {
        TheGoldenSpirit.buildFamilyTree();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the first Joestar: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter the name of the second Joestar: ");
        String name2 = scanner.nextLine();

        String lowestCommonAncestor = TheGoldenSpirit.findLowestCommonAncestor(name1, name2);

        if (name1.equals("George Joestar II")
                || name2.equals("George Joestar II") && lowestCommonAncestor.equals("Jonathan Joestar")) {
            lowestCommonAncestor += " and Erina Joestar";
        } else if (name1.equals("Jonathan Joestar")
                || name2.equals("Jonathan Joestar") && lowestCommonAncestor.equals("George Joestar I")) {
            lowestCommonAncestor += " and Mary Joestar";
        } else if (name1.equals("Joseph Joestar")
                || name2.equals("Joseph Joestar") && lowestCommonAncestor.equals("George Joestar II")) {
            lowestCommonAncestor += " and Lisa Lisa";
        } else if (name1.equals("Holy Kujo")
                || name2.equals("Holy Kujo") && lowestCommonAncestor.equals("Joseph Joestar")) {
            lowestCommonAncestor += " and Suzi Q.";
        } else if (name1.equals("Jotaro Kujo")
                || name2.equals("Jotaro Kujo") && lowestCommonAncestor.equals("Holy Kujo")) {
            lowestCommonAncestor += " and Sadao Kujo";
        }

        System.out.println("======================================================================");
        System.out.println("Lowest Common Ancestor of " + name1 + " and " + name2 + ":");
        System.out.println(lowestCommonAncestor);
        System.out.println("======================================================================");
    }

    private static void handleDirtyDeedsDoneDirtCheap() {
        String map = "";
        if (gameMap.equals(defaultMap)) {
            map = "defaultMap";
        } else if (gameMap.equals(alternateMap)) {
            map = "alternateMap";
        } else {
            map = "parallelMap";
        }
        DirtyDeedsDoneDirtCheap prison = new DirtyDeedsDoneDirtCheap();
        prison.initializeMap(map);
        prison.prisonerTravel();
    }

    private static void handleVentoAureo() {
        String map = "";
        if (gameMap.equals(defaultMap)) {
            map = "defaultMap";
        } else if (gameMap.equals(alternateMap)) {
            map = "alternateMap";
        } else {
            map = "parallelMap";
        }
        VentoAureo ventoAureo = new VentoAureo();
        ventoAureo.initializeMap(map);
        ventoAureo.startVentoAureo();
    }

}