/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//package feature2_sal;

/**
 *
 * @author USER
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.regex.*;
public class Feature2_Sal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //Polnareff Land, Morioh Grand Hotel, San Giorgio Maggiore, Joestar Mansion, Vineyard, DIO's Mansion, Angelo Rock
        String input = "Polnareff Land";
        
        information(input);
        option();
        
        System.out.print("Select: ");
        int select = scan.nextInt();
        
        switch(select){
            
            //Stamina (ASC); Precision (DESC); Stand (ASC);
            case 1: System.out.println("");
                    break;
                    
            case 2: sort(input);
                            break;
                    
            case 3: System.out.println("exit");
                    break;
                    
        }
      
        
    }
    
    public static void information(String input){
    
                                       
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> age = new ArrayList<>();
        ArrayList<String> gender = new ArrayList<>();
        ArrayList<String> residential = new ArrayList<>();
        ArrayList<String> parent = new ArrayList<>();
        ArrayList<String> stand = new ArrayList<>();
        ArrayList<String> standuser = new ArrayList<>();
        ArrayList<String> destructive = new ArrayList<>();
        ArrayList<String> speed = new ArrayList<>();
        ArrayList<String> range = new ArrayList<>();
        ArrayList<String> stamina = new ArrayList<>();
        ArrayList<String> precision = new ArrayList<>();
        ArrayList<String> devPot = new ArrayList<>();
    
        
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
                                            name.add(resident[0]);
                                            age.add(resident[1]);
                                            gender.add(resident[2]);
                                            residential.add(resident[3]);
                                            if(resident[4].equals("N/A")){
                                                parent.add(resident[4]);
                                            }
                                            else if(x==6){
                                                    
                                                String parents = resident[4] +" & "+resident[5];
                                                    parent.add(parents);
                                                    
                                                    }
                                            else{
                                                parent.add(resident[4]);
                                                
                                            }   
                                        }
                                        
                                         String head2 = scan2.nextLine();
                                        while(scan2.hasNextLine()){
                                        String standline = scan2.nextLine();
                                            list2.add(standline);
                                        }
                                        
                                        for(int index=0; index<list2.size(); index++){
                                            String[] standlist = list2.get(index).split(",");
                                            stand.add(standlist[0]);
                                            standuser.add(standlist[1]);
                                            destructive.add(standlist[2]);
                                            speed.add(standlist[3]);
                                            range.add(standlist[4]);
                                            stamina.add(standlist[5]);
                                            precision.add(standlist[6]);
                                            devPot.add(standlist[7]);
                                        }
                                        
                                        for(int index1=0; index1<list1.size(); index1++){
                                            for(int index2=0; index2<list2.size(); index2++){
                                                
                                                
                                                if(name.get(index1).equals(standuser.get(index2))){
                                                    
                                                      System.out.printf("|%-4s| %-29s| %-4s| %-7s| %-20s| %-20s| %-9s| %-9s| %-11s| %-11s| %-18s|",(index1+1),name.get(index1),age.get(index1),gender.get(index1),stand.get(index2),destructive.get(index2),speed.get(index2),range.get(index2),stamina.get(index2),precision.get(index2),devPot.get(index2));
                                                      System.out.println();
                                                    //System.out.print("|"+index1+" | "+)+"              | "+ age.get(index1)+" | "+gender.get(index1)+" | "+stand.get(index2)+" | "+destructive.get(index2)+" |           | "+ speed.get(index2)+" |   "+ range.get(index2)+" |          "+ stamina.get(index2)+"|         "+ precision.get(index2)+" |    "+ devPot.get(index2));
                                                }
                                                
                                            }
                                        }
                                        
                                        System.out.println("+----+------------------------------+-----+--------+---------------------+---------------------+----------+----------+------------+------------+-------------------+");
                                        
                                        
                                        
                                            
            
                                        } catch (FileNotFoundException ex) {
                                        System.out.println("ldsnjskfn");
            
            
                                       }
         }
                                       
                                       
           public static void option(){
               
               System.out.println("[1] View Resident's Profile");
               System.out.println("[2] Sort");
               System.out.println("[3] Exit");
               
           }
           
           //Stamina (ASC); Precision (DESC); Stand (ASC)
           public static void sort(String input){
            
        Scanner scan = new Scanner(System.in);       
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> age = new ArrayList<>();
        ArrayList<String> gender = new ArrayList<>();
        ArrayList<String> residential = new ArrayList<>();
        ArrayList<String> parent = new ArrayList<>();
        ArrayList<String> stand = new ArrayList<>();
        ArrayList<String> standuser = new ArrayList<>();
        ArrayList<String> destructive = new ArrayList<>();
        ArrayList<String> speed = new ArrayList<>();
        ArrayList<String> range = new ArrayList<>();
        ArrayList<String> stamina = new ArrayList<>();
        ArrayList<String> precision = new ArrayList<>();
        ArrayList<String> devPot = new ArrayList<>();
        ArrayList<String> title = new ArrayList<>();
        ArrayList<String> preced = new ArrayList<>();
        
        
        
                                      
                                      System.out.println("Enter the sorting order: ");
                                      scan.nextLine();
                                      String order = scan.nextLine();
                                      String[] features = order.split(" ");
                                      
                                      
                                      for(int index=0; index<features.length; index++){
                                          title.add(features[index]);
                                          preced.add(features[index]);
                                          
                                      }
                                      System.out.println("osfh");
                                      System.out.println(title.get(0));
                                      System.out.println(preced.get(0));
    
        
                                       try {
                                        // TODO code application logic here
                                        
                                        Scanner scan1 = new Scanner(new FileReader("residents.csv"));
                                        Scanner scan2 = new Scanner(new FileReader("stands.csv"));
                                       
                                      
            
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
                                            name.add(resident[0]);
                                            age.add(resident[1]);
                                            gender.add(resident[2]);
                                            residential.add(resident[3]);
                                            if(resident[4].equals("N/A")){
                                                parent.add(resident[4]);
                                            }
                                            else if(x==6){
                                                    
                                                String parents = resident[4] +" & "+resident[5];
                                                    parent.add(parents);
                                                    
                                                    }
                                            else{
                                                parent.add(resident[4]);
                                                
                                            }   
                                        }
                                        
                                         String head2 = scan2.nextLine();
                                        while(scan2.hasNextLine()){
                                        String standline = scan2.nextLine();
                                            list2.add(standline);
                                        }
                                        
                                        for(int index=0; index<list2.size(); index++){
                                            String[] standlist = list2.get(index).split(",");
                                            stand.add(standlist[0]);
                                            standuser.add(standlist[1]);
                                            destructive.add(standlist[2]);
                                            speed.add(standlist[3]);
                                            range.add(standlist[4]);
                                            stamina.add(standlist[5]);
                                            precision.add(standlist[6]);
                                            devPot.add(standlist[7]);
                                        }
                                        
                                        for(int index1=0; index1<list1.size(); index1++){
                                            for(int index2=0; index2<list2.size(); index2++){
                                                
                                                
                                                if(name.get(index1).equals(standuser.get(index2))){
                                                    
                                                      System.out.printf("|%-4s| %-29s| %-4s| %-7s| %-20s| %-20s| %-9s| %-9s| %-11s| %-11s| %-18s|",(index1+1),name.get(index1),age.get(index1),gender.get(index1),stand.get(index2),destructive.get(index2),speed.get(index2),range.get(index2),stamina.get(index2),precision.get(index2),devPot.get(index2));
                                                      System.out.println();
                                                    //System.out.print("|"+index1+" | "+)+"              | "+ age.get(index1)+" | "+gender.get(index1)+" | "+stand.get(index2)+" | "+destructive.get(index2)+" |           | "+ speed.get(index2)+" |   "+ range.get(index2)+" |          "+ stamina.get(index2)+"|         "+ precision.get(index2)+" |    "+ devPot.get(index2));
                                                }
                                                
                                            }
                                        }
                                        
                                        System.out.println("+----+------------------------------+-----+--------+---------------------+---------------------+----------+----------+------------+------------+-------------------+");
                                        
                                        
                                        
                                            
            
                                        } catch (FileNotFoundException ex) {
                                        System.out.println("ldsnjskfn");
            
            
                                       }
           }
        
    }
