/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PearlJam;

/**
 *
 * @author USER
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import VentoAureo.*;


/**
 *
 * @author 
 */
public class LATESTMAP  extends Residents{
    
    public static void main(String[] args) {
        
        LATESTMAP mayor = new LATESTMAP();
        mayor.initializeGame();
        mayor.playGame();
    }
    private  map.Location currentLocation;
    private  Stack<map.Location> locationHistory;
    private  Stack<map.Location> ForwardLocationHistory;
    private  int currentDay;
    private  map gameMap;
    private  boolean hasMadeBackMove = false;
    private  Scanner scanner;
    private  map defaultMap;
    private map parallelMap;
    private map alternateMap;
    


    private void initializeGame() {
        gameMap = new map();
        currentLocation = gameMap.townHall;
        locationHistory = new Stack<>();
        ForwardLocationHistory = new Stack<>();
        currentDay = 1;
        readForMenu(currentDay);
        initializeMaps();
        showMainMenu();
    }
    
    private void initializeMaps() {
     defaultMap = new map();
     parallelMap = new map();
     alternateMap = new map();
}
        private void showMainMenu() {
        System.out.println("Welcome to the fantastical realm of JOJOLands.");
        System.out.println("[1] Start Game");
        System.out.println("[2] Load Game");
        System.out.println("[3] Exit");
        System.out.print("Select: ");
        

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        System.out.println("==================================================================================================================");

        switch (choice) {
            case 1:
                selectMap();
                break;
            case 2:
                loadGame();
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

    private void selectMap() {
        
        Restaurant.InitializeRestaurant();
        System.out.println("Select a map:");
        System.out.println("[1] Default Map");
        System.out.println("[2] Parallel Map");
        System.out.println("[3] Alternate Map");
        System.out.print("Select: ");

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        System.out.println("==================================================================================================================");
        
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

    private void startGame(map selectedMap) {
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

    private void loadGame() {
        System.out.print("Enter the path of your save file: ");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
    }

    private void playGame() {
        boolean exitGame = false;
        currentDay = 1;
        while (!exitGame) {
            System.out.println("It's Day " + currentDay + " (" + getDayOfWeek(currentDay) + ") of our journey in JOJOLands!");
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
        if(exitGame){
            break;
            }
        }
      }    
          
    private void displayLocationOptions(){
    
           // Check the current location and display options accordingly
           String place = currentLocation.getName();
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
    private void displayTownHallOptions() {
   
        System.out.println("[2] Advance to Next Day");
        System.out.println("[3] Save Game");
        if (!locationHistory.isEmpty()) {
        map.Location previousLocation = locationHistory.peek();
        System.out.println("[4] Back (" + previousLocation.getName() + ")");
        if(hasMadeBackMove) {
            if (!ForwardLocationHistory.isEmpty()) {
            map.Location forwardLocation = ForwardLocationHistory.peek();
            System.out.println("[5] Forward (" + forwardLocation.getName() + ")");
            System.out.println("[6] Exit");
        }else{
        System.out.println("[5] Exit");
        }
        }} else {
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
                    if(hasMadeBackMove) {
                                System.out.println("Exiting the game......");
                                System.exit(0); // Terminate the application
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

            System.out.println("==================================================================================================================");
        }

    // Display options for the Cafe Deux Magots location
    private void displayCafeOptions() {
    
        System.out.println("[2] View Waiting List and Order Processing List");
        System.out.println("[3] View Menu");
        System.out.println("[4] View Sales Information");
        System.out.println("[5] Milagro Man");
        if (!locationHistory.isEmpty()) {
        map.Location previousLocation = locationHistory.peek();
        System.out.println("[6] Back (" + previousLocation.getName() + ")");
        if(hasMadeBackMove) {
            if (!ForwardLocationHistory.isEmpty()) {
            map.Location forwardLocation = ForwardLocationHistory.peek();
            System.out.println("[7] Forward (" + forwardLocation.getName() + ")");
        System.out.println("[8] Back To Town Hall");
        }}else{
        System.out.println("[7] Back To Town Hall");
        }}else{
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
                        } else{
                        handleDirectBackToTownHall();
                    }
                        break;
                case "8":
                    if(hasMadeBackMove) {
                        handleDirectBackToTownHall(); 
                    }
                        break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

            System.out.println("==================================================================================================================");
         }
    
    // Display options for the Jade Garden location
    private void displayJadeGardenOptions() {
        
        System.out.println("[2] View Waiting List and Order Processing List");
        System.out.println("[3] View Menu");
        System.out.println("[4] View Sales Information");
        System.out.println("[5] Milagro Man");
        if (!locationHistory.isEmpty()) {
        map.Location previousLocation = locationHistory.peek();
        System.out.println("[6] Back (" + previousLocation.getName() + ")");
        if(hasMadeBackMove) {
            if (!ForwardLocationHistory.isEmpty()) {
            map.Location forwardLocation = ForwardLocationHistory.peek();
            System.out.println("[7] Forward (" + forwardLocation.getName() + ")");
        System.out.println("[8] Back To Town Hall");
        }}else{
        System.out.println("[7] Back To Town Hall");
        }}else{
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
                        } else{
                        handleDirectBackToTownHall();
                    }
                        break;
                case "8":
                    if(hasMadeBackMove) {
                        handleDirectBackToTownHall(); 
                    }
                        break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

            System.out.println("==================================================================================================================");
        }

    // Display options for the Morioh Grand Hotel location
    private void displayHotelOptions() {

    
        System.out.println("[2] View Resident Information");
        System.out.println("[3] The Hand");
        if (!locationHistory.isEmpty()) {
        map.Location previousLocation = locationHistory.peek();
        System.out.println("[4] Back (" + previousLocation.getName() + ")");
        if(hasMadeBackMove) {
            if (!ForwardLocationHistory.isEmpty()) {
            map.Location forwardLocation = ForwardLocationHistory.peek();
            System.out.println("[5] Forward (" + forwardLocation.getName() + ")");
        System.out.println("[6] Back To Town Hall");
        }}else{
        System.out.println("[5] Back To Town Hall");
        }}else{
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
                        } else{
                        handleDirectBackToTownHall();
                    }
                    break;
                case "6":
                    if(hasMadeBackMove) {
                        handleDirectBackToTownHall(); 
                    }
                    else{
                       System.out.println("Invalid input. Please try again.");
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

            System.out.println("==================================================================================================================");
        }
    
    
    //Trattoria Trussardi
    private void displayTTOptions() {
    
        System.out.println("[2] View Waiting List and Order Processing List");
        System.out.println("[3] View Menu");
        System.out.println("[4] View Sales Information");
        System.out.println("[5] Milagro Man");
        if (!locationHistory.isEmpty()) {
        map.Location previousLocation = locationHistory.peek();
        System.out.println("[6] Back (" + previousLocation.getName() + ")");
        if(hasMadeBackMove) {
            if (!ForwardLocationHistory.isEmpty()) {
            map.Location forwardLocation = ForwardLocationHistory.peek();
            System.out.println("[7] Forward (" + forwardLocation.getName() + ")");
        System.out.println("[8] Back To Town Hall");
        }}else{
        System.out.println("[7] Back To Town Hall");
        }}else{
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
                        } else{
                        handleDirectBackToTownHall();
                    }
                    break;
                case "8":
                    if(hasMadeBackMove) {
                        handleDirectBackToTownHall(); 
                    }
                    else{
                         System.out.println("Invalid input. Please try again.");
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

            System.out.println("==================================================================================================================");
        }

    
    //Polnareff Land
    private void displaPLOptions() {
    
        
        System.out.println("[2] View Resident Information");
        if (!locationHistory.isEmpty()) {
        map.Location previousLocation = locationHistory.peek();
        System.out.println("[3] Back (" + previousLocation.getName() + ")");
            if (!ForwardLocationHistory.isEmpty()) {
            map.Location forwardLocation = ForwardLocationHistory.peek();
            System.out.println("[4] Forward (" + forwardLocation.getName() + ")");
        System.out.println("[5] Back To Town Hall");
        }else{
        System.out.println("[4] Back To Town Hall");
        }}else{
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
                case "3":r_clear();
                    if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                    } else {
                    handleDirectBackToTownHall();
                    }
                    break;
                case "4":
                    if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                       handleForwardToNewLocation();
                        } else{
                        handleDirectBackToTownHall();
                    }
                    break;
                case "5":
                    if(hasMadeBackMove) {
                        handleDirectBackToTownHall(); 
                    }
                    else{
                         System.out.println("Invalid input. Please try again.");
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

            System.out.println("==================================================================================================================");
        }

    //Joestar mansion
    private void displayJMOptions() {
    
       
        
        System.out.println("[2] View Resident Information");
        if (!locationHistory.isEmpty()) {
        map.Location previousLocation = locationHistory.peek();
        System.out.println("[3] Back (" + previousLocation.getName() + ")");
        if(hasMadeBackMove) {
            if (!ForwardLocationHistory.isEmpty()) {
            map.Location forwardLocation = ForwardLocationHistory.peek();
            System.out.println("[4] Forward (" + forwardLocation.getName() + ")");
        System.out.println("[5] Back To Town Hall");
        }}else{
        System.out.println("[4] Back To Town Hall");
        }}else{
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
                case "3":r_clear();
                    if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                    } else {
                    handleDirectBackToTownHall();
                    }
                    break;
                case "4":
                    if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                       handleForwardToNewLocation();
                        } else{
                        handleDirectBackToTownHall();
                    }
                    break;
                case "5":
                    if(hasMadeBackMove) {
                        handleDirectBackToTownHall(); 
                    }
                    else{
                         System.out.println("Invalid input. Please try again.");
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

            System.out.println("==================================================================================================================");
        }

    
    //Angelo Rock
    private void displayAROptions() {
    
    
        System.out.println("[2] View Resident Information");
        System.out.println("[3] Red Hot Chili Pepper");
        if (!locationHistory.isEmpty()) {
        map.Location previousLocation = locationHistory.peek();
        System.out.println("[4] Back (" + previousLocation.getName() + ")");
        if(hasMadeBackMove) {
            if (!ForwardLocationHistory.isEmpty()) {
            map.Location forwardLocation = ForwardLocationHistory.peek();
            System.out.println("[5] Forward (" + forwardLocation.getName() + ")");
        System.out.println("[6] Back To Town Hall");
        }}else{
        System.out.println("[5] Back To Town Hall");
        }}else{
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
                case "3":r_clear();
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
                        } else{
                        handleDirectBackToTownHall();
                    }
                    break;
                case "6":
                    if(hasMadeBackMove) {
                        handleDirectBackToTownHall(); 
                    }
                    else{
                         System.out.println("Invalid input. Please try again.");
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

            System.out.println("==================================================================================================================");
        }
    
    //San Giorgio Maggiore
    private void displaySGMOptions() {

        
        System.out.println("[2] View Resident Information");
        if (!locationHistory.isEmpty()) {
        map.Location previousLocation = locationHistory.peek();
        System.out.println("[3] Back (" + previousLocation.getName() + ")");
            if (!ForwardLocationHistory.isEmpty()) {
            map.Location forwardLocation = ForwardLocationHistory.peek();
            System.out.println("[4] Forward (" + forwardLocation.getName() + ")");
        System.out.println("[5] Back To Town Hall");
        }else{
        System.out.println("[4] Back To Town Hall");
        }}else{
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
                case "3":r_clear();
                    if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                    } else {
                    handleDirectBackToTownHall();
                    }
                    break;
                case "4":
                    if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                       handleForwardToNewLocation();
                        } else{
                        handleDirectBackToTownHall();
                    }
                    break;
                case "5":
                    if(hasMadeBackMove) {
                        handleDirectBackToTownHall(); 
                    }
                    else{
                         System.out.println("Invalid input. Please try again.");
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

            System.out.println("==================================================================================================================");
        }
       
    
    //Green Dolphin Street Prison
    private void displayGDSPOptions() {

    
        System.out.println("[2] View Resident Information");
        if (!locationHistory.isEmpty()) {
        map.Location previousLocation = locationHistory.peek();
        System.out.println("[3] Back (" + previousLocation.getName() + ")");
            if (!ForwardLocationHistory.isEmpty()) {
            map.Location forwardLocation = ForwardLocationHistory.peek();
            System.out.println("[4] Forward (" + forwardLocation.getName() + ")");
        System.out.println("[5] Back To Town Hall");
        }else{
        System.out.println("[4] Back To Town Hall");
        }}else{
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
                case "3":r_clear();
                    if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                    } else {
                    handleDirectBackToTownHall();
                    }
                    break;
                case "4":
                    if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                       handleForwardToNewLocation();
                        } else{
                        handleDirectBackToTownHall();
                    }
                    break;
                case "5":
                    if(hasMadeBackMove) {
                        handleDirectBackToTownHall(); 
                    }
                    else{
                         System.out.println("Invalid input. Please try again.");
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

            System.out.println("==================================================================================================================");
    }

    private void displayLibeccioOptions() {
    
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
    
    //Vineyard
    private void displayVineyardOptions() {
       
       System.out.println("[2] View Resident Information");
        System.out.println("[3] Vento Aureo");
        if (!locationHistory.isEmpty()) {
        map.Location previousLocation = locationHistory.peek();
        System.out.println("[4] Back (" + previousLocation.getName() + ")");
            if (!ForwardLocationHistory.isEmpty()) {
            map.Location forwardLocation = ForwardLocationHistory.peek();
            System.out.println("[5] Forward (" + forwardLocation.getName() + ")");
        System.out.println("[6] Back To Town Hall");
        }else{
        System.out.println("[5] Back To Town Hall");
        }}else{
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
                case "3":handleVentoAureo();
                case "4":r_clear();
                    if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                    } else {
                    handleDirectBackToTownHall();
                    }
                    break;
                case "5":
                    if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                       handleForwardToNewLocation();
                        } else{
                        handleDirectBackToTownHall();
                    }
                    break;
                case "6":
                    if(hasMadeBackMove) {
                        handleDirectBackToTownHall(); 
                    }
                    else{
                         System.out.println("Invalid input. Please try again.");
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

            System.out.println("==================================================================================================================");
        }
    
    
    //Dio mansion
    private void displayDIOsMansionOptions() {
        
        System.out.println("[2] View Resident Information");
        if (!locationHistory.isEmpty()) {
        map.Location previousLocation = locationHistory.peek();
        System.out.println("[3] Back (" + previousLocation.getName() + ")");
            if (!ForwardLocationHistory.isEmpty()) {
            map.Location forwardLocation = ForwardLocationHistory.peek();
            System.out.println("[4] Forward (" + forwardLocation.getName() + ")");
        System.out.println("[5] Back To Town Hall");
        }else{
        System.out.println("[4] Back To Town Hall");
        }}else{
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
                case "3":r_clear();
                    if (!locationHistory.isEmpty()) {
                    handleReturnToPreviousLocation();
                    } else {
                    handleDirectBackToTownHall();
                    }
                    break;
                case "4":
                    if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                       handleForwardToNewLocation();
                        } else{
                        handleDirectBackToTownHall();
                    }
                    break;
                case "5":
                    if(hasMadeBackMove) {
                        handleDirectBackToTownHall(); 
                    }
                    else{
                         System.out.println("Invalid input. Please try again.");
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

            System.out.println("==================================================================================================================");
        } 
    
    
    //Savage Garden
    private void displaySGOptions() {
        
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
    
    //Passione Restaurant
    private void displayPROptions(){

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
            
    private void handleMoveTo() {
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

    private void moveToNextLocation(map.Location nextLocation) {
        locationHistory.push(currentLocation);
        currentLocation = nextLocation;
        System.out.println("Moving to " + currentLocation.getName() + ".");
        hasMadeBackMove = false;
    }

private void handleAdvanceToNextDay() {
    currentDay++;
    readForMenu(currentDay);
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

    public  String getDayOfWeek(int day) {
    String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    if (day >= 1 && day <= 7) {
        return daysOfWeek[day - 1];
    } else {
        return "";
    }
}

private void handleSaveGame() {
    // Define the file path where the console output will be saved1
    
    String filePath = "console_output.txt";

    try (PrintWriter fileWriter = new PrintWriter(new FileWriter(filePath))) {

        System.out.println("Game saved successfully.");
    } catch (IOException e) {
        System.out.println("Failed to save the game. Please try again.");
    }
}

    private void handleReturnToPreviousLocation() {
    if (!locationHistory.isEmpty()) {
        map.Location previousLocation = locationHistory.pop();
        ForwardLocationHistory.push(currentLocation);//push
        currentLocation = previousLocation;
        System.out.println("Returning to " + currentLocation.getName() + ".");
        hasMadeBackMove = true;
    } else {
        System.out.println("No previous location available.");
    }
}
    
    private void handleForwardToNewLocation() {
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

    private void handleDirectBackToTownHall() {
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

    private void handleWaitingList() {
       
        
    }

    private void handleViewMenu() {
        
    }

    private void handleViewSales() {
    }

    private void handleMilagroMan() {
        
        MilagroMan.MenuHandler(currentLocation.getName());
        
    }
    private void handleViewResidentInformation(String place) {
       readRes();
       printRes(place,currentDay);
    }

    private void handleTheHand() {
        
         map myMap = new map();
  
        if(gameMap.equals(defaultMap)){
        map.Location townHall = myMap.townHall;
        TheHand theHand = new TheHand(townHall);

        theHand.waterConnection();
        }
        else if(gameMap.equals(parallelMap)){
        map.Location townHall = myMap.townHall1;
        TheHand theHand = new TheHand(townHall);

        theHand.waterConnection();
        }
        else{
        map.Location townHall = myMap.townHall2;
        TheHand theHand = new TheHand(townHall);

        theHand.waterConnection();
        }
    }

    private void handleRedHotChiliPepper() {
        
        map myMap = new map();

        // Create an instance of RedHotChiliPepper using AngeloRock
        if(gameMap.equals(defaultMap)){
        map.Location angeloRock = myMap.AngeloRock;
        RedHotChiliPepper chiliPepper = new RedHotChiliPepper(angeloRock);
        chiliPepper.necessaryPowerCable();
        }
        else if(gameMap.equals(parallelMap)){
        map.Location angeloRock = myMap.AngeloRock1;
        RedHotChiliPepper chiliPepper = new RedHotChiliPepper(angeloRock);
                chiliPepper.necessaryPowerCable();
        }
        else{
        map.Location angeloRock = myMap.AngeloRock2;
        RedHotChiliPepper chiliPepper = new RedHotChiliPepper(angeloRock);
        chiliPepper.necessaryPowerCable();
    }

}
    
    private void handleVentoAureo(){
        String map ="";
        if(gameMap.equals(defaultMap)){
            map = "defaultMap";
        }
        else if(gameMap.equals(alternateMap)){
            map = "alternateMap";
        }
        else{
            map = "parallelMap";
        }
        VentoAureo ventoAureo = new VentoAureo();
        ventoAureo.initializeMap(map);
        ventoAureo.startVentoAureo();
    }
}

