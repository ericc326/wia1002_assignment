/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PearlJam;

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
public class RedHotChiliPepper{
        private map.Location firstPlace;
        
        public RedHotChiliPepper(map.Location firstPlace){
            this.firstPlace=firstPlace;
        }
        
        public void necessaryPowerCable(){
            PriorityQueue<Cable> queue=new PriorityQueue<>();
            Set<map.Location> visited=new HashSet<>();
            
            visited.add(firstPlace);
            
            for(map.Location.AdjacentLocation adjPlace:firstPlace.getAdjacentLocations()){
                queue.add(new Cable(firstPlace,adjPlace.getLocation(),adjPlace.getDistance()));
            }
            
            List<Cable> selectedCable = new ArrayList<>();
            
            while(!queue.isEmpty()){
                Cable minCable=queue.poll();
                
                map.Location currentPlace=minCable.getLastPlace();
                
                if(visited.contains(currentPlace)){
                    continue;
                }
                
                visited.add(currentPlace);
                selectedCable.add(minCable);
                
                for(map.Location.AdjacentLocation adjPlace : currentPlace.getAdjacentLocations()){
                    map.Location nextPlace=adjPlace.getLocation();
                    if (!visited.contains(nextPlace)){
                        queue.add(new Cable(currentPlace,nextPlace,adjPlace.getDistance()));
                    }
                }
            }
            displayNecessaryPowerCable(selectedCable);
            
        }
        
        private void displayNecessaryPowerCable(List<Cable> selectedCable){
            int totalLength = 0;
            int i=1;
            System.out.println("======================================================================");
            System.out.println("Necessary Power Cables to be Upgraded:");
            for (Cable cable : selectedCable) {
                System.out.printf("%2d. %-20s --- %-27s(%d km)",i,cable.getStartPlace().getName(),cable.getLastPlace().getName(),cable.getDistance());
                System.out.println("");
                totalLength += cable.getDistance();
                i++;
        }
        System.out.println("Total Length: " + totalLength+" km");
        System.out.println("======================================================================");

        }
        
        
    
    
    public class Cable implements Comparable<Cable>{
        private map.Location firstPlace;
        private map.Location lastPlace;
        private int distance;
        
        public Cable(map.Location firstPlace,map.Location lastPlace,int distance){
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
        public int compareTo(Cable other) {
            return Integer.compare(this.distance, other.distance);
      } 
    }
}
