/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package defaultmap;

/**
 *
 * @author Asus
 */
import java.util.LinkedList;

    public class map {
    static Location townHall;
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

    public map() {
        // Initialize the locations and their adjacent locations with distances
        townHall = new Location("Town Hall");
        cafeDeuxMagots = new Location("Cafe Deux Magots");
        jadeGarden = new Location("Jade Garden");
        moriohGrandHotel = new Location("Morioh Grand Hotel");
        TrattoriaTrussardi = new Location("Trattoria Trussardi");
        SanGiorgioMaggiore = new Location(" San Giorgio Maggiore");
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
        
        moriohGrandHotel.addAdjacentLocation(townHall, 4); 
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
