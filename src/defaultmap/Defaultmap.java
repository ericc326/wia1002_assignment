/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package defaultmap;

import java.io.*;
import java.util.*;
import java.util.concurrent.Flow.Processor;

import Restaurants.*;
import extrafeatures.*;
import PartSal2.*;

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
    private static boolean hasMadeBackMove = false;
    private static Scanner scanner;
    private static Residents r = new Residents();
    // private static map defaultMap;
    // private static map parallelMap;
    // private static map alternateMap;

    public static void main(String[] args) {
        initializeGame();
        playGame();
    }

    public static void start() {
        initializeGame();
        playGame();
    }

    private static void initializeGame() {
        gameMap = new map();
        currentLocation = gameMap.townHall;
        locationHistory = new Stack<>();
        ForwardLocationHistory = new Stack<>();
        currentDay = 1;
        r.readForMenu(currentDay);
        initializeMaps();
        showMainMenu();
    }

    public static void initializeGamePublic() {
        gameMap = new map();
        currentLocation = gameMap.townHall;
        locationHistory = new Stack<>();
        ForwardLocationHistory = new Stack<>();
        currentDay = 1;
        initializeMaps();
    }

    private static void initializeMaps() {
        defaultMap = new map();
        parallelMap = new map();
        alternateMap = new map();
    }

    private static void showMainMenu() {
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
        ProcessOrder.doProcess();
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

        currentDay = 1;

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
        System.out.println("check");
    }

    public static void loadGame() {
        System.out.print("Enter the path of your save file: ");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
    }

    public static void handleLoad() {
        gameSaveLoad data = (gameSaveLoad) gameSaveLoad.load(saveID);
        Defaultmap.gameMap = data.gameMap;
        Restaurant.resList = data.resList;
        Restaurant.saleList = data.saleList;
        Defaultmap.currentLocation = data.currentLocation;
        Defaultmap.currentDay = data.currentDay;
        Defaultmap.locationHistory = data.locationHistory;
        Defaultmap.ForwardLocationHistory = data.ForwardLocationHistory;
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
            Defaultmap.adjacentLocations = adjacentLocations;
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
                displayJadeGardenOptions();
                break;
            case "Morioh Grand Hotel":
                displayHotelOptions();
                break;
            case "Trattoria Trussardi":
                displayTTOptions();
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
                displayLibeccioOptions();
                break;
            case "Vineyard":
                displayVineyardOptions();
                break;
            case "DIO's Mansion":
                displayDIOsMansionOptions();
                break;
            case "SavageGarden":
                displaySGOptions();
                break;
            case "Passione Restaurant":
                displayPROptions();
                break;
            default:
                System.out.println("No options available at this location.");
                break;
        }
    }

    // Display options for the Town Hall location
    private static void displayTownHallOptions() {

        System.out.println("[2] Advance to Next Day");
        System.out.println("[3] Save Game");
        if (!locationHistory.isEmpty()) {
            map.Location previousLocation = locationHistory.peek();
            System.out.println("[4] Back (" + previousLocation.getName() + ")");
            if (hasMadeBackMove) {
                if (!ForwardLocationHistory.isEmpty()) {
                    map.Location forwardLocation = ForwardLocationHistory.peek();
                    System.out.println("[5] Forward (" + forwardLocation.getName() + ")");
                    System.out.println("[6] Exit");
                } else {
                    System.out.println("[5] Exit");
                }
            }
        } else {
            System.out.println("[4] Exit");
        }

        System.out.print("\nSelect:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        switch (input.toUpperCase()) {
            case "1":
                handleMoveTo();
                break;
            case "2":
                handleAdvanceToNextDay();
                break;
            case "3":
                handleSaveGame();
                break;
            case "4":
                if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                } else {
                    System.out.println("Exiting the game......");
                    System.exit(0); // Terminate the application
                }
                break;
            case "5":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                    handleForwardToNewLocation();
                } else {
                    System.out.println("Exiting the game......");
                    System.exit(0); // Terminate the application
                }
                break;
            case "6":
                if (hasMadeBackMove) {
                    System.out.println("Exiting the game......");
                    System.exit(0); // Terminate the application
                }
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

        System.out.println("======================================================================");
    }

    // Display options for the Cafe Deux Magots location
    private static void displayCafeOptions() {
        System.out.println("[2] View Waiting List and Order Processing List");
        System.out.println("[3] View Menu");
        System.out.println("[4] View Sales Information");
        System.out.println("[5] Milagro Man");
        if (!locationHistory.isEmpty()) {
            map.Location previousLocation = locationHistory.peek();
            System.out.println("[6] Back (" + previousLocation.getName() + ")");
            if (hasMadeBackMove) {
                if (!ForwardLocationHistory.isEmpty()) {
                    map.Location forwardLocation = ForwardLocationHistory.peek();
                    System.out.println("[7] Forward (" + forwardLocation.getName() + ")");
                    System.out.println("[8] Back To Town Hall");
                }
            } else {
                System.out.println("[7] Back To Town Hall");
            }
        } else {
            System.out.println("[6] Back To Town Hall");
        }
        System.out.print("\nSelect:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        switch (input.toUpperCase()) {
            case "1":
                handleMoveTo();
                break;
            case "2":
                handleWaitingList();
                break;
            case "3":
                handleViewMenu();
                break;
            case "4":
                handleViewSales();
                break;
            case "5":
                handleMilagroMan();
                break;
            case "6":
                if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "7":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                    handleForwardToNewLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "8":
                if (hasMadeBackMove) {
                    handleDirectBackToTownHall();
                }
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

        System.out.println("======================================================================");
    }

    // Display options for the Jade Garden location
    private static void displayJadeGardenOptions() {
        System.out.println("[2] View Waiting List and Order Processing List");
        System.out.println("[3] View Menu");
        System.out.println("[4] View Sales Information");
        System.out.println("[5] Milagro Man");
        if (!locationHistory.isEmpty()) {
            map.Location previousLocation = locationHistory.peek();
            System.out.println("[6] Back (" + previousLocation.getName() + ")");
            if (hasMadeBackMove) {
                if (!ForwardLocationHistory.isEmpty()) {
                    map.Location forwardLocation = ForwardLocationHistory.peek();
                    System.out.println("[7] Forward (" + forwardLocation.getName() + ")");
                    System.out.println("[8] Back To Town Hall");
                }
            } else {
                System.out.println("[7] Back To Town Hall");
            }
        } else {
            System.out.println("[6] Back To Town Hall");
        }
        System.out.print("\nSelect:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        switch (input.toUpperCase()) {
            case "1":
                handleMoveTo();
                break;
            case "2":
                handleWaitingList();
                break;
            case "3":
                handleViewMenu();
                break;
            case "4":
                handleViewSales();
                break;
            case "5":
                handleMilagroMan();
                break;
            case "6":
                if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "7":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                    handleForwardToNewLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "8":
                if (hasMadeBackMove) {
                    handleDirectBackToTownHall();
                }
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

        System.out.println("======================================================================");
    }

    // Display options for the Morioh Grand Hotel location
    private static void displayHotelOptions() {

        System.out.println("[2] View Resident Information");
        System.out.println("[3] The Hand");
        if (!locationHistory.isEmpty()) {
            map.Location previousLocation = locationHistory.peek();
            System.out.println("[4] Back (" + previousLocation.getName() + ")");
            if (hasMadeBackMove) {
                if (!ForwardLocationHistory.isEmpty()) {
                    map.Location forwardLocation = ForwardLocationHistory.peek();
                    System.out.println("[5] Forward (" + forwardLocation.getName() + ")");
                    System.out.println("[6] Back To Town Hall");
                }
            } else {
                System.out.println("[5] Back To Town Hall");
            }
        } else {
            System.out.println("[4] Back To Town Hall");
        }
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
                handleTheHand();
                break;
            case "4":
                if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "5":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                    handleForwardToNewLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "6":
                if (hasMadeBackMove) {
                    handleDirectBackToTownHall();
                }
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

        System.out.println("======================================================================");
    }

    private static void displayTTOptions() {

        System.out.println("[2] View Waiting List and Order Processing List");
        System.out.println("[3] View Menu");
        System.out.println("[4] View Sales Information");
        System.out.println("[5] Milagro Man");
        if (!locationHistory.isEmpty()) {
            map.Location previousLocation = locationHistory.peek();
            System.out.println("[6] Back (" + previousLocation.getName() + ")");
            if (hasMadeBackMove) {
                if (!ForwardLocationHistory.isEmpty()) {
                    map.Location forwardLocation = ForwardLocationHistory.peek();
                    System.out.println("[7] Forward (" + forwardLocation.getName() + ")");
                    System.out.println("[8] Back To Town Hall");
                }
            } else {
                System.out.println("[7] Back To Town Hall");
            }
        } else {
            System.out.println("[6] Back To Town Hall");
        }
        System.out.print("\nSelect:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        switch (input.toUpperCase()) {
            case "1":
                handleMoveTo();
                break;
            case "2":
                handleWaitingList();
                break;
            case "3":
                handleViewMenu();
            case "4":
                handleViewSales();
                break;
            case "5":
                handleMilagroMan();
                break;
            case "6":
                if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "7":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                    handleForwardToNewLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "8":
                if (hasMadeBackMove) {
                    handleDirectBackToTownHall();
                }
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

        System.out.println("======================================================================");
    }

    private static void displaPLOptions() {

        System.out.println("[2] View Resident Information");
        if (!locationHistory.isEmpty()) {
            map.Location previousLocation = locationHistory.peek();
            System.out.println("[3] Back (" + previousLocation.getName() + ")");
            if (!ForwardLocationHistory.isEmpty()) {
                map.Location forwardLocation = ForwardLocationHistory.peek();
                System.out.println("[4] Forward (" + forwardLocation.getName() + ")");
                System.out.println("[5] Back To Town Hall");
            } else {
                System.out.println("[4] Back To Town Hall");
            }
        } else {
            System.out.println("[3] Back To Town Hall");
        }

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
                r.r_clear();
                if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "4":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                    handleForwardToNewLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "5":
                if (hasMadeBackMove) {
                    handleDirectBackToTownHall();
                }
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

        System.out.println("======================================================================");
    }

    private static void displayJMOptions() {

        System.out.println("[2] View Resident Information");
        if (!locationHistory.isEmpty()) {
            map.Location previousLocation = locationHistory.peek();
            System.out.println("[3] Back (" + previousLocation.getName() + ")");
            if (hasMadeBackMove) {
                if (!ForwardLocationHistory.isEmpty()) {
                    map.Location forwardLocation = ForwardLocationHistory.peek();
                    System.out.println("[4] Forward (" + forwardLocation.getName() + ")");
                    System.out.println("[5] Back To Town Hall");
                }
            } else {
                System.out.println("[4] Back To Town Hall");
            }
        } else {
            System.out.println("[3] Back To Town Hall");
        }
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
                r.r_clear();
                if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "4":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                    handleForwardToNewLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "5":
                if (hasMadeBackMove) {
                    handleDirectBackToTownHall();
                }
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

        System.out.println("======================================================================");
    }

    private static void displayAROptions() {

        System.out.println("[2] View Resident Information");
        System.out.println("[3] Red Hot Chili Pepper");
        if (!locationHistory.isEmpty()) {
            map.Location previousLocation = locationHistory.peek();
            System.out.println("[4] Back (" + previousLocation.getName() + ")");
            if (hasMadeBackMove) {
                if (!ForwardLocationHistory.isEmpty()) {
                    map.Location forwardLocation = ForwardLocationHistory.peek();
                    System.out.println("[5] Forward (" + forwardLocation.getName() + ")");
                    System.out.println("[6] Back To Town Hall");
                }
            } else {
                System.out.println("[5] Back To Town Hall");
            }
        } else {
            System.out.println("[4] Back To Town Hall");
        }
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
                r.r_clear();
                handleRedHotChiliPepper();
                break;
            case "4":
                if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "5":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                    handleForwardToNewLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "6":
                if (hasMadeBackMove) {
                    handleDirectBackToTownHall();
                }
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

        System.out.println("======================================================================");
    }

    private static void displaySGMOptions() {

        System.out.println("[2] Advance to Next Day");
        if (!locationHistory.isEmpty()) {
            map.Location previousLocation = locationHistory.peek();
            System.out.println("[3] Back (" + previousLocation.getName() + ")");
            if (hasMadeBackMove) {
                if (!ForwardLocationHistory.isEmpty()) {
                    map.Location forwardLocation = ForwardLocationHistory.peek();
                    System.out.println("[4] Forward (" + forwardLocation.getName() + ")");
                    System.out.println("[5] Back To Town Hall");
                }
            } else {
                System.out.println("[4] Back To Town Hall");
            }
        } else {
            System.out.println("[3] Back To Town Hall");
        }
        System.out.print("\nSelect:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        switch (input.toUpperCase()) {
            case "1":
                handleMoveTo();
                break;
            case "2":
                handleAdvanceToNextDay();
                break;
            case "3":
                r.r_clear();
                if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "4":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                    handleForwardToNewLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "5":
                if (hasMadeBackMove) {
                    handleDirectBackToTownHall();
                }
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

        System.out.println("======================================================================");
    }

    private static void displayGDSPOptions() {

        System.out.println("[2] Advance to Next Day");
        if (!locationHistory.isEmpty()) {
            map.Location previousLocation = locationHistory.peek();
            System.out.println("[3] Back (" + previousLocation.getName() + ")");
            if (hasMadeBackMove) {
                if (!ForwardLocationHistory.isEmpty()) {
                    map.Location forwardLocation = ForwardLocationHistory.peek();
                    System.out.println("[4] Forward (" + forwardLocation.getName() + ")");
                    System.out.println("[5] Back To Town Hall");
                }
            } else {
                System.out.println("[4] Back To Town Hall");
            }
        } else {
            System.out.println("[3] Back To Town Hall");
        }
        System.out.print("\nSelect:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        switch (input.toUpperCase()) {
            case "1":
                handleMoveTo();
                break;
            case "2":
                handleAdvanceToNextDay();
                break;
            case "3":
                r.r_clear();
                if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "4":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                    handleForwardToNewLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "5":
                if (hasMadeBackMove) {
                    handleDirectBackToTownHall();
                }
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

        System.out.println("======================================================================");
    }

    private static void displayLibeccioOptions() {
        System.out.println("[2] View Waiting List and Order Processing List");
        System.out.println("[3] View Menu");
        System.out.println("[4] View Sales Information");
        System.out.println("[5] Milagro Man");
        if (!locationHistory.isEmpty()) {
            map.Location previousLocation = locationHistory.peek();
            System.out.println("[6] Back (" + previousLocation.getName() + ")");
            if (hasMadeBackMove) {
                if (!ForwardLocationHistory.isEmpty()) {
                    map.Location forwardLocation = ForwardLocationHistory.peek();
                    System.out.println("[7] Forward (" + forwardLocation.getName() + ")");
                    System.out.println("[8] Back To Town Hall");
                }
            } else {
                System.out.println("[7] Back To Town Hall");
            }
        } else {
            System.out.println("[6] Back To Town Hall");
        }
        System.out.print("\nSelect:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        switch (input.toUpperCase()) {
            case "1":
                handleMoveTo();
                break;
            case "2":
                handleWaitingList();
                break;
            case "3":
                handleViewMenu();
                break;
            case "4":
                handleViewSales();
                break;
            case "5":
                handleMilagroMan();
                break;
            case "6":
                if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "7":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                    handleForwardToNewLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "8":
                if (hasMadeBackMove) {
                    handleDirectBackToTownHall();
                }
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

        System.out.println("======================================================================");
    }

    private static void displayVineyardOptions() {
        System.out.println("[2] View Resident Information");
        System.out.println("[3] Vento Aureo");
        if (!locationHistory.isEmpty()) {
            map.Location previousLocation = locationHistory.peek();
            System.out.println("[4] Back (" + previousLocation.getName() + ")");
            if (!ForwardLocationHistory.isEmpty()) {
                map.Location forwardLocation = ForwardLocationHistory.peek();
                System.out.println("[5] Forward (" + forwardLocation.getName() + ")");
                System.out.println("[6] Back To Town Hall");
            } else {
                System.out.println("[5] Back To Town Hall");
            }
        } else {
            System.out.println("[4] Back To Town Hall");
        }

        System.out.print("\nSelect:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        switch (input.toUpperCase()) {
            case "1":
                handleMoveTo();
                break;
            case "2":
                handleAdvanceToNextDay();
                break;
            case "3":
                handleVentoAureo();
            case "4":
                r.r_clear();
                if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "5":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                    handleForwardToNewLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "6":
                if (hasMadeBackMove) {
                    handleDirectBackToTownHall();
                }
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

        System.out.println("======================================================================");
    }

    private static void displayDIOsMansionOptions() {

        System.out.println("[2] View Resident Information");
        if (!locationHistory.isEmpty()) {
            map.Location previousLocation = locationHistory.peek();
            System.out.println("[3] Back (" + previousLocation.getName() + ")");
            if (hasMadeBackMove) {
                if (!ForwardLocationHistory.isEmpty()) {
                    map.Location forwardLocation = ForwardLocationHistory.peek();
                    System.out.println("[4] Forward (" + forwardLocation.getName() + ")");
                    System.out.println("[5] Back To Town Hall");
                }
            } else {
                System.out.println("[4] Back To Town Hall");
            }
        } else {
            System.out.println("[3] Back To Town Hall");
        }

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
                r.r_clear();
                if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "4":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                    handleForwardToNewLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "5":
                if (hasMadeBackMove) {
                    handleDirectBackToTownHall();
                }
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

        System.out.println("======================================================================");
    }

    private static void displaySGOptions() {
        System.out.println("[2] View Waiting List and Order Processing List");
        System.out.println("[3] View Menu");
        System.out.println("[4] View Sales Information");
        System.out.println("[5] Milagro Man");
        if (!locationHistory.isEmpty()) {
            map.Location previousLocation = locationHistory.peek();
            System.out.println("[6] Back (" + previousLocation.getName() + ")");
            if (hasMadeBackMove) {
                if (!ForwardLocationHistory.isEmpty()) {
                    map.Location forwardLocation = ForwardLocationHistory.peek();
                    System.out.println("[7] Forward (" + forwardLocation.getName() + ")");
                    System.out.println("[8] Back To Town Hall");
                }
            } else {
                System.out.println("[7] Back To Town Hall");
            }
        } else {
            System.out.println("[6] Back To Town Hall");
        }
        System.out.print("\nSelect:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        switch (input.toUpperCase()) {
            case "1":
                handleMoveTo();
                break;
            case "2":
                handleWaitingList();
                break;
            case "3":
                handleViewMenu();
                break;
            case "4":
                handleViewSales();
                break;
            case "5":
                handleMilagroMan();
                break;
            case "6":
                if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "7":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                    handleForwardToNewLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "8":
                if (hasMadeBackMove) {
                    handleDirectBackToTownHall();
                }
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

        System.out.println("======================================================================");
    }

    private static void displayPROptions() {

        System.out.println("[2] View Waiting List and Order Processing List");
        System.out.println("[3] View Menu");
        System.out.println("[4] View Sales Information");
        System.out.println("[5] Milagro Man");
        if (!locationHistory.isEmpty()) {
            map.Location previousLocation = locationHistory.peek();
            System.out.println("[6] Back (" + previousLocation.getName() + ")");
            if (hasMadeBackMove) {
                if (!ForwardLocationHistory.isEmpty()) {
                    map.Location forwardLocation = ForwardLocationHistory.peek();
                    System.out.println("[7] Forward (" + forwardLocation.getName() + ")");
                    System.out.println("[8] Back To Town Hall");
                }
            } else {
                System.out.println("[7] Back To Town Hall");
            }
        } else {
            System.out.println("[6] Back To Town Hall");
        }

        System.out.print("\nSelect:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        switch (input.toUpperCase()) {
            case "1":
                handleMoveTo();
                break;
            case "2":
                handleWaitingList();
                break;
            case "3":
                handleViewMenu();
                break;
            case "4":
                handleViewSales();
                break;
            case "5":
                handleMilagroMan();
                break;
            case "6":
                if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "7":
                if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                    handleForwardToNewLocation();
                } else {
                    handleDirectBackToTownHall();
                }
                break;
            case "8":
                if (hasMadeBackMove) {
                    handleDirectBackToTownHall();
                }
                break;
            default:
                System.out.println("Invalid input. Please try again.");
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
        currentLocation = nextLocation;
        System.out.println("Moving to " + currentLocation.getName() + ".");
        hasMadeBackMove = false;
    }

    public static void handleAdvanceToNextDay() {
        currentDay++;
        r.readForMenu(currentDay);
        ProcessOrder.doProcess();
        // Set the currentLocation based on the selected map
        if (gameMap == defaultMap) {
            currentLocation = defaultMap.townHall;
        } else if (gameMap == parallelMap) {
            currentLocation = parallelMap.townHall1;
        } else if (gameMap == alternateMap) {
            currentLocation = alternateMap.townHall2;
        }
        locationHistory.clear();
    }

    public static String getDayOfWeek(int day) {
        String[] daysOfWeek = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

        if (day >= 1 && day <= 7) {
            return daysOfWeek[day - 1];
        } else {
            return "";
        }
    }

    private static void handleSaveGame() {
        // Define the file path where the console output will be saved
        String filePath = "console_output.txt";
        try {
            handleSave();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("FAILED!");
            return;
        }
        try (PrintWriter fileWriter = new PrintWriter(new FileWriter(filePath))) {
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save the game. Please try again.");
        }
    }

    public static void handleSave() {
        gameSaveLoad gsl = new gameSaveLoad(gameMap, Restaurant.resList, Restaurant.saleList, currentLocation,
                currentDay, locationHistory, ForwardLocationHistory);
        gameSaveLoad.save(gsl, saveID);
    }

    private static void handleReturnToPreviousLocation() {
        if (!locationHistory.isEmpty()) {
            map.Location previousLocation = locationHistory.pop();
            ForwardLocationHistory.push(currentLocation);// push
            currentLocation = previousLocation;
            System.out.println("Returning to " + currentLocation.getName() + ".");
            hasMadeBackMove = true;
        } else {
            System.out.println("No previous location available.");
        }
    }

    private static void handleForwardToNewLocation() {
        if (!ForwardLocationHistory.isEmpty()) {
            map.Location nextLocation = ForwardLocationHistory.pop();
            locationHistory.push(currentLocation); // Store the current location in the back history
            currentLocation = nextLocation;
            System.out.println("Moving forward to " + currentLocation.getName() + ".");
            hasMadeBackMove = false;
        } else {
            System.out.println("No forward location available.");
        }
    }

    private static void handleDirectBackToTownHall() {
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

    private static void handleWaitingList() {

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
        r.readRes();
        r.printRes(place, currentDay);
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