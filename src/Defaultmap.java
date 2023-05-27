/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package defaultmap;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class Defaultmap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// Create a map object
    map jojoLands = new map();

    // Create a player object
        map.Location currentLocation = jojoLands.townHall;

    // Create a scanner object to read user input
    Scanner scanner = new Scanner(System.in);

    // Game loop
    boolean isRunning = true;
    while (isRunning) {
        System.out.println("Current Location: " + currentLocation.getName());
        System.out.println("[1] Move to:");

        LinkedList<map.Location.AdjacentLocation> adjacentLocations = currentLocation.getAdjacentLocations();
        for (int i = 0; i < adjacentLocations.size(); i++) {
            map.Location.AdjacentLocation adjacentLocation = adjacentLocations.get(i);
            String option = String.valueOf((char)('A' + i));
            System.out.print("     [" + option + "] " + adjacentLocation.getLocation().getName() + " ".repeat(5));
        }
        System.out.println(" ");
        System.out.println("[2] Advance to Next Day");
        System.out.println("[3] Save Game");
        System.out.println("[4] Exit");
        System.out.print("Select: ");

        // Read user input
        String userInput = scanner.nextLine();

        switch (userInput) {
           case "1":
              System.out.print("Enter the destination: ");
              String destinationOption = scanner.nextLine().toUpperCase();
              char optionChar = destinationOption.charAt(0);
              int index = optionChar - 'A';
              if (index >= 0 && index < adjacentLocations.size()) {
              map.Location.AdjacentLocation selectedAdjacentLocation = adjacentLocations.get(index);
              currentLocation = selectedAdjacentLocation.getLocation();
              System.out.println("Moving to " + currentLocation.getName() + ".");
                 } else {
                  System.out.println("Invalid destination.");
                }
                 break;
            case "2":
                System.out.println("Advancing to the next day...");
                // Perform logic for advancing to the next day
                break;
            case "3":
                System.out.println("Saving the game...");
                // Perform logic for saving the game
                break;
            case "4":
                isRunning = false;
                System.out.println("Exiting the game...");
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }

        System.out.println("======================================================================");
    }

    // Close the scanner
    scanner.close();
}
}