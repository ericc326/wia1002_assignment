/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extrafeatures;

/**
 *
 * @author Asus
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BiteTheDust {
    
    public List<String> removeDuplicates(List<String> locations) {
        Set<String> uniqueLocations = new HashSet<>();
        List<String> result = new ArrayList<>();
        
        for (String location : locations) {
            if (!uniqueLocations.contains(location)) {
                uniqueLocations.add(location);
                result.add(location);
            }
        }
        return result;
    }
    
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Yoshikage Kira's path: ");
        String input = sc.nextLine();
        
        List<String> locations = new ArrayList<>();
        String[] locationArray = input.split("->");
        for (String location : locationArray) {
            locations.add(location.trim());
        }
        
        // Check the number of duplicates
        List<String> uniqueLocations = removeDuplicates(locations);
        if (locations.size() - uniqueLocations.size() > 2) {
            String output = String.join(" -> ", uniqueLocations);
            System.out.println("=".repeat(70));
            System.out.println("Bites the Dust is most likely to be activated when Kira passed through");
            System.out.println(output);
            System.out.println("=".repeat(70));
        } else {
            System.out.println("=".repeat(70));
            System.out.println("Bites the Dust is not activated.");
            System.out.println("=".repeat(70));
        }
    }
}
 

