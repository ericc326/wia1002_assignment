package defaultmap;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;
import PearlJam.Restaurant;
import PearlJam.Sale;
import defaultmap.map.Location;


public class gameSaveLoad implements Serializable{
    private static final long serialVersionUID = 1L;

    public map gameMap;
    public List<Restaurant> resList;
    public List<Sale> saleList;
    public Location currentLocation;
    public int currentDay;
    public Stack<map.Location> locationHistory;
    public Stack<map.Location> ForwardLocationHistory;

    public gameSaveLoad(){}

    public gameSaveLoad(map gameMap,List<Restaurant> resList, List<Sale> saleList, Location currentLocation, int currentDay, Stack<Location> locationHistory, Stack<Location> ForwardLocationHistory){
        this.gameMap=gameMap;
        this.resList=resList;
        this.saleList=saleList;
        this.currentLocation=currentLocation;
        this.currentDay=currentDay;
        this.locationHistory=locationHistory;
        this.ForwardLocationHistory=locationHistory;
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
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }
}
