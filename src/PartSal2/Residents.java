
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PartSal2;

/**
 *
 * @author USER
 */
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Restaurants.Customer;
import Restaurants.Food;
import Restaurants.Restaurant;
import defaultmap.Defaultmap;

public class Residents {
    ArrayList<String> Name, Age, Gender, ResidentialArea, Parents, newName, newAge, newGender, newParent, newStand,
            newDes, newSpeed, newRange, newStamina, newPrecision, newDevPot;
    public static HashMap<String, List<String>> list1;
    public HashMap<String, List<String>> r;
    int num;
    List<String> Infinity = new ArrayList<>();
    List<String> A = new ArrayList<>();
    List<String> B = new ArrayList<>();
    List<String> C = new ArrayList<>();
    List<String> D = new ArrayList<>();
    List<String> E = new ArrayList<>();
    List<String> q = new ArrayList<>();
    List<String> nul = new ArrayList<>();

    public Residents() {

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

    public void readRes() {

        try {

            Scanner scan = new Scanner(new FileReader("residents.csv"));

            String line = "";
            scan.nextLine();
            while (scan.hasNextLine()) {

                line = scan.nextLine();
                String[] features = line.split(",");

                if (features.length == 6) {
                    Name.add(features[0]);
                    Age.add(features[1]);
                    Gender.add(features[2]);
                    ResidentialArea.add(features[3]);
                    features[4] = features[4] + "," + features[5];
                    Parents.add(features[4]);
                } else {
                    Name.add(features[0]);
                    Age.add(features[1]);
                    Gender.add(features[2]);
                    ResidentialArea.add(features[3]);
                    Parents.add(features[4]);

                }

                for (int i = 0; i < Name.size(); i++) {
                    list1.put(Name.get(i), new ArrayList(
                            Arrays.asList(Age.get(i), Gender.get(i), ResidentialArea.get(i), Parents.get(i))));
                }
            }

            readStand();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readStand() {

        try {
            Scanner scan = new Scanner(new FileReader("stands.csv"));

            String line = "";
            while (scan.hasNextLine()) {

                line = scan.nextLine();
                String[] features = line.split(",");
                String name = features[1];
                if (list1.containsKey(name)) {
                    List<String> newFeature = list1.get(name);
                    newFeature.addAll(Arrays.asList(features[0], features[2], features[3], features[4], features[5],
                            features[6], features[7]));
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printRes(String place) {
        List<String> resident = new ArrayList<>();

        System.out.println("Resident Information in " + place);
        System.out.println(
                "+-----+-----------------------+-----+---------+------------------------------------+-----------------------+-------------------+-----------+-----------+-----------+-------------+--------------------------+");
        System.out.println(
                "|No   | Name                  | Age | Gender  |  Parents                           |  Stand                | Destructive Power |  Speed    |  Range    |  Stamina  | Precision   |  Development Potential   |");
        System.out.println(
                "+-----+-----------------------+-----+---------+------------------------------------+-----------------------+-------------------+-----------+-----------+-----------+-------------+--------------------------+");
        int num = 1;
        for (Map.Entry<String, List<String>> entry : list1.entrySet()) {

            String key = entry.getKey();
            List<String> values = entry.getValue();
            if (values.contains(place)) {

                switch (values.size()) {

                    case 11:
                        resident.addAll(Arrays.asList(key, values.get(0), values.get(1), values.get(3), values.get(4),
                                values.get(5), values.get(6), values.get(7), values.get(8), values.get(9),
                                values.get(10)));
                        r.put(key,
                                Arrays.asList(values.get(0), values.get(1), values.get(3), values.get(4), values.get(5),
                                        values.get(6), values.get(7), values.get(8), values.get(9), values.get(10)));
                        System.out.printf(
                                "| %-4s| %-22s| %-4s| %-8s| %-35s| %-22s|       %-12s| %-10s| %-10s| %-10s| %-12s| %-25s|\n",
                                num, key, values.get(0), values.get(1), values.get(3), values.get(4), values.get(5),
                                values.get(6), values.get(7), values.get(8), values.get(9), values.get(10));
                        break;

                    case 4:
                        String none = "N/A";
                        System.out.printf(
                                "| %-4s| %-22s| %-4s| %-8s| %-35s| %-22s|       %-12s| %-10s| %-10s| %-10s| %-12s| %-25s|\n",
                                num, key, values.get(0), values.get(1), values.get(3), none, none, none, none, none,
                                none, none);
                        resident.addAll(Arrays.asList(key, values.get(0), values.get(1), values.get(3), none, none,
                                none, none, none, none, none));
                        r.put(key, Arrays.asList(values.get(0), values.get(1), values.get(3), none, none, none, none,
                                none, none, none));
                        break;
                }

                num++;

            }
        }
        System.out.println(
                "+-----+-----------------------+-----+---------+------------------------------------+-----------------------+-------------------+-----------+-----------+-----------+-------------+--------------------------+");

        option2(place, Defaultmap.currentDay);
    }

    public void sort(String place) {

        Scanner sc = new Scanner(System.in);
        String order = "";
        String[] basedOrder = {"Destructive Power","Speed","Range","Stamina","Precision","Development Potential"};
        boolean check=false;
        while(check==false){
            System.out.print("Enter the sorting order (i.e Stamina) :");
            order = sc.nextLine();
            for(int index=0; index<basedOrder.length; index++){
                if(order.equals(basedOrder[index])){
                    check = true;
                }
            }
        }
        
        String sortorder = "";
        String[] basedSortOrder = {"ASC","DESC"};
        boolean check2=false;
        while(check2==false){
            System.out.print("ASC OR DESC :");
            sortorder = sc.nextLine();
            for(int index=0; index<basedSortOrder.length; index++){
                if(sortorder.equals(basedSortOrder[index])){
                    check2 = true;
                }
            }
        }
        int index = 0;

        switch (order) {
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

            switch (values.get(index)) {
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

        switch (sortorder) {

            case "ASC":
                System.out.println(
                        "+----+------------------------+-----+--------+--------------------------------------------+----------------------+-------------------+-----------+----------+-----------+-------------+-------------------------+");
                System.out.println(
                        "|No  | Name                   | Age | Gender |  Parents                                   |  Stand               | Destructive Power |  Speed    |  Range   | Stamina   | Precision   | Development Potential   | ");
                System.out.println(
                        "+----+------------------------+-----+--------+--------------------------------------------+----------------------+-------------------+-----------+----------+-----------+-------------+-------------------------+");

                int count = 1;

                if (!Infinity.isEmpty()) {
                    int size = Infinity.size() / 11;
                    int j = 0;
                    for (int i = 0; i < size; i++) {
                        System.out.printf(
                                "|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",
                                count, Infinity.get(0 + j), Infinity.get(1 + j), Infinity.get(2 + j),
                                Infinity.get(3 + j), Infinity.get(4 + j), Infinity.get(5 + j), Infinity.get(6 + j),
                                Infinity.get(7 + j), Infinity.get(8 + j), Infinity.get(9 + j), Infinity.get(10 + j));
                        j = j + 11;
                        count++;
                    }

                }

                if (!A.isEmpty()) {
                    int size = A.size() / 11;
                    int j = 0;
                    for (int i = 0; i < size; i++) {
                        System.out.printf(
                                "|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",
                                count, A.get(0 + j), A.get(1 + j), A.get(2 + j), A.get(3 + j), A.get(4 + j),
                                A.get(5 + j), A.get(6 + j), A.get(7 + j), A.get(8 + j), A.get(9 + j), A.get(10 + j));
                        j = j + 11;
                        count++;
                    }

                }
                if (!B.isEmpty()) {
                    int size = B.size() / 11;
                    int j = 0;
                    for (int i = 0; i < size; i++) {
                        System.out.printf(
                                "|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",
                                count, B.get(0 + j), B.get(1 + j), B.get(2 + j), B.get(3 + j), B.get(4 + j),
                                B.get(5 + j), B.get(6 + j), B.get(7 + j), B.get(8 + j), B.get(9 + j), B.get(10 + j));
                        j = j + 11;
                        count++;
                    }

                }
                if (!C.isEmpty()) {
                    int size = C.size() / 11;
                    int j = 0;
                    for (int i = 0; i < size; i++) {
                        System.out.printf(
                                "|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",
                                count, C.get(0 + j), C.get(1 + j), C.get(2 + j), C.get(3 + j), C.get(4 + j),
                                C.get(5 + j), C.get(6 + j), C.get(7 + j), C.get(8 + j), C.get(9 + j), C.get(10 + j));
                        j = j + 11;
                        count++;

                    }
                }
                if (!D.isEmpty()) {
                    int size = D.size() / 11;
                    int j = 0;
                    for (int i = 0; i < size; i++) {
                        System.out.printf(
                                "|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",
                                count, D.get(0 + j), D.get(1 + j), D.get(2 + j), D.get(3 + j), D.get(4 + j),
                                D.get(5 + j), D.get(6 + j), D.get(7 + j), D.get(8 + j), D.get(9 + j), D.get(10 + j));
                        j = j + 11;
                        count++;
                    }

                }
                if (!E.isEmpty()) {
                    int size = E.size() / 11;
                    int j = 0;
                    for (int i = 0; i < size; i++) {
                        System.out.printf(
                                "|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",
                                count, E.get(0 + j), E.get(1 + j), E.get(2 + j), E.get(3 + j), E.get(4 + j),
                                E.get(5 + j), E.get(6 + j), E.get(7 + j), E.get(8 + j), E.get(9 + j), E.get(10 + j));
                        j = j + 11;
                        count++;
                    }

                }
                if (!q.isEmpty()) {
                    int size = q.size() / 11;
                    int j = 0;
                    for (int i = 0; i < size; i++) {
                        System.out.printf(
                                "|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",
                                count, q.get(0 + j), q.get(1 + j), q.get(2 + j), q.get(3 + j), q.get(4 + j),
                                q.get(5 + j), q.get(6 + j), q.get(7 + j), q.get(8 + j), q.get(9 + j), q.get(10 + j));
                        j = j + 11;
                        count++;
                    }

                }
                if (!nul.isEmpty()) {
                    int size = nul.size() / 11;
                    int j = 0;
                    for (int i = 0; i < size; i++) {
                        System.out.printf(
                                "|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",
                                count, nul.get(0 + j), nul.get(1 + j), nul.get(2 + j), nul.get(3 + j), nul.get(4 + j),
                                nul.get(5 + j), nul.get(6 + j), nul.get(7 + j), nul.get(8 + j), nul.get(9 + j),
                                nul.get(10 + j));
                        j = j + 11;
                        count++;
                    }

                }
                break;

            case "DESC":
                System.out.println(
                        "+----+------------------------+-----+--------+--------------------------------------------+----------------------+-------------------+-----------+----------+-----------+-------------+-------------------------+");
                System.out.println(
                        "|No  | Name                   | Age | Gender |  Parents                                   |  Stand               | Destructive Power |  Speed    |  Range   | Stamina   | Precision   | Development Potential   | ");
                System.out.println(
                        "+----+------------------------+-----+--------+--------------------------------------------+----------------------+-------------------+-----------+----------+-----------+-------------+-------------------------+");

                int c = 1;

                if (!nul.isEmpty()) {
                    int size = nul.size() / 11;
                    int j = 0;
                    for (int i = 0; i < size; i++) {
                        System.out.printf(
                                "|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",
                                c, nul.get(0 + j), nul.get(1 + j), nul.get(2 + j), nul.get(3 + j), nul.get(4 + j),
                                nul.get(5 + j), nul.get(6 + j), nul.get(7 + j), nul.get(8 + j), nul.get(9 + j),
                                nul.get(10 + j));
                        j = j + 11;
                        c++;
                    }

                }
                if (!q.isEmpty()) {
                    int size = q.size() / 11;
                    int j = 0;
                    for (int i = 0; i < size; i++) {
                        System.out.printf(
                                "|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",
                                c, q.get(0 + j), q.get(1 + j), q.get(2 + j), q.get(3 + j), q.get(4 + j), q.get(5 + j),
                                q.get(6 + j), q.get(7 + j), q.get(8 + j), q.get(9 + j), q.get(10 + j));
                        j = j + 11;
                        c++;
                    }

                }
                if (!E.isEmpty()) {
                    int size = E.size() / 11;
                    int j = 0;
                    for (int i = 0; i < size; i++) {
                        System.out.printf(
                                "|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",
                                c, E.get(0 + j), E.get(1 + j), E.get(2 + j), E.get(3 + j), E.get(4 + j), E.get(5 + j),
                                E.get(6 + j), E.get(7 + j), E.get(8 + j), E.get(9 + j), E.get(10 + j));
                        j = j + 11;
                        c++;

                    }

                }
                if (!D.isEmpty()) {
                    int size = D.size() / 11;
                    int j = 0;
                    for (int i = 0; i < size; i++) {
                        System.out.printf(
                                "|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",
                                c, D.get(0 + j), D.get(1 + j), D.get(2 + j), D.get(3 + j), D.get(4 + j), D.get(5 + j),
                                D.get(6 + j), D.get(7 + j), D.get(8 + j), D.get(9 + j), D.get(10 + j));
                        j = j + 11;
                        c++;
                    }

                }
                if (!C.isEmpty()) {
                    int size = C.size() / 11;
                    int j = 0;
                    for (int i = 0; i < size; i++) {
                        System.out.printf(
                                "|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",
                                c, C.get(0 + j), C.get(1 + j), C.get(2 + j), C.get(3 + j), C.get(4 + j), C.get(5 + j),
                                C.get(6 + j), C.get(7 + j), C.get(8 + j), C.get(9 + j), C.get(10 + j));
                        j = j + 11;
                        c++;
                    }

                }
                if (!B.isEmpty()) {
                    int size = B.size() / 11;
                    int j = 0;
                    for (int i = 0; i < size; i++) {
                        System.out.printf(
                                "|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",
                                c, B.get(0 + j), B.get(1 + j), B.get(2 + j), B.get(3 + j), B.get(4 + j), B.get(5 + j),
                                B.get(6 + j), B.get(7 + j), B.get(8 + j), B.get(9 + j), B.get(10 + j));
                        j = j + 11;
                        c++;
                    }

                }
                if (!A.isEmpty()) {
                    int size = A.size() / 11;
                    int j = 0;
                    for (int i = 0; i < size; i++) {
                        System.out.printf(
                                "|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",
                                c, A.get(0 + j), A.get(1 + j), A.get(2 + j), A.get(3 + j), A.get(4 + j), A.get(5 + j),
                                A.get(6 + j), A.get(7 + j), A.get(8 + j), A.get(9 + j), A.get(10 + j));
                        j = j + 11;
                        c++;
                    }

                }

                if (!Infinity.isEmpty()) {
                    int size = Infinity.size() / 11;
                    int j = 0;
                    for (int i = 0; i < size; i++) {
                        System.out.printf(
                                "|%-4s| %-23s| %-4s|%-8s|%-44s|%-22s|     %-14s|   %-8s|  %-8s|   %-8s|    %-9s|         %-16s|\n",
                                c, Infinity.get(0 + j), Infinity.get(1 + j), Infinity.get(2 + j), Infinity.get(3 + j),
                                Infinity.get(4 + j), Infinity.get(5 + j), Infinity.get(6 + j), Infinity.get(7 + j),
                                Infinity.get(8 + j), Infinity.get(9 + j), Infinity.get(10 + j));
                        j = j + 11;
                        c++;
                    }

                }
                break;

        }
        System.out.println(
                "+----+------------------------+-----+--------+--------------------------------------------+----------------------+-------------------+-----------+----------+-----------+-------------+-------------------------+");
        Infinity.clear();
        A.clear();
        B.clear();
        C.clear();
        D.clear();
        E.clear();
        q.clear();
        nul.clear();
        list1.clear();
        option2(place, Defaultmap.currentDay);
    }

    public void option2(String place, int currentDay) {

        Scanner scan = new Scanner(System.in);

        System.out.println("[1] View Resident's Profile");
        System.out.println("[2] Sort");
        System.out.println("[3] Exit");
        System.out.print("Select: ");
        int choose = scan.nextInt();
        while (choose != 1 && choose != 2 && choose != 3) {
            System.out.println("Invalid input. Please try again.");
            System.out.print("Select: ");
            choose = scan.nextInt();
        }

        switch (choose) {

            case 1:
                System.out.print("Enter the resident's name: ");
                scan.nextLine();
                String profile = scan.nextLine();
                while(!Name.contains(profile)){
                    System.out.print("Enter the resident's name: ");
                    profile = scan.nextLine();
                }
                System.out.println(
                        "==============================================================================================================================================================");
                resProfile(profile, place, currentDay);
                break;
            case 2:
                System.out.println(
                        "==============================================================================================================================================================");
                System.out.println("{ NOTE: This sorting method only available for Stand User only!! }");
                sort(place);
                break;
            case 3:
                r.clear();
                break;
            default:
                System.out.println("Invalid input.");
                return;
        }
    }

    public void resProfile(String profile, String place, int currentDay) {

        System.out.println(profile + "'s Profile");

        for (Map.Entry<String, List<String>> entry : list1.entrySet()) {

            String key = entry.getKey();
            List<String> values = entry.getValue();

            if (key.equals(profile)) {
                if (values.size() == 11) {

                    System.out.println("Name: " + key);
                    System.out.println("Age: " + values.get(0));
                    System.out.println("Gender: " + values.get(1));
                    System.out.println("Parents: " + values.get(2));
                    System.out.println("Stand: " + values.get(4));
                    System.out.println("Destructive: " + values.get(5));
                    System.out.println("Speed: " + values.get(6));
                    System.out.println("Range: " + values.get(7));
                    System.out.println("Stamina: " + values.get(8));
                    System.out.println("Precision: " + values.get(9));
                    System.out.println("Development Pontential: " + values.get(10));

                }
                if (values.size() == 4) {
                    String none = "N/A";
                    System.out.println("Name: " + key);
                    System.out.println("Age: " + values.get(0));
                    System.out.println("Gender: " + values.get(1));
                    System.out.println("Parents: " + values.get(2));
                    System.out.println("Stand: " + none);
                    System.out.println("Destructive: " + none);
                    System.out.println("Speed: " + none);
                    System.out.println("Range: " + none);
                    System.out.println("Stamina: " + none);
                    System.out.println("Precision: " + none);
                    System.out.println("Development Pontential: " + none);
                }

            }
        }

        showResEat(profile, currentDay);

    }

    public void showResEat(String resName, int currentDay) {
        // orderHist(currentDay);
        System.out.println("Order History");
        System.out.println(
                "+-----+----------------------------------------------+----------------+---------------------------------+");
        System.out.println(
                "+ Day |        Food                                  |   Price        |      Restaurant                 |");
        System.out.println(
                "+-----+----------------------------------------------+----------------+---------------------------------+");
        if (!Customer.getCustomerbyName(resName).orderHistory.isEmpty()) {
            List<Food> foodList = Customer.getCustomerbyName(resName).orderHistory;
            for (int i = 0; i < foodList.size(); i++) {
                System.out.printf("| %-4s| %-45s| %-15s| %-32s| \n", i + 1, foodList.get(i).getFoodName(),
                        foodList.get(i).getFoodPrice(),
                        Restaurant.getRestNameByFood(foodList.get(i)));
            }
        }

        System.out.println(
                "+-----+----------------------------------------------+----------------+---------------------------------+");

    }

    public ArrayList<String> getName() {
        return Name;
    }

    public void setName(ArrayList<String> name) {
        Name = name;
    }

    public ArrayList<String> getAge() {
        return Age;
    }

    public void setAge(ArrayList<String> age) {
        Age = age;
    }

    public ArrayList<String> getGender() {
        return Gender;
    }

    public void setGender(ArrayList<String> gender) {
        Gender = gender;
    }

    public ArrayList<String> getResidentialArea() {
        return ResidentialArea;
    }

    public void setResidentialArea(ArrayList<String> residentialArea) {
        ResidentialArea = residentialArea;
    }

    public ArrayList<String> getParents() {
        return Parents;
    }

    public void setParents(ArrayList<String> parents) {
        Parents = parents;
    }

    public ArrayList<String> getNewName() {
        return newName;
    }

    public void setNewName(ArrayList<String> newName) {
        this.newName = newName;
    }

    public ArrayList<String> getNewAge() {
        return newAge;
    }

    public void setNewAge(ArrayList<String> newAge) {
        this.newAge = newAge;
    }

    public ArrayList<String> getNewGender() {
        return newGender;
    }

    public void setNewGender(ArrayList<String> newGender) {
        this.newGender = newGender;
    }

    public ArrayList<String> getNewParent() {
        return newParent;
    }

    public void setNewParent(ArrayList<String> newParent) {
        this.newParent = newParent;
    }

    public ArrayList<String> getNewStand() {
        return newStand;
    }

    public void setNewStand(ArrayList<String> newStand) {
        this.newStand = newStand;
    }

    public ArrayList<String> getNewDes() {
        return newDes;
    }

    public void setNewDes(ArrayList<String> newDes) {
        this.newDes = newDes;
    }

    public ArrayList<String> getNewSpeed() {
        return newSpeed;
    }

    public void setNewSpeed(ArrayList<String> newSpeed) {
        this.newSpeed = newSpeed;
    }

    public ArrayList<String> getNewRange() {
        return newRange;
    }

    public void setNewRange(ArrayList<String> newRange) {
        this.newRange = newRange;
    }

    public ArrayList<String> getNewStamina() {
        return newStamina;
    }

    public void setNewStamina(ArrayList<String> newStamina) {
        this.newStamina = newStamina;
    }

    public ArrayList<String> getNewPrecision() {
        return newPrecision;
    }

    public void setNewPrecision(ArrayList<String> newPrecision) {
        this.newPrecision = newPrecision;
    }

    public ArrayList<String> getNewDevPot() {
        return newDevPot;
    }

    public void setNewDevPot(ArrayList<String> newDevPot) {
        this.newDevPot = newDevPot;
    }

    public static HashMap<String, List<String>> getList1() {
        return list1;
    }

    public static void setList1(HashMap<String, List<String>> list1) {
        Residents.list1 = list1;
    }

    public HashMap<String, List<String>> getR() {
        return r;
    }

    public void setR(HashMap<String, List<String>> r) {
        this.r = r;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<String> getInfinity() {
        return Infinity;
    }

    public void setInfinity(List<String> infinity) {
        Infinity = infinity;
    }

    public List<String> getA() {
        return A;
    }

    public void setA(List<String> a) {
        A = a;
    }

    public List<String> getB() {
        return B;
    }

    public void setB(List<String> b) {
        B = b;
    }

    public List<String> getC() {
        return C;
    }

    public void setC(List<String> c) {
        C = c;
    }

    public List<String> getD() {
        return D;
    }

    public void setD(List<String> d) {
        D = d;
    }

    public List<String> getE() {
        return E;
    }

    public void setE(List<String> e) {
        E = e;
    }

    public List<String> getQ() {
        return q;
    }

    public void setQ(List<String> q) {
        this.q = q;
    }

    public List<String> getNul() {
        return nul;
    }

    public void setNul(List<String> nul) {
        this.nul = nul;
    }
}