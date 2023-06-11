/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PearlJam;

/**
 *
 * @author USER
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package defaultmap;

/**
 *
 * @author Asus
 */
import java.util.LinkedList;

    public class map {
        //default map
    Location townHall;
    Location cafeDeuxMagots;
    Location jadeGarden;
    Location moriohGrandHotel;
    Location TrattoriaTrussardi;
    Location SanGiorgioMaggiore;
    Location GreenDolphinStreetPrison;
    Location Libeccio;
    Location AngeloRock;
    Location SavageGarden;
    Location PolnareffLand;
    Location JoestarMansion;
    Location Vineyard;
    Location DIOsMansion;
    
    //parallel map
    Location townHall1;
    Location cafeDeuxMagots1;
    Location jadeGarden1;
    Location moriohGrandHotel1;
    Location TrattoriaTrussardi1;
    Location SanGiorgioMaggiore1;
    Location GreenDolphinStreetPrison1;
    Location Libeccio1;
    Location AngeloRock1;
    Location SavageGarden1;
    Location PolnareffLand1;
    Location JoestarMansion1;
    Location Vineyard1;
    Location DIOsMansion1;
    
    //alternate map
    Location townHall2;
    Location cafeDeuxMagots2;
    Location jadeGarden2;
    Location moriohGrandHotel2;
    Location TrattoriaTrussardi2;
    Location SanGiorgioMaggiore2;
    Location GreenDolphinStreetPrison2;
    Location Libeccio2;
    Location AngeloRock2;
    Location SavageGarden2;
    Location PolnareffLand2;
    Location JoestarMansion2;
    Location Vineyard2;
    Location DIOsMansion2;
    Location PassioneRestaurant2;

    public map() {
        // Initialize the locations and their adjacent locations with distances(default map)
        townHall = new Location("Town Hall");
        cafeDeuxMagots = new Location("Cafe Deux Magots");
        jadeGarden = new Location("Jade Garden");
        moriohGrandHotel = new Location("Morioh Grand Hotel");
        TrattoriaTrussardi = new Location("Trattoria Trussardi");
        SanGiorgioMaggiore = new Location("San Giorgio Maggiore");
        GreenDolphinStreetPrison = new Location("Green Dolphin Street Prison");
        Libeccio = new Location("Libeccio");
        AngeloRock = new Location("Angelo Rock");
        SavageGarden = new Location("SavageGarden");
        PolnareffLand = new Location("Polnareff Land");
        JoestarMansion = new Location("Joestar Mansion");
        Vineyard = new Location("Vineyard");
        DIOsMansion = new Location("DIO's Mansion");

        // Connect the locations by adding adjacent locations with distances
        townHall.addAdjacentLocation(cafeDeuxMagots, 4); 
        townHall.addAdjacentLocation(jadeGarden, 5); 
        townHall.addAdjacentLocation(moriohGrandHotel, 5); 
        
        moriohGrandHotel.addAdjacentLocation(townHall, 5); 
        moriohGrandHotel.addAdjacentLocation(jadeGarden, 5); 
        moriohGrandHotel.addAdjacentLocation(TrattoriaTrussardi, 3); 

        TrattoriaTrussardi.addAdjacentLocation(moriohGrandHotel, 6); 
        TrattoriaTrussardi.addAdjacentLocation(SanGiorgioMaggiore, 3); 
        TrattoriaTrussardi.addAdjacentLocation(GreenDolphinStreetPrison, 6); 
        
        GreenDolphinStreetPrison.addAdjacentLocation(TrattoriaTrussardi, 6); 
        GreenDolphinStreetPrison.addAdjacentLocation(Libeccio, 3); 
        GreenDolphinStreetPrison.addAdjacentLocation(AngeloRock, 2);

        PolnareffLand.addAdjacentLocation(cafeDeuxMagots, 4);
        PolnareffLand.addAdjacentLocation(SavageGarden, 6);

        cafeDeuxMagots.addAdjacentLocation(townHall, 4);
        cafeDeuxMagots.addAdjacentLocation(PolnareffLand, 4);
        cafeDeuxMagots.addAdjacentLocation(jadeGarden,3);
        cafeDeuxMagots.addAdjacentLocation(SavageGarden, 4);
        
        jadeGarden.addAdjacentLocation(townHall, 5);
        jadeGarden.addAdjacentLocation(cafeDeuxMagots, 3);
        jadeGarden.addAdjacentLocation(moriohGrandHotel, 3);
        jadeGarden.addAdjacentLocation(SanGiorgioMaggiore, 2);
        jadeGarden.addAdjacentLocation(JoestarMansion, 2);
        
        SanGiorgioMaggiore.addAdjacentLocation(jadeGarden, 2);
        SanGiorgioMaggiore.addAdjacentLocation(TrattoriaTrussardi, 3);
        SanGiorgioMaggiore.addAdjacentLocation(Libeccio, 4);
        
        Libeccio.addAdjacentLocation(SanGiorgioMaggiore, 4);
        Libeccio.addAdjacentLocation(JoestarMansion, 6);
        Libeccio.addAdjacentLocation(Vineyard, 6);
        Libeccio.addAdjacentLocation(DIOsMansion, 2);
        Libeccio.addAdjacentLocation(GreenDolphinStreetPrison, 3);
        
        AngeloRock.addAdjacentLocation(GreenDolphinStreetPrison, 2);
        AngeloRock.addAdjacentLocation(DIOsMansion, 3);
        
        DIOsMansion.addAdjacentLocation(Libeccio, 2);
        DIOsMansion.addAdjacentLocation(Vineyard, 3);
        DIOsMansion.addAdjacentLocation(AngeloRock, 3);
        
        JoestarMansion.addAdjacentLocation(jadeGarden, 2);
        JoestarMansion.addAdjacentLocation(Libeccio, 6);
        JoestarMansion.addAdjacentLocation(Vineyard, 3);
        JoestarMansion.addAdjacentLocation(SavageGarden, 4);
        
        SavageGarden.addAdjacentLocation(PolnareffLand, 6);
        SavageGarden.addAdjacentLocation(cafeDeuxMagots, 4);
        SavageGarden.addAdjacentLocation(JoestarMansion, 4);
        SavageGarden.addAdjacentLocation(Vineyard, 8);
        
        Vineyard.addAdjacentLocation(SavageGarden, 8);
        Vineyard.addAdjacentLocation(JoestarMansion, 3);
        Vineyard.addAdjacentLocation(Libeccio, 6);
        Vineyard.addAdjacentLocation(DIOsMansion, 3);
        
        // Initialize the locations and their adjacent locations with distances(parallel map)
        townHall1 = new Location("Town Hall");
        cafeDeuxMagots1 = new Location("Cafe Deux Magots");
        jadeGarden1 = new Location("Jade Garden");
        moriohGrandHotel1 = new Location("Morioh Grand Hotel");
        TrattoriaTrussardi1 = new Location("Trattoria Trussardi");
        SanGiorgioMaggiore1 = new Location("San Giorgio Maggiore");
        GreenDolphinStreetPrison1 = new Location("Green Dolphin Street Prison");
        Libeccio1 = new Location("Libeccio");
        AngeloRock1 = new Location("Angelo Rock");
        SavageGarden1 = new Location("SavageGarden");
        PolnareffLand1 = new Location("Polnareff Land");
        JoestarMansion1 = new Location("Joestar Mansion");
        Vineyard1 = new Location("Vineyard");
        DIOsMansion1 = new Location("DIO's Mansion");

        // Connect the locations by adding adjacent locations with distances
        townHall1.addAdjacentLocation(cafeDeuxMagots1, 4); 
        townHall1.addAdjacentLocation(Libeccio1, 2); 
        townHall1.addAdjacentLocation(Vineyard1, 3); 
        townHall1.addAdjacentLocation(TrattoriaTrussardi1, 6); 

        moriohGrandHotel1.addAdjacentLocation(JoestarMansion1, 4); 
        moriohGrandHotel1.addAdjacentLocation(cafeDeuxMagots1, 6);  

        TrattoriaTrussardi1.addAdjacentLocation(townHall1, 6); 
        TrattoriaTrussardi1.addAdjacentLocation(JoestarMansion1, 5); 
        TrattoriaTrussardi1.addAdjacentLocation(DIOsMansion1,4); 
        TrattoriaTrussardi1.addAdjacentLocation(AngeloRock1,3); 
        
        GreenDolphinStreetPrison1.addAdjacentLocation(DIOsMansion1, 6); 
        GreenDolphinStreetPrison1.addAdjacentLocation(AngeloRock1, 8); 

        PolnareffLand1.addAdjacentLocation(cafeDeuxMagots1, 2);

        cafeDeuxMagots1.addAdjacentLocation(townHall1, 4);
        cafeDeuxMagots1.addAdjacentLocation(PolnareffLand1, 2);
        cafeDeuxMagots1.addAdjacentLocation(jadeGarden1,3);
        cafeDeuxMagots1.addAdjacentLocation(SavageGarden1, 5);
        cafeDeuxMagots1.addAdjacentLocation(moriohGrandHotel1, 6);
        
        jadeGarden1.addAdjacentLocation(SavageGarden1, 4);
        jadeGarden1.addAdjacentLocation(cafeDeuxMagots1, 3);
        jadeGarden1.addAdjacentLocation(JoestarMansion1,3);
        
        SanGiorgioMaggiore1.addAdjacentLocation(SavageGarden1, 6);
        SanGiorgioMaggiore1.addAdjacentLocation(JoestarMansion1, 5);
        
        Libeccio1.addAdjacentLocation(townHall1, 2);
        Libeccio1.addAdjacentLocation(Vineyard1, 3);
 
        AngeloRock1.addAdjacentLocation(GreenDolphinStreetPrison1, 8);
        AngeloRock1.addAdjacentLocation(DIOsMansion1, 1);
        AngeloRock1.addAdjacentLocation(TrattoriaTrussardi1, 3);
        
        DIOsMansion1.addAdjacentLocation(GreenDolphinStreetPrison1, 6);
        DIOsMansion1.addAdjacentLocation(TrattoriaTrussardi1, 4);
        DIOsMansion1.addAdjacentLocation(AngeloRock1, 1);
        
        JoestarMansion1.addAdjacentLocation(jadeGarden1, 3);
        JoestarMansion1.addAdjacentLocation(TrattoriaTrussardi1, 5);
        JoestarMansion1.addAdjacentLocation(moriohGrandHotel1, 4);
        JoestarMansion1.addAdjacentLocation(SanGiorgioMaggiore1, 5);
        
        SavageGarden1.addAdjacentLocation(jadeGarden1, 4);
        SavageGarden1.addAdjacentLocation(cafeDeuxMagots1, 5);
        SavageGarden1.addAdjacentLocation(SanGiorgioMaggiore1, 6);
        
        Vineyard1.addAdjacentLocation(Libeccio1, 3);
        Vineyard1.addAdjacentLocation(townHall1, 3);
                

        // Initialize the locations and their adjacent locations with distances(alternate map)
        townHall2 = new Location("Town Hall");
        cafeDeuxMagots2 = new Location("Cafe Deux Magots");
        jadeGarden2 = new Location("Jade Garden");
        moriohGrandHotel2 = new Location("Morioh Grand Hotel");
        TrattoriaTrussardi2 = new Location("Trattoria Trussardi");
        SanGiorgioMaggiore2 = new Location("San Giorgio Maggiore");
        GreenDolphinStreetPrison2 = new Location("Green Dolphin Street Prison");
        Libeccio2 = new Location("Libeccio");
        AngeloRock2 = new Location("Angelo Rock");
        SavageGarden2 = new Location("SavageGarden");
        PolnareffLand2 = new Location("Polnareff Land");
        JoestarMansion2 = new Location("Joestar Mansion");
        Vineyard2 = new Location("Vineyard");
        DIOsMansion2 = new Location("DIO's Mansion");
        PassioneRestaurant2 = new Location("Passione Restaurant");

        // Connect the locations by adding adjacent locations with distances
        townHall2.addAdjacentLocation(GreenDolphinStreetPrison2, 3); 
        townHall2.addAdjacentLocation(PassioneRestaurant2, 7); 
        townHall2.addAdjacentLocation(moriohGrandHotel2, 2); 
        
        moriohGrandHotel2.addAdjacentLocation(townHall2, 2); 
        moriohGrandHotel2.addAdjacentLocation(GreenDolphinStreetPrison2, 2); 
        moriohGrandHotel2.addAdjacentLocation(SanGiorgioMaggiore2, 3); 
        moriohGrandHotel2.addAdjacentLocation(JoestarMansion2, 4); 

        TrattoriaTrussardi2.addAdjacentLocation(JoestarMansion2, 5); 
        TrattoriaTrussardi2.addAdjacentLocation(GreenDolphinStreetPrison2, 4); 
        TrattoriaTrussardi2.addAdjacentLocation(PassioneRestaurant2, 1); 
        
        GreenDolphinStreetPrison2.addAdjacentLocation(TrattoriaTrussardi2, 4); 
        GreenDolphinStreetPrison2.addAdjacentLocation(townHall2, 3); 
        GreenDolphinStreetPrison2.addAdjacentLocation(moriohGrandHotel2, 2);

        PolnareffLand2.addAdjacentLocation(AngeloRock2, 2);
        PolnareffLand2.addAdjacentLocation(jadeGarden2, 2);
        PolnareffLand2.addAdjacentLocation(DIOsMansion2, 2);

        cafeDeuxMagots2.addAdjacentLocation(DIOsMansion2, 2);
        cafeDeuxMagots2.addAdjacentLocation(PassioneRestaurant2, 4);
        cafeDeuxMagots2.addAdjacentLocation(Vineyard2,4);
        
        jadeGarden2.addAdjacentLocation(AngeloRock2, 1);
        jadeGarden2.addAdjacentLocation(PolnareffLand2,2);
        
        SanGiorgioMaggiore2.addAdjacentLocation(moriohGrandHotel2, 3);
        SanGiorgioMaggiore2.addAdjacentLocation(SavageGarden2, 6);
        
        AngeloRock2.addAdjacentLocation(jadeGarden2, 1);
        AngeloRock2.addAdjacentLocation(PolnareffLand2, 2);
        AngeloRock2.addAdjacentLocation(PassioneRestaurant2, 6);
        
        DIOsMansion2.addAdjacentLocation(PassioneRestaurant2, 2);
        DIOsMansion2.addAdjacentLocation(PolnareffLand2, 2);
        DIOsMansion2.addAdjacentLocation(cafeDeuxMagots2, 1);
        
        JoestarMansion2.addAdjacentLocation(moriohGrandHotel2, 4);
        JoestarMansion2.addAdjacentLocation(TrattoriaTrussardi2, 5);
        
        SavageGarden2.addAdjacentLocation(SanGiorgioMaggiore2, 6);
        SavageGarden2.addAdjacentLocation(Vineyard2, 4);
        
        Vineyard2.addAdjacentLocation(SavageGarden2, 4);
        Vineyard2.addAdjacentLocation(cafeDeuxMagots2, 4);
        
        PassioneRestaurant2.addAdjacentLocation(townHall2, 7);
        PassioneRestaurant2.addAdjacentLocation(cafeDeuxMagots2, 4);
        PassioneRestaurant2.addAdjacentLocation(TrattoriaTrussardi2, 1);
        PassioneRestaurant2.addAdjacentLocation(AngeloRock2, 6);
        PassioneRestaurant2.addAdjacentLocation(DIOsMansion2, 2);

        // Add the locations to the linked list representing the map
        LinkedList<Location> defaultMap = new LinkedList<>();
        defaultMap.add(townHall);
        defaultMap.add(cafeDeuxMagots);
        defaultMap.add(jadeGarden);
        defaultMap.add(moriohGrandHotel);
        defaultMap.add(TrattoriaTrussardi);
        defaultMap.add(SanGiorgioMaggiore);
        defaultMap.add(GreenDolphinStreetPrison);
        defaultMap.add(Libeccio);
        defaultMap.add(AngeloRock);
        defaultMap.add(SavageGarden);
        defaultMap.add(PolnareffLand);
        defaultMap.add(JoestarMansion);
        defaultMap.add(Vineyard);
        defaultMap.add(DIOsMansion);
        
        LinkedList<Location> parallelMap = new LinkedList<>();
        parallelMap.add(townHall1);
        parallelMap.add(cafeDeuxMagots1);
        parallelMap.add(jadeGarden1);
        parallelMap.add(moriohGrandHotel1);
        parallelMap.add(TrattoriaTrussardi1);
        parallelMap.add(SanGiorgioMaggiore1);
        parallelMap.add(GreenDolphinStreetPrison1);
        parallelMap.add(Libeccio1);
        parallelMap.add(AngeloRock1);
        parallelMap.add(SavageGarden1);
        parallelMap.add(PolnareffLand1);
        parallelMap.add(JoestarMansion1);
        parallelMap.add(Vineyard1);
        parallelMap.add(DIOsMansion1);
        
        LinkedList<Location> alternateMap = new LinkedList<>();
        alternateMap.add(townHall2);
        alternateMap.add(cafeDeuxMagots2);
        alternateMap.add(jadeGarden2);
        alternateMap.add(moriohGrandHotel2);
        alternateMap.add(TrattoriaTrussardi2);
        alternateMap.add(SanGiorgioMaggiore2);
        alternateMap.add(GreenDolphinStreetPrison2);
        alternateMap.add(Libeccio2);
        alternateMap.add(AngeloRock2);
        alternateMap.add(SavageGarden2);
        alternateMap.add(PolnareffLand2);
        alternateMap.add(JoestarMansion2);
        alternateMap.add(Vineyard2);
        alternateMap.add(DIOsMansion2);
        alternateMap.add(PassioneRestaurant2);

        
    }
    
public class Location {
        private String name;
        private LinkedList<AdjacentLocation> adjacentLocations;

        public Location(String name) {
            this.name = name;
            adjacentLocations = new LinkedList<>();
        }

        public void addAdjacentLocation(Location location, int distance) {
            AdjacentLocation adjacentLocation = new AdjacentLocation(location, distance);
            adjacentLocations.add(adjacentLocation);
        }

        public String getName(){
            return name;
        }
        
        public LinkedList<AdjacentLocation> getAdjacentLocations(){
            return adjacentLocations;
        }

public class AdjacentLocation {
            private Location location;
            private int distance;

            public AdjacentLocation(Location location, int distance) {
                this.location = location;
                this.distance = distance;
            }

    public Location getLocation() {
        return location;
    }

    public int getDistance() {
        return distance;
    }
}
}
    }

