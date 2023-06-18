package defaultmap;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;

import Restaurants.DataCustomer;
import Restaurants.Restaurant;
import Restaurants.Sale;
import defaultmap.map.Location;


public class gameSaveLoad implements Serializable{
    private static final long serialVersionUID = 1L;

    private map gameMap;
    private List<Restaurant> resList;
    private List<Sale> saleList;
    private Location currentLocation;
    private int currentDay;
    private Stack<map.Location> locationHistory;
    private Stack<map.Location> ForwardLocationHistory;
    private DataCustomer customerData;

    public gameSaveLoad(){}

    public gameSaveLoad(map gameMap,List<Restaurant> resList, List<Sale> saleList, DataCustomer customerData, Location currentLocation, int currentDay, Stack<map.Location> locationHistory, Stack<map.Location> ForwardLocationHistory){
        this.gameMap=gameMap;
        this.resList=resList;
        this.saleList=saleList;
        this.customerData=customerData;
        this.currentLocation=currentLocation;
        this.currentDay=currentDay;
        this.locationHistory=locationHistory;
        this.ForwardLocationHistory=ForwardLocationHistory;
    }

    public static void save(gameSaveLoad data, String ID){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(ID)));
            oos.writeObject(data);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return;
        }
    }

    public static Object load(String ID){
        try {
            ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(ID)));
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public map getGameMap() {
        return gameMap;
    }

    public void setGameMap(map gameMap) {
        this.gameMap = gameMap;
    }

    public List<Restaurant> getResList() {
        return resList;
    }

    public void setResList(List<Restaurant> resList) {
        this.resList = resList;
    }

    public List<Sale> getSaleList() {
        return saleList;
    }

    public void setSaleList(List<Sale> saleList) {
        this.saleList = saleList;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    public Stack<map.Location> getLocationHistory() {
        return locationHistory;
    }

    public void setLocationHistory(Stack<map.Location> locationHistory) {
        this.locationHistory = locationHistory;
    }

    public Stack<map.Location> getForwardLocationHistory() {
        return ForwardLocationHistory;
    }

    public void setForwardLocationHistory(Stack<map.Location> forwardLocationHistory) {
        ForwardLocationHistory = forwardLocationHistory;
    }

    public DataCustomer getCustomerData() {
        return customerData;
    }

    public void setCustomerData(DataCustomer customerData) {
        this.customerData = customerData;
    }
}
