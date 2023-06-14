package LatestMap_Combined;
import java.util.*;

class Location {
    private String name;
    private List<Location> adjacentLocations;

    public Location(String name) {
        this.name = name;
        this.adjacentLocations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAdjacentLocation(Location location) {
        adjacentLocations.add(location);
    }

    public List<Location> getAdjacentLocations() {
        return adjacentLocations;
    }
}

public class VentoAureo {
    private Map<String, Location> locations;
    private List<List<Location>> districts;
    private List<Location> uncategorized;

    public VentoAureo() {
        locations = new HashMap<>();
        districts = new ArrayList<>();
        uncategorized = new ArrayList<>();
    }

    public void initializeMap(String map) {
        
        if(map.equals("defaultMap")){
        // Add locations to the map
        Location cafeDeuxMagots = new Location("Cafe Deux Magots");
        Location jadeGarden = new Location("Jade Garden");
        Location joestarMansion = new Location("Joestar Mansion");
        Location moriohGrandHotel = new Location("Morioh Grand Hotel");
        Location polnareffLand = new Location("Polnareff Land");
        Location savageGarden = new Location("Savage Garden");
        Location townHall = new Location("Town Hall");
        Location trattoriaTrussardi = new Location("Trattoria Trussardi");
        Location sanGiorgioMaggiore = new Location("San Giorgio Maggiore");
        Location greenDolphinStreetPrison = new Location("Green Dolphin Street Prison");
        Location passioneRestaurant = new Location("Libeccio");
        Location angeloRock = new Location("Angelo Rock");
        Location vineyard = new Location("Vineyard");
        Location dIOsMansion = new Location("DIO's Mansion");

        // Connect locations with roads
        connectLocations(townHall, cafeDeuxMagots);
        connectLocations(townHall, jadeGarden);
        connectLocations(townHall, moriohGrandHotel);

        connectLocations(moriohGrandHotel, trattoriaTrussardi);
        connectLocations(moriohGrandHotel, jadeGarden);

        connectLocations(trattoriaTrussardi, greenDolphinStreetPrison);
        connectLocations(trattoriaTrussardi, sanGiorgioMaggiore);

        connectLocations(greenDolphinStreetPrison, passioneRestaurant);
        connectLocations(greenDolphinStreetPrison, angeloRock);

        connectLocations(angeloRock, dIOsMansion);

        connectLocations(dIOsMansion, vineyard);
        connectLocations(dIOsMansion, passioneRestaurant);

        connectLocations(vineyard, joestarMansion);
        connectLocations(vineyard, savageGarden);

        connectLocations(savageGarden, polnareffLand);
        connectLocations(savageGarden, cafeDeuxMagots);
        connectLocations(savageGarden, joestarMansion);

        connectLocations(polnareffLand, cafeDeuxMagots);

        connectLocations(cafeDeuxMagots, savageGarden);

        connectLocations(jadeGarden, joestarMansion);
        connectLocations(jadeGarden, sanGiorgioMaggiore);
        connectLocations(jadeGarden, moriohGrandHotel);
        connectLocations(jadeGarden, townHall);

        connectLocations(sanGiorgioMaggiore, trattoriaTrussardi);
        connectLocations(sanGiorgioMaggiore, passioneRestaurant);

        connectLocations(passioneRestaurant, joestarMansion);
        connectLocations(passioneRestaurant, dIOsMansion);
        connectLocations(passioneRestaurant, greenDolphinStreetPrison);

        connectLocations(joestarMansion, vineyard);
        connectLocations(joestarMansion, passioneRestaurant);

        // Add locations to the map
        addLocation(cafeDeuxMagots);
        addLocation(jadeGarden);
        addLocation(joestarMansion);
        addLocation(moriohGrandHotel);
        addLocation(polnareffLand);
        addLocation(savageGarden);
        addLocation(townHall);
        addLocation(trattoriaTrussardi);
        addLocation(sanGiorgioMaggiore);
        addLocation(greenDolphinStreetPrison);
        addLocation(passioneRestaurant);
        addLocation(angeloRock);
        addLocation(vineyard);
        addLocation(dIOsMansion);
        
        
        }
        
        else if(map.equals("parallelMap")){
            
            // Add locations to the map
        Location cafeDeuxMagots = new Location("Cafe Deux Magots");
        Location jadeGarden = new Location("Jade Garden");
        Location joestarMansion = new Location("Joestar Mansion");
        Location moriohGrandHotel = new Location("Morioh Grand Hotel");
        Location polnareffLand = new Location("Polnareff Land");
        Location savageGarden = new Location("Savage Garden");
        Location townHall = new Location("Town Hall");
        Location trattoriaTrussardi = new Location("Trattoria Trussardi");
        Location sanGiorgioMaggiore = new Location("San Giorgio Maggiore");
        Location greenDolphinStreetPrison = new Location("Green Dolphin Street Prison");
        Location passioneRestaurant = new Location("Libeccio");
        Location angeloRock = new Location("Angelo Rock");
        Location vineyard = new Location("Vineyard");
        Location dIOsMansion = new Location("DIO's Mansion");

        // Connect locations with roads
       connectLocations(townHall, cafeDeuxMagots);
        connectLocations(townHall, trattoriaTrussardi);
        connectLocations(townHall, vineyard);
        connectLocations(townHall, passioneRestaurant);

connectLocations(moriohGrandHotel, joestarMansion);
connectLocations(moriohGrandHotel, cafeDeuxMagots);

connectLocations(trattoriaTrussardi, angeloRock);
connectLocations(trattoriaTrussardi, dIOsMansion);
connectLocations(trattoriaTrussardi, joestarMansion);

connectLocations(greenDolphinStreetPrison, dIOsMansion);
connectLocations(greenDolphinStreetPrison, angeloRock);

connectLocations(angeloRock, greenDolphinStreetPrison);

connectLocations(dIOsMansion, trattoriaTrussardi);
connectLocations(dIOsMansion, angeloRock);
connectLocations(dIOsMansion, greenDolphinStreetPrison);

connectLocations(vineyard, townHall);
connectLocations(vineyard, passioneRestaurant);

connectLocations(savageGarden, jadeGarden);
connectLocations(savageGarden, sanGiorgioMaggiore);
connectLocations(savageGarden, cafeDeuxMagots);

connectLocations(polnareffLand, cafeDeuxMagots);

connectLocations(cafeDeuxMagots, savageGarden);
connectLocations(cafeDeuxMagots, townHall);
connectLocations(cafeDeuxMagots, moriohGrandHotel);
connectLocations(cafeDeuxMagots, jadeGarden);
connectLocations(cafeDeuxMagots, polnareffLand);

connectLocations(jadeGarden, joestarMansion);
connectLocations(jadeGarden, savageGarden);
connectLocations(jadeGarden, cafeDeuxMagots);

connectLocations(sanGiorgioMaggiore, joestarMansion);
connectLocations(sanGiorgioMaggiore, savageGarden);

connectLocations(passioneRestaurant, townHall);
connectLocations(passioneRestaurant, vineyard);

connectLocations(joestarMansion, sanGiorgioMaggiore);
connectLocations(joestarMansion, jadeGarden);
connectLocations(joestarMansion, moriohGrandHotel);
connectLocations(joestarMansion, trattoriaTrussardi);

        // Add locations to the map
        addLocation(cafeDeuxMagots);
        addLocation(jadeGarden);
        addLocation(joestarMansion);
        addLocation(moriohGrandHotel);
        addLocation(polnareffLand);
        addLocation(savageGarden);
        addLocation(townHall);
        addLocation(trattoriaTrussardi);
        addLocation(sanGiorgioMaggiore);
        addLocation(greenDolphinStreetPrison);
        addLocation(passioneRestaurant);
        addLocation(angeloRock);
        addLocation(vineyard);
        addLocation(dIOsMansion);
            
            
        }
        
        else if(map.equals("alternateMap")){
            
             // Add locations to the map
        Location cafeDeuxMagots = new Location("Cafe Deux Magots");
        Location jadeGarden = new Location("Jade Garden");
        Location joestarMansion = new Location("Joestar Mansion");
        Location moriohGrandHotel = new Location("Morioh Grand Hotel");
        Location polnareffLand = new Location("Polnareff Land");
        Location savageGarden = new Location("Savage Garden");
        Location townHall = new Location("Town Hall");
        Location trattoriaTrussardi = new Location("Trattoria Trussardi");
        Location sanGiorgioMaggiore = new Location("San Giorgio Maggiore");
        Location greenDolphinStreetPrison = new Location("Green Dolphin Street Prison");
        Location passioneRestaurant = new Location("Passione Restaurant");
        Location angeloRock = new Location("Angelo Rock");
        Location vineyard = new Location("Vineyard");
        Location dIOsMansion = new Location("DIO's Mansion");

        // Connect locations with roads
       connectLocations(townHall, moriohGrandHotel);
        connectLocations(townHall, greenDolphinStreetPrison);
        connectLocations(townHall, passioneRestaurant);

connectLocations(moriohGrandHotel, joestarMansion);
connectLocations(moriohGrandHotel, greenDolphinStreetPrison);
connectLocations(moriohGrandHotel, sanGiorgioMaggiore);
connectLocations(moriohGrandHotel, townHall);

connectLocations(trattoriaTrussardi, joestarMansion);
connectLocations(trattoriaTrussardi, greenDolphinStreetPrison);
connectLocations(trattoriaTrussardi, passioneRestaurant);

connectLocations(greenDolphinStreetPrison, trattoriaTrussardi);
connectLocations(greenDolphinStreetPrison, moriohGrandHotel);
connectLocations(greenDolphinStreetPrison, townHall);

connectLocations(angeloRock, jadeGarden);
connectLocations(angeloRock, passioneRestaurant);
connectLocations(angeloRock, polnareffLand);

connectLocations(dIOsMansion, polnareffLand);
connectLocations(dIOsMansion, cafeDeuxMagots);
connectLocations(dIOsMansion, passioneRestaurant);

connectLocations(vineyard, savageGarden);
connectLocations(vineyard, cafeDeuxMagots);

connectLocations(savageGarden, sanGiorgioMaggiore);
connectLocations(savageGarden, vineyard);

connectLocations(polnareffLand, jadeGarden);
connectLocations(polnareffLand, angeloRock);
connectLocations(polnareffLand, dIOsMansion);

connectLocations(cafeDeuxMagots, vineyard);
connectLocations(cafeDeuxMagots, passioneRestaurant);
connectLocations(cafeDeuxMagots, dIOsMansion);

connectLocations(jadeGarden, angeloRock);
connectLocations(jadeGarden, polnareffLand);

connectLocations(sanGiorgioMaggiore, moriohGrandHotel);
connectLocations(sanGiorgioMaggiore, savageGarden);

connectLocations(passioneRestaurant, townHall);
connectLocations(passioneRestaurant, trattoriaTrussardi);
connectLocations(passioneRestaurant, angeloRock);
connectLocations(passioneRestaurant, dIOsMansion);
connectLocations(passioneRestaurant, cafeDeuxMagots);

connectLocations(joestarMansion, moriohGrandHotel);
connectLocations(joestarMansion, trattoriaTrussardi);

        // Add locations to the map
        addLocation(cafeDeuxMagots);
        addLocation(jadeGarden);
        addLocation(joestarMansion);
        addLocation(moriohGrandHotel);
        addLocation(polnareffLand);
        addLocation(savageGarden);
        addLocation(townHall);
        addLocation(trattoriaTrussardi);
        addLocation(sanGiorgioMaggiore);
        addLocation(greenDolphinStreetPrison);
        addLocation(passioneRestaurant);
        addLocation(angeloRock);
        addLocation(vineyard);
        addLocation(dIOsMansion);
            
        }
        

        // Add all locations to the uncategorized list initially
        uncategorized.addAll(locations.values());
    }

    public void startVentoAureo() {
        Scanner scanner = new Scanner(System.in);

        while (!uncategorized.isEmpty()) {
            displayDistricts();
            displayUncategorized();

            System.out.println("Enter two locations to combine (or enter 'Exit' to exit Vento Aureo):");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Exit")) {
                System.out.println("Exiting Vento Aureo.");
                break;
            }

            String[] locationsToCombine = input.split(" & ");

            if (locationsToCombine.length != 2) {
                System.out.println("Invalid input. Please enter two locations separated by ' & '.");
                continue;
            }

            Location location1 = getLocation(locationsToCombine[0]);
            Location location2 = getLocation(locationsToCombine[1]);

            if (location1 == null || location2 == null) {
                System.out.println("One or both locations do not exist.");
                continue;
            }

            if (!areConnected(location1, location2)) {
                System.out.println("The entered locations are not connected by a road.");
                continue;
            }

            // Combine the locations and update the districts
            combineLocations(location1, location2);
        }
    }

    private void connectLocations(Location location1, Location location2) {
        location1.addAdjacentLocation(location2);
        location2.addAdjacentLocation(location1);
    }

    private void addLocation(Location location) {
        locations.put(location.getName(), location);
    }

    private Location getLocation(String name) {
        return locations.get(name);
    }

    private boolean areConnected(Location location1, Location location2) {
        return location1.getAdjacentLocations().contains(location2);
    }

    private void combineLocations(Location location1, Location location2) {
        // Create a new district and add the combined locations
        List<Location> district = new ArrayList<>();
        district.add(location1);
        district.add(location2);

        // Remove the combined locations from the uncategorized list
        uncategorized.remove(location1);
        uncategorized.remove(location2);

        // Remove the combined locations from their previous districts (if any)
        for (List<Location> existingDistrict : districts) {
            existingDistrict.remove(location1);
            existingDistrict.remove(location2);
        }

        // Add the new district to the list of districts
        districts.add(district);

        System.out.println("Locations " + location1.getName() + " and " + location2.getName() + " have been combined.");
    }

    private void displayDistricts() {
        System.out.println("\nDistricts:");
        for (int i = 0; i < districts.size(); i++) {
            List<Location> district = districts.get(i);
            System.out.print("District " + (i + 1) + ":");
            System.out.print("{");
            for (Location location : district) {
                System.out.print(location.getName()+",");
            }
            System.out.println("\b}");
        }
    }

    private void displayUncategorized() {
        System.out.println("\nUncategorized Locations:");
        for (Location location : uncategorized) {
            System.out.println("- " + location.getName());
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        
     //   String map = "defaultMap";
     //  String map = "parallelMap";
       String map = "alternateMap";
        
        VentoAureo vento = new VentoAureo();
        vento.initializeMap(map);
        vento.startVentoAureo();
    }
}

    

