/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jojolands;

/**
 *
 * @author Asus
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class JOJOLands {
     private Map<String, List<PlaceDistance>> adjacencyList;

    public JOJOLands() {
        adjacencyList = new HashMap<>();
    }

    public void addPlace(String place) {
        adjacencyList.put(place, new ArrayList<>());
    }

    public void addDistance(String place1, String place2, int distance) {
        adjacencyList.get(place1).add(new PlaceDistance(place2, distance));
        adjacencyList.get(place2).add(new PlaceDistance(place1, distance));
    }

    public List<PlaceDistance> getConnections(String place) {
        return adjacencyList.get(place);
    }
    
class PlaceDistance {
    private String place;
    private int distance;

    public PlaceDistance(String place, int distance) {
        this.place = place;
        this.distance = distance;
    }

    public String getPlace() {
        return place;
    }

    public int getDistance() {
        return distance;
    }

public static void main(String[] args) {
        JOJOLands map = new JOJOLands();

        // Add 14 places
        map.addPlace("Town Hall");
        map.addPlace("Morioh Grand Hotel");
        map.addPlace("Jade Garden");
        map.addPlace("Cafe Deux Magots");
        map.addPlace("Trattoria Trussardi");
        map.addPlace("San Giorgio Maggiore");
        map.addPlace("Green Dolphin Street Prison");
        map.addPlace("Libeccio");
        map.addPlace("Angela Rock");
        map.addPlace("Savage Garden");
        map.addPlace("Polnareff Land");
        map.addPlace("Joestar Mansion");
        map.addPlace("Vineyard");
        map.addPlace("DIO's Mansion");

        // Add distances
        map.addDistance("Town Hall", "Morioh Grand Hotel", 5);
        map.addDistance("Town Hall", "Jade Garden", 5);
        map.addDistance("Town Hall", "Cafe Deux Magots", 4);
        map.addDistance("Morioh Grand Hotel", "Town Hall", 5);
        map.addDistance("Morioh Grand Hotel", "Jade Garden", 3);
        map.addDistance("Morioh Grand Hotel", "Trattoria Trussardi", 6);       
        map.addDistance("Trattoria Trussardi", "Morioh Grand Hotel", 6);
        map.addDistance("Trattoria Trussardi", "San Giorgio Maggiore", 3);
        map.addDistance("Trattoria Trussardi", "Green dolphin Street Prison", 6);        
        map.addDistance("Green dolphin Street Prison", "Trattoria Trussardi", 6);
        map.addDistance("Green dolphin Street Prison", "Libeccio", 3);
        map.addDistance("Green dolphin Street Prison", "Angelo Rock", 2);
        map.addDistance("Polnareff Land", "Cafe Deux Magots", 4);        
        map.addDistance("Polnareff Land", "Savage Garden", 6);        
        map.addDistance("Cafe Deux Magots", "Town Hall", 4);
        map.addDistance("Cafe Deux Magots", "Polnareff Land", 4);
        map.addDistance("Cafe Deux Magots", "Jade Garden", 3);
        map.addDistance("Cafe Deux Magots", "Savage Garden", 4);
        map.addDistance("Jade Garden", "Town Hall", 5);
        map.addDistance("Jade Garden", "Cafe Deux Magots", 3);      
        map.addDistance("Jade Garden", "Morioh Grand Hotel", 3);
        map.addDistance("Jade Garden", "San Giorgio Maggiore", 2);
        map.addDistance("Jade Garden", "Joestar Mansion", 2);
        map.addDistance("San Giorgio Maggiore", "Jade Garden", 2);
        map.addDistance("San Giorgio Maggiore", "Trattoria Trussardi", 3);
        map.addDistance("San Giorgio Maggiore", "Libeccio", 4);
        map.addDistance("Libeccio", "San Giorgio Maggiore", 4);
        map.addDistance("Libeccio", "Joestar Mansion", 6);
        map.addDistance("Libeccio", "Vineyard", 6);
        map.addDistance("Libeccio", "DIO's Mansion", 2);
        map.addDistance("Libeccio", "Green dolphin Street Prison", 3);
        map.addDistance("Angelo Rock", "Green dolphin Street Prison", 2);
        map.addDistance("Angelo Rock", "DIO's Mansion", 3);
        map.addDistance("DIO's Mansion", "Libeccio", 2);
        map.addDistance("DIO's Mansion", "Vineyard", 3);
        map.addDistance("DIO's Mansion", "Angelo Rock", 3);
        map.addDistance("Joestar Mansion", "Jade Garden", 2);
        map.addDistance("Joestar Mansion", "Libeccio", 6);
        map.addDistance("Joestar Mansion", "Vineyard", 3);
        map.addDistance("Joestar Mansion", "Savage Garden", 4);
        map.addDistance("Savage Garden", "Polnareff Land", 6);
        map.addDistance("Savage Garden", "Cafe Deux Magots", 4);
        map.addDistance("Savage Garden", "Joestar Mansion", 4);
        map.addDistance("Savage Garden", "Vineyard", 8);
        map.addDistance("Vineyard", "Savage Garden", 8);
        map.addDistance("Vineyard", "Joestar Mansion", 3);
        map.addDistance("Vineyard", "Libeccio", 6);
        map.addDistance("Vineyard", "DIO's Mansion", 3);

        Scanner scanner = new Scanner(System.in);
        String currentLocation = "Town Hall";
        int currentDay = 1;

        System.out.println("It’s Day " + currentDay + " (Sunday) of our journey in JOJOLands!");
        System.out.println("Current Location: " + currentLocation);

        while (true) {
            System.out.println("[1] Move to:");
            String[] destinations = map.getConnections(currentLocation);
            for (int i = 0; i < destinations.length; i++) {
                System.out.println("[" + (i + 1) + "] " + destinations[i]);
            }
            System.out.println("[2] Advance to Next Day");
            System.out.println("[3] Save Game");
            System.out.println("[4] Exit");
            System.out.print("Select: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Select destination: ");
                int destinationIndex = scanner.nextInt();
                if (destinationIndex > 0 && destinationIndex <= destinations.length) {
                    currentLocation = destinations[destinationIndex - 1];
                    System.out.println("======================================================================");
                    System.out.println("Current Location: " + currentLocation);
                } else {
                    System.out.println("Invalid destination selection!");
                }
            } else if (choice == 2) {
                currentDay++;
                System.out.println("======================================================================");
                System.out.println("It’s Day " + currentDay + " of our journey in JOJOLands!");
                currentLocation = "Town Hall";
                System.out.println("Current Location: " + currentLocation);
            } else if (choice == 3) {
                System.out.println("Saving the game...");
                // Implement game saving functionality here
                System.out.println("Game saved successfully!");
            } else if (choice == 4) {
                System.out.println("Exiting the game...");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}
}