
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pembetulan;

/**
 *
 * @author USER
 */
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Residents{
    
    ArrayList<String> Name,Age,Gender,ResidentialArea,Parents,newName,newAge,newGender,newParent,newStand,newDes,newSpeed,newRange,newStamina,newPrecision,newDevPot;
    HashMap<String,List<String>> list1;
    HashMap<String,List<String>> r;
    int num;
    List<String> Infinity = new ArrayList<>();
    List<String> A = new ArrayList<>();
    List<String> B= new ArrayList<>();
    List<String> C = new ArrayList<>();
    List<String> D = new ArrayList<>();
    List<String> E = new ArrayList<>();
    List<String> q = new ArrayList<>();
    List<String> nul = new ArrayList<>();
    
    
    public Residents(){
        
        Name = new ArrayList<>();
        Age = new ArrayList<>();
        Gender = new ArrayList<>();
        ResidentialArea = new ArrayList<>();
        Parents = new ArrayList<>();
        newName = new ArrayList<>();
        newAge = new ArrayList<>();
        newGender = new ArrayList<>();
        newParent = new ArrayList<>();
        newStand = new ArrayList<>();
        newDes = new ArrayList<>();
        newSpeed = new ArrayList<>();
        newRange = new ArrayList<>();
        newStamina = new ArrayList<>();
        newPrecision = new ArrayList<>();
        newDevPot = new ArrayList<>();
        list1 = new HashMap<>();
        r = new HashMap<>();
    }
    
   public void readRes(){
       
        try {
            
           
            Scanner scan = new Scanner(new FileReader("residents.csv"));
            
            String line ="";
            scan.nextLine();
            while(scan.hasNextLine()){
                
                line = scan.nextLine();
                String[] features = line.split(",");
                
                if(features.length==6){
                    Name.add(features[0]);
                    Age.add(features[1]);
                    Gender.add(features[2]);
                    ResidentialArea.add(features[3]);
                    features[4]= features[4]+"," +features[5];
                    Parents.add(features[4]);
                }
                else{
                    Name.add(features[0]);
                    Age.add(features[1]);
                    Gender.add(features[2]);
                    ResidentialArea.add(features[3]);
                    Parents.add(features[4]);
                    
                    
                }
                
                for(int i =0; i<Name.size(); i++){
                    list1.put(Name.get(i),new ArrayList(Arrays.asList(Age.get(i),Gender.get(i),ResidentialArea.get(i),Parents.get(i))));
                }
            }
            
            readStand();
            
        } catch (IOException e) {
           e.printStackTrace();
        }        
   } 
   
   public void readStand(){
       
        try {
            Scanner scan =new Scanner(new FileReader("stands.csv"));
            
            String line = "";
            while(scan.hasNextLine()){
                
                line = scan.nextLine();
                String[] features = line.split(",");
                String name = features[1];
                if(list1.containsKey(name)){
                    List<String> newFeature = list1.get(name);
                    newFeature.addAll(Arrays.asList(features[0],features[2],features[3],features[4],features[5],features[6],features[7]));
                }
                
            }  
            
        } catch (IOException e) {
            e.printStackTrace();
        }
   }
   
   public void option1(String place){
       
       Scanner scan = new Scanner(System.in);
       System.out.println("Current Location: "+place);
       System.out.println("[1] Move to: ");
       System.out.println("[2] View Resident Information");
       System.out.println("[3] Back (Savage Garden)");
       System.out.println("[4] Back to Town Hall");
       System.out.print("Select: ");
       int choose = scan.nextInt();
       System.out.println("==================================================================================================================");
       
       switch(choose){
            
            case 1:System.out.println("Choose the next location");
                   break;
            case 2:readRes();
                   printRes(place);
                   break;
            case 3:System.out.println("Move back to prevoius location");
                   break;
            case 4:System.out.println("Back to Town Hall");
                   break;
        }
   }
   
   public void printRes(String place){
        List<String> resident =new ArrayList<>();
        
        System.out.println("Resident Information in "+place);
        System.out.println("+-----+-----------------------+-----+---------+------------------------------------+-----------------------+-------------------+-----------+-----------+-----------+-------------+--------------------------+");
        System.out.println("|No   | Name                  | Age | Gender  |  Parents                           |  Stand                | Destructive Power |  Speed    |  Range    |  Stamina  | Precision   |  Development Potential   |");
        System.out.println("+-----+-----------------------+-----+---------+------------------------------------+-----------------------+-------------------+-----------+-----------+-----------+-------------+--------------------------+");
         int num =1;
        for (Map.Entry<String, List<String>> entry : list1.entrySet()) {
                 
            String key = entry.getKey();
            List<String> values = entry.getValue();
            if (values.contains(place)) {
               
                switch(values.size()){
                    
                    case 11:resident.addAll(Arrays.asList(key,values.get(0),values.get(1),values.get(3),values.get(4),values.get(5),values.get(6),values.get(7),values.get(8),values.get(9),values.get(10)));       
                            r.put(key, Arrays.asList(values.get(0),values.get(1),values.get(3),values.get(4),values.get(5),values.get(6),values.get(7),values.get(8),values.get(9),values.get(10)));
                            System.out.printf("| %-4s| %-22s| %-4s| %-8s| %-35s| %-22s|       %-12s| %-10s| %-10s| %-10s| %-12s| %-25s|\n",num,key,values.get(0),values.get(1),values.get(3),values.get(4),values.get(5),values.get(6),values.get(7),values.get(8),values.get(9),values.get(10));
                             break;
                             
                    case 4: String none = "N/A";
                            System.out.printf("| %-4s| %-22s| %-4s| %-8s| %-35s| %-22s|       %-12s| %-10s| %-10s| %-10s| %-12s| %-25s|\n",num,key,values.get(0),values.get(1),values.get(3),none,none,none,none,none,none,none);
                            resident.addAll(Arrays.asList(key,values.get(0),values.get(1),values.get(3),none,none,none,none,none,none,none));
                        r.put(key, Arrays.asList(values.get(0),values.get(1),values.get(3),none,none,none,none,none,none,none));
                            break;
                }
                
                num++;
               
        
            }
        }
       System.out.println("+-----+-----------------------+-----+---------+------------------------------------+-----------------------+-------------------+-----------+-----------+-----------+-------------+--------------------------+");
       switch(option2()){
           
           case 1:System.out.println("Go to Resident Profile");
                  break;
           case 2:System.out.println("{ NOTE: This sorting method only available for Stand User only!! }");
                  sort(place);
                  r.clear();
                  break;
           case 3:option1(place);
                 break;
           default: break;
           
                   
       }
   }
   
    public void sort(String place){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the sorting order (i.e Stamina) :");
        String order = sc.nextLine();
        System.out.print("ASC OR DESC :");
        String sortorder = sc.nextLine();
        int index = 0;
        
        
        switch(order){
            case "Destructive Power":
                index = 4;
                break;
            case "Speed":
                index = 5;
                break;
            case "Range":
                index = 6;
                break;
             case "Stamina":
                index = 7;
                break;   
             case "Precision":
                index = 8;
                break;  
             case "Development Potential":
                index = 9;
                break;  
             default:
                     System.out.println("Please re-enter the field ");
                     sort(place);
                     break;
                     
        }
        
        for (Map.Entry<String, List<String>> entry : r.entrySet()) {
                   String key = entry.getKey();
                   List<String> values = entry.getValue();
                   
                   switch(values.get(index)){
                       case "Infinity":                     
                           Infinity.add(key);
                           Infinity.addAll(values);
                           break;
                        case "A":                     
                           A.add(key);
                           A.addAll(values);
                           break;
                        case "B":
                           B.add(key);
                           B.addAll(values);
                           break;    
                        case "C":
                           C.add(key);
                           C.addAll(values);
                           break;
                        case "D":
                           D.add(key);
                           D.addAll(values);
                           break;
                        case "E":
                           E.add(key);
                           E.addAll(values);
                           break;    
                        case "?":
                           q.add(key);
                           q.addAll(values);
                           break;     
                        case "Null":
                           nul.add(key);
                           nul.addAll(values);
                           break;        
                }
      
        }
        
        
        switch(sortorder){
        
        case "DESC":System.out.println("+----+------------------------+-----+--------+--------------------------------------------+----------------------+-------------------+-----------+----------+-----------+-------------+-------------------------+");
                   System.out.println("|No  | Name                   | Age | Gender |  Parents                                   |  Stand               | Destructive Power |  Speed    |  Range   | Stamina   | Precision   | Development Potential   | ");
                   System.out.println("+----+------------------------+-----+--------+--------------------------------------------+----------------------+-------------------+-----------+----------+-----------+-------------+-------------------------+");           
        

        int count =1;
        
        if(!Infinity.isEmpty()){     
            int size = Infinity.size()/11;
            int j = 0;
            for(int i=0; i<size; i++){          
                System.out.printf("|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",count,Infinity.get(0+j),Infinity.get(1+j),Infinity.get(2+j),Infinity.get(3+j),Infinity.get(4+j),Infinity.get(5+j),Infinity.get(6+j),Infinity.get(7+j),Infinity.get(8+j),Infinity.get(9+j),Infinity.get(10+j));
                j = j +11;
                count++;
            }
     
        }  

        if(!A.isEmpty()){     
            int size = A.size()/11;
            int j = 0;
            for(int i=0; i<size; i++){          
                System.out.printf("|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",count,A.get(0+j),A.get(1+j),A.get(2+j),A.get(3+j),A.get(4+j),A.get(5+j),A.get(6+j),A.get(7+j),A.get(8+j),A.get(9+j),A.get(10+j));
                j = j +11;
                count++;
            }
     
        }  
         if(!B.isEmpty()){     
            int size = B.size()/11;
            int j = 0;
            for(int i=0; i<size; i++){          
                System.out.printf("|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",count,B.get(0+j),B.get(1+j),B.get(2+j),B.get(3+j),B.get(4+j),B.get(5+j),B.get(6+j),B.get(7+j),B.get(8+j),B.get(9+j),B.get(10+j));
                j = j +11;
                count++;
            }
   
        }  
         if(!C.isEmpty()){     
            int size = C.size()/11;
            int j = 0;
            for(int i=0; i<size; i++){          
                System.out.printf("|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",count,C.get(0+j),C.get(1+j),C.get(2+j),C.get(3+j),C.get(4+j),C.get(5+j),C.get(6+j),C.get(7+j),C.get(8+j),C.get(9+j),C.get(10+j));
                j = j +11;
                count++;
          
            }
        }  
          if(!D.isEmpty()){     
            int size = D.size()/11;
            int j = 0;
            for(int i=0; i<size; i++){          
                System.out.printf("|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",count,D.get(0+j),D.get(1+j),D.get(2+j),D.get(3+j),D.get(4+j),D.get(5+j),D.get(6+j),D.get(7+j),D.get(8+j),D.get(9+j),D.get(10+j));
                j = j +11;
                count++;
            }
       
        }  
           if(!E.isEmpty()){     
            int size = E.size()/11;
            int j = 0;
            for(int i=0; i<size; i++){          
                System.out.printf("|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",count,E.get(0+j),E.get(1+j),E.get(2+j),E.get(3+j),E.get(4+j),E.get(5+j),E.get(6+j),E.get(7+j),E.get(8+j),E.get(9+j),E.get(10+j));
                j = j +11;
                count++;     
            }
  
        }  
           if(!q.isEmpty()){     
            int size = q.size()/11;
            int j = 0;
            for(int i=0; i<size; i++){          
                System.out.printf("|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",count,q.get(0+j),q.get(1+j),q.get(2+j),q.get(3+j),q.get(4+j),q.get(5+j),q.get(6+j),q.get(7+j),q.get(8+j),q.get(9+j),q.get(10+j));
                j = j +11;
                count++;  
            }
     
        }  
           if(!nul.isEmpty()){     
            int size = nul.size()/11;
            int j = 0;
            for(int i=0; i<size; i++){          
                System.out.printf("|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",count,nul.get(0+j),nul.get(1+j),nul.get(2+j),nul.get(3+j),nul.get(4+j),nul.get(5+j),nul.get(6+j),nul.get(7+j),nul.get(8+j),nul.get(9+j),nul.get(10+j));
                j = j +11;
                count++;  
            }
         
        }   
         break;   
        
        case "ASC":System.out.println("+----+------------------------+-----+--------+--------------------------------------------+----------------------+-------------------+-----------+----------+-----------+-------------+-------------------------+");
                    System.out.println("|No  | Name                   | Age | Gender |  Parents                                   |  Stand               | Destructive Power |  Speed    |  Range   | Stamina   | Precision   | Development Potential   | ");
                    System.out.println("+----+------------------------+-----+--------+--------------------------------------------+----------------------+-------------------+-----------+----------+-----------+-------------+-------------------------+");           
        
            int c =1;

        if(!nul.isEmpty()){     
            int size = nul.size()/11;
            int j = 0;
            for(int i=0; i<size; i++){          
                System.out.printf("|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",c,nul.get(0+j),nul.get(1+j),nul.get(2+j),nul.get(3+j),nul.get(4+j),nul.get(5+j),nul.get(6+j),nul.get(7+j),nul.get(8+j),nul.get(9+j),nul.get(10+j));
                j = j +11;
                c++;
            }
        
        }  
         if(!q.isEmpty()){     
            int size = q.size()/11;
            int j = 0;
            for(int i=0; i<size; i++){          
                System.out.printf("|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",c,q.get(0+j),q.get(1+j),q.get(2+j),q.get(3+j),q.get(4+j),q.get(5+j),q.get(6+j),q.get(7+j),q.get(8+j),q.get(9+j),q.get(10+j));
                j = j +11;
                c++;
            }
     
        }  
         if(!E.isEmpty()){     
            int size = E.size()/11;
            int j = 0;
            for(int i=0; i<size; i++){          
                System.out.printf("|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",c,E.get(0+j),E.get(1+j),E.get(2+j),E.get(3+j),E.get(4+j),E.get(5+j),E.get(6+j),E.get(7+j),E.get(8+j),E.get(9+j),E.get(10+j));
                j = j +11;
                c++;
           
            }
  
        }  
          if(!D.isEmpty()){     
            int size = D.size()/11;
            int j = 0;
            for(int i=0; i<size; i++){          
                System.out.printf("|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",c,D.get(0+j),D.get(1+j),D.get(2+j),D.get(3+j),D.get(4+j),D.get(5+j),D.get(6+j),D.get(7+j),D.get(8+j),D.get(9+j),D.get(10+j));
                j = j +11;
                c++;
            }
      
        }  
           if(!C.isEmpty()){     
            int size = C.size()/11;
            int j = 0;
            for(int i=0; i<size; i++){          
                System.out.printf("|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",c,C.get(0+j),C.get(1+j),C.get(2+j),C.get(3+j),C.get(4+j),C.get(5+j),C.get(6+j),C.get(7+j),C.get(8+j),C.get(9+j),C.get(10+j));
                j = j +11;
                c++;     
            }
      
        }  
           if(!B.isEmpty()){     
            int size = B.size()/11;
            int j = 0;
            for(int i=0; i<size; i++){          
                System.out.printf("|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",c,B.get(0+j),B.get(1+j),B.get(2+j),B.get(3+j),B.get(4+j),B.get(5+j),B.get(6+j),B.get(7+j),B.get(8+j),B.get(9+j),B.get(10+j));
                j = j +11;
                c++;  
            }

        }  
           if(!A.isEmpty()){     
            int size = A.size()/11;
            int j = 0;
            for(int i=0; i<size; i++){          
                System.out.printf("|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",c,A.get(0+j),A.get(1+j),A.get(2+j),A.get(3+j),A.get(4+j),A.get(5+j),A.get(6+j),A.get(7+j),A.get(8+j),A.get(9+j),A.get(10+j));
                j = j +11;
                c++;  
            }
  
        }  
           
             if(!Infinity.isEmpty()){     
            int size = Infinity.size()/11;
            int j = 0;
            for(int i=0; i<size; i++){          
                System.out.printf("|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",c,Infinity.get(0+j),Infinity.get(1+j),Infinity.get(2+j),Infinity.get(3+j),Infinity.get(4+j),Infinity.get(5+j),Infinity.get(6+j),Infinity.get(7+j),Infinity.get(8+j),Infinity.get(9+j),Infinity.get(10+j));
                j = j +11;
                c++;
            }
 
        }    
         break;   
         
         default:System.out.println("Your enter the wrong format");
                 System.out.println("Please re-enter the feature ");
                 sort(place);
                 break;
    }
                System.out.println("+----+------------------------+-----+--------+--------------------------------------------+----------------------+-------------------+-----------+----------+-----------+-------------+-------------------------+");           
        Infinity.clear();
                A.clear();
                B.clear();
                C.clear();
                D.clear();
                E.clear();
                q.clear();
                nul.clear();
        r.clear(); 
        list1.clear();
        option1(place);
    }
    
    
       
   
   
   public int option2(){
       
       Scanner scan = new Scanner(System.in);
       
       System.out.println("[1] View Resident's Profile");
       System.out.println("[2] Sort");
       System.out.println("[3] Exit");
       System.out.print("Select: ");
       int choose = scan.nextInt();
       System.out.println("==================================================================================================================");
       return choose;
   }
   
   
   
   
      
 
  
}