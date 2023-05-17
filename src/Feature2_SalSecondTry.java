/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package feature2_sal;

/**
 *
 * @author USER
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Feature2_SalSecondTry {
    public static void main(String[] args) {
        
        HashMap <String, List<String>> hash1 = new HashMap <>();
        
        //Polnareff Land, Morioh Grand Hotel, San Giorgio Maggiore, Joestar Mansion, Vineyard, DIO's Mansion, Angelo Rock
        String input = "San Giorgio Maggiore";
        
        information(input);
    }
    
    public static void information(String input){
        
        HashMap <String, List<String>> hash1 = new HashMap <>();
        HashMap <String, List<String>> hash2 = new HashMap <>();
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> profile1 = new ArrayList<>();
        ArrayList<String> profile2 = new ArrayList<>();
        
        try {
                // TODO code application logic here
                 Scanner scan1 = new Scanner(new FileReader("residents.csv"));
                 Scanner scan2 = new Scanner(new FileReader("stands.csv"));
                                       
                System.out.println("Resident information in "+input);
                System.out.println("+----+------------------------------+-----+--------+---------------------+---------------------+----------+----------+------------+------------+-------------------+");
                System.out.println("| No | Name                         | Age | Gender | Stand               | Destructive power   |   Speed  |   Range  |   Stamina  | P/recision | Development Power |");
                System.out.println("+----+------------------------------+-----+--------+---------------------+---------------------+----------+----------+------------+------------+-------------------+");
                      
            
                int count = 0;
                String head = scan1.nextLine();
                while(scan1.hasNextLine()){
                String s = scan1.nextLine();
                Pattern pat = Pattern.compile(input);
                Matcher match = pat.matcher(s);
                if(match.find()){
                list1.add(s);
                count++;
                                }
                                   }
                                        
                for(int index=0; index<list1.size(); index++){
                String[] resident = list1.get(index).split(",");
                int x = resident.length;
                
                profile1.add(resident[1]);
                profile1.add(resident[2]);
                profile1.add(resident[3]);
                if(resident[4].equals("N/A")){
                profile1.add(resident[4]);
                                            }
                else if(x==6){
                                                    
                String parents = resident[4] +" & "+resident[5];
                profile1.add(parents);
                                                    
                              }
                else{
                     profile1.add(resident[4]);
                                                
                      }   
                hash1.put(resident[0],profile1);
                          }
                                        
                String head2 = scan2.nextLine();
                while(scan2.hasNextLine()){
                String standline = scan2.nextLine();
                list2.add(standline);
                                           }
                                        
                for(int index=0; index<list2.size(); index++){
                String[] standlist = list2.get(index).split(",");
                
                profile2.add(standlist[1]);
                profile2.add(standlist[2]);
                profile2.add(standlist[3]);
                profile2.add(standlist[4]);
                profile2.add(standlist[5]);
                profile2.add(standlist[6]);
                profile2.add(standlist[7]);
                
                hash2.put(standlist[0],profile2);
                                                              }
                        for (String key : hash1.keySet()) {
    // Check if the key exists in map2
    if (hash2.containsKey(key)) {
        // Compare the values associated with the key for similarities
        List<String> value1 = hash1.get(key);
        List<String> value2 = hash2.get(key);
        
        if (value1.equals(value2)) {
            System.out.println("Key " + key + " has the same value in both maps");
        } else {
            System.out.println("Key " + key + " exists in both maps, but the values are different");
        }
    } else {
        System.out.println("Key " + key + " only exists in map1");
    }
}                  } catch (FileNotFoundException ex) {
                              System.out.println("ldsnjskfn");
                          
                          }
    }
}
