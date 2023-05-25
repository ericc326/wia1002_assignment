/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package defaultmap;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Asus
 */
public class Defaultmap1 {
    private static map.Location currentLocation;
    private static Stack<map.Location> locationHistory;
    private static Stack<map.Location> ForwardLocationHistory;
    private static int currentDay;
    private static map gameMap;
    private static boolean hasMadeBackMove = false;

    public static void main(String[] args) {
        initializeGame();
        playGame();
    }

    private static void initializeGame() {
        gameMap = new map();
        currentLocation = gameMap.townHall;
        locationHistory = new Stack<>();
        ForwardLocationHistory = new Stack<>();
        currentDay = 1;
    }

    private static void playGame() {
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
          
    private static void displayLocationOptions(){
    
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

                default:
                    System.out.println("No options available at this location.");
                    break;
            }
    }
                    
    // Display options for the Town Hall location
    private static void displayTownHallOptions() {
        boolean exitGame = false;
   
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
                                    exitGame = true;
                                    System.out.println("Exiting the game......");
                                     }
                    break;
                case "5":
                    if (!locationHistory.isEmpty() && !ForwardLocationHistory.isEmpty()) {
                        handleForwardToNewLocation();
                         } else {
                                 exitGame = true;
                                System.out.println("Exiting the game......");
                                }
                    break;
                case "6":
                    if(hasMadeBackMove) {
                        exitGame = true;
                        System.out.println("Exiting the game......");
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
        boolean exitGame = false;
    
        System.out.println("[2] Advance to Next Day");
        System.out.println("[3] Save Game");
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
                    handleAdvanceToNextDay();
                    break;
                case "3":
                    handleSaveGame();
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
                        break;
            }
            System.out.println("======================================================================");
        }
    
    // Display options for the Jade Garden location
    private static void displayJadeGardenOptions() {
        boolean exitGame = false;
        
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

            System.out.println("======================================================================");
        }

    // Display options for the Morioh Grand Hotel location
    private static void displayHotelOptions() {
        boolean exitGame = false;
    
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
                    handleViewResidentInformation();
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
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

            System.out.println("======================================================================");
        }
    
    private static void displayTTOptions() {
        boolean exitGame = false;
    
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

            System.out.println("======================================================================");
        }

    private static void displaPLOptions() {
        boolean exitGame = false;
    
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
                    handleViewResidentInformation();
                    break;
                case "3":
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
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

            System.out.println("======================================================================");
        }

    private static void displayJMOptions() {
        boolean exitGame = false;
    
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
                    handleViewResidentInformation();
                    break;
                case "3":
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
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

            System.out.println("======================================================================");
        }

    private static void displayAROptions() {
        boolean exitGame = false;
    
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
                    handleViewResidentInformation();
                    break;
                case "3":
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
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

            System.out.println("======================================================================");
        }
    
    private static void displaySGMOptions() {
        boolean exitGame = false;
    
        System.out.println("[2] Advance to Next Day");
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
                    handleAdvanceToNextDay();
                    break;
                case "3":
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
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

            System.out.println("======================================================================");
        }
       
    private static void displayGDSPOptions() {
        boolean exitGame = false;
    
        System.out.println("[2] Advance to Next Day");
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
                    handleAdvanceToNextDay();
                    break;
                case "3":
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
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

            System.out.println("======================================================================");
    }

    private static void displayLibeccioOptions() {
        boolean exitGame = false;
    
        System.out.println("[2] Advance to Next Day");
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
                    handleAdvanceToNextDay();
                    break;
                case "3":
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
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

            System.out.println("======================================================================");
        }   
    
    private static void displayVineyardOptions() {
        boolean exitGame = false;

        System.out.println("[2] Advance to Next Day");
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
                    handleAdvanceToNextDay();
                    break;
                case "3":
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
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

            System.out.println("======================================================================");
        }
    
    private static void displayDIOsMansionOptions() {
       boolean exitGame = false;
    
        System.out.println("[2] Advance to Next Day");
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
                    handleAdvanceToNextDay();
                    break;
                case "3":
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
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

            System.out.println("======================================================================");
        } 
    
    private static void displaySGOptions() {
        boolean exitGame = false;
        System.out.println("[2] Advance to Next Day");
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
                    handleAdvanceToNextDay();
                    break;
                case "3":
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

    private static void handleAdvanceToNextDay() {
        currentDay++;
        currentLocation = gameMap.townHall;
        locationHistory.clear();
}

    private static String getDayOfWeek(int day) {
    String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    if (day >= 1 && day <= 7) {
        return daysOfWeek[day - 1];
    } else {
        return "";
    }
}

private static void handleSaveGame() {
    // Define the file path where the console output will be saved
    String filePath = "console_output.txt";

    try (PrintWriter fileWriter = new PrintWriter(new FileWriter(filePath))) {
        // Save the console content (game state) to the file

        System.out.println("Game saved successfully.");
    } catch (IOException e) {
        System.out.println("Failed to save the game. Please try again.");
    }
}

    private static void handleReturnToPreviousLocation() {
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
        currentLocation = gameMap.townHall;
        locationHistory.clear();
}

    private static void handleWaitingList() {
        
    }

    private static void handleViewMenu() {
        
    }

    private static void handleViewSales() {
        
    }

    private static void handleMilagroMan() {
        
    }

    private static void handleViewResidentInformation() {
       
    }

    private static void handleTheHand() {
        
    }

    private static void handleRedHotChiliPepper() {
        
    }
   
}