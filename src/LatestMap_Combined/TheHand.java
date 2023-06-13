/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LatestMap_Combined;

/**
 *
 * @author USER
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author USER
 */
public class TheHand {
    private map.Location firstPlace;
    List<map.Location> locationList;
    
        
    public TheHand(map.Location firstPlace){
        this.firstPlace=firstPlace;
    }
        
    public void waterConnection() {
        PriorityQueue<Water> queue = new PriorityQueue<>();
        Set<map.Location> visited = new HashSet<>();
        List<Water> allConnection = new ArrayList<>();

        visited.add(firstPlace);

        for (map.Location.AdjacentLocation adjPlace : firstPlace.getAdjacentLocations()) {
            Water water = new Water(firstPlace, adjPlace.getLocation(), adjPlace.getDistance());
            queue.add(water);
            allConnection.add(water);
        }

        List<Water> necessaryConnection = new ArrayList<>();
        List<Water> removedConnection = new ArrayList<>();

        while (!queue.isEmpty()) {
            Water minConnection = queue.poll();

            map.Location currentPlace = minConnection.getLastPlace();

            if (visited.contains(currentPlace)) {
                continue;
            }

            visited.add(currentPlace);
            necessaryConnection.add(minConnection);

            for (map.Location.AdjacentLocation adjPlace : currentPlace.getAdjacentLocations()) {
                map.Location nextPlace = adjPlace.getLocation();
                if (!visited.contains(nextPlace)) {
                    Water water = new Water(currentPlace, nextPlace, adjPlace.getDistance());
                    queue.add(water);
                    allConnection.add(water);
                }
            }
        }

//        displayNecessaryWaterConnection(necessaryConnection);
        displayUnnecessaryWaterConnection(allConnection, necessaryConnection);
    }

    public void displayUnnecessaryWaterConnection(List<Water> allConnection, List<Water> necessaryConnection) {
        List<Water> unnecessaryConnection = new ArrayList<>(allConnection);
        unnecessaryConnection.removeAll(necessaryConnection);

        int totalLength = 0;
            int i=1;
            System.out.println("======================================================================");
            System.out.println("Unnecessary Water Connection:");
            for (Water water : unnecessaryConnection) {
                System.out.printf("%2d. %-20s --- %-27s(%d km)",i,water.getStartPlace().getName(),water.getLastPlace().getName(),water.getDistance());
                System.out.println("");
                totalLength += water.getDistance();
                i++;
        }
        System.out.println("Total Length: " + totalLength+" km");
        System.out.println("======================================================================");
    }

    
   private void displayNecessaryWaterConnection(List<Water> necessaryConnection){
            int totalLength = 0;
            int i=1;
            System.out.println("======================================================================");
            System.out.println("Necessary water connection:");
            for (Water water : necessaryConnection) {
                System.out.printf("%2d. %-20s --- %-27s(%d km)",i,water.getStartPlace().getName(),water.getLastPlace().getName(),water.getDistance());
                System.out.println("");
                totalLength += water.getDistance();
                i++;
        }
        System.out.println("Total Length: " + totalLength+" km");
        System.out.println("======================================================================");

    }


    public class Water implements Comparable<Water>{
        private map.Location firstPlace;
        private map.Location lastPlace;
        private int distance;
        
        public Water(map.Location firstPlace,map.Location lastPlace,int distance){
            this.firstPlace=firstPlace;
            this.lastPlace=lastPlace;
            this.distance=distance;
        }
        
        public map.Location getStartPlace(){
            return firstPlace;
        }
        
        public map.Location getLastPlace(){
            return lastPlace;
        }
        
        public int getDistance(){
            return distance;
        }

        @Override
        public int compareTo(Water other) {
            return Integer.compare(this.distance, other.distance);
     }
  }
}
