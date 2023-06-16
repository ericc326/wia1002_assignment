/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author USER
 */
public class DirtyDeedsDoneDirtCheap {
    private map myMap;
    private String mapType;
    
    
    public DirtyDeedsDoneDirtCheap(){
        this.myMap=new map();
    }
    
    public void initializeMap(String mapType){
        if(mapType.equals("defaultMap")){
            this.mapType="defaultMap";
        }
        else if(mapType.equals("parallelMap")){
            this.mapType="parallelMap";
        }
         else if(mapType.equals("alternateMap")){
            this.mapType="alternateMap";
        }
    }
    
   public void prisonerTravel() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Source: ");
        String source = scanner.nextLine();


        while (!myMap.hasLocation(source,this.mapType)) {
            System.out.println("Invalid start location! Please try again.");
            
            System.out.print("Source: ");
            source = scanner.nextLine();
        }


        System.out.print("Destination: ");
        String destination = scanner.nextLine();
        
        while (!myMap.hasLocation(destination,this.mapType)) {
            System.out.println("Invalid destination location! Please try again.");
            
            System.out.print("Destination: ");
            destination = scanner.nextLine();
        }


        List<List<map.Location>> shortestPaths = calculateShortestPaths(myMap, source, destination);
        
        System.out.println("======================================================================");
        System.out.println("Top 3 Shortest paths:");
        displayThreePaths(myMap,shortestPaths);
        System.out.println("======================================================================");
    }
    
    
    private List<List<map.Location>> calculateShortestPaths(map myMap, String sourceLocation, String destinationLocation) {
        map.Location source = myMap.getLocationByName(sourceLocation,this.mapType);
        map.Location destination = myMap.getLocationByName(destinationLocation,this.mapType);


        List<List<map.Location>> allShortestPaths = new ArrayList<>();
        List<map.Location> currentPath = new ArrayList<>();
        Set<map.Location> visited = new HashSet<>();

        currentPath.add(source);
        visited.add(source);

        calculatePathsDFS(myMap, source, destination, currentPath, allShortestPaths, visited);

        PriorityQueue<List<map.Location>> pathQueue = new PriorityQueue<>(Comparator.comparingInt(this::calculateTotalDistance));
        pathQueue.addAll(allShortestPaths);

        List<List<map.Location>> sortedPaths = new ArrayList<>();
        while (!pathQueue.isEmpty()) {
            sortedPaths.add(pathQueue.poll());
        }

        for(int i=sortedPaths.size()-1 ; i>2 ; i--){
            sortedPaths.remove(i);
        }

        return sortedPaths;
    }
    
    private void calculatePathsDFS(map myMap, map.Location source, map.Location destination,List<map.Location> currentPath, List<List<map.Location>> allShortestPaths,Set<map.Location> visited) {
        if (source.equals(destination)) {
            allShortestPaths.add(new ArrayList<>(currentPath));
            return;
        }

        for (map.Location.AdjacentLocation adjacentLocation : source.getAdjacentLocations()) {
            map.Location nextLocation = adjacentLocation.getLocation();

            if (!visited.contains(nextLocation)) {
                visited.add(nextLocation);
                currentPath.add(nextLocation);

                calculatePathsDFS(myMap, nextLocation, destination, currentPath, allShortestPaths, visited);

                visited.remove(nextLocation);
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }
    
    private int calculateTotalDistance(List<map.Location> path) {
        int totalDistance = 0;
        
        for (int i = 0; i < path.size() - 1; i++) {
            map.Location currentLocation = path.get(i);
            map.Location nextLocation = path.get(i + 1);
            int distance = myMap.getDistanceBetweenLocations(currentLocation, nextLocation);
            totalDistance += distance;
        }
        return totalDistance;
    }
    
    public void displayThreePaths(map myMap,List<List<map.Location>> shortestPaths){
        int num=1;
        for (List<map.Location> shortestPath : shortestPaths) {
            int currentIndex = 0;
            System.out.printf("%d. ",num++);
            for (map.Location path :shortestPath ) {
                if (currentIndex == shortestPath.size() - 1) {
                    System.out.print(path.getName());
                } else {
                    System.out.print(path.getName() + " → ");
                }
                currentIndex++;
            }
            int totalDistance = 0;
                for (int i = 0; i < shortestPath.size() - 1; i++) {
                    map.Location currentLocation = shortestPath.get(i);
                    map.Location nextLocation = shortestPath.get(i + 1);
                    int distance = myMap.getDistanceBetweenLocations(currentLocation, nextLocation);
                    totalDistance += distance;        }
                System.out.printf("(%d km)",totalDistance);
                System.out.println("");
        } 
    }
}
