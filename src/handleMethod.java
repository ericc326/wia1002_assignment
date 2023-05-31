/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class handleMethod {
    private static map.Location currentLocation;
    private static Stack<map.Location> locationHistory;
    private static Stack<map.Location> ForwardLocationHistory;
    private static int currentDay;
    private static map gameMap;

    public static void main(String[] args) {
        handleRedHotChiliPepper();
        handleTheHand();
    }

    
    private static void handleRedHotChiliPepper() {
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
    }
    
    private static void handleTheHand() {
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
    

}