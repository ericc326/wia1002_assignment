package ui;

import java.io.IOException;

import Restaurants.Restaurant;
import defaultmap.Defaultmap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class InGameController extends Application {
    private Stage stage;
    private Scene scene;

    @FXML
    Label locationTxt, dayTxt;
    @FXML
    AnchorPane TownHallPane, CafePane, JadeGardenPane, HotelPane, TTPane, PolLandPane, JoestarMansionPane, AngeloPane,
            SGMPane, PrisonPane,
            LibeccioPane, VineyardPane, DIOsMansionPane, SavageGardenPane, PassionePane;
    /*
     * Button nextDayBtn, backBtn, saveBtn, exitBtn, forwardBtn, toTownHallBtn,
     * toCafeBtn, toTTBtn, toJadeGardenBtn, toHotelBtn,
     * toPolLandBtn, toJoestarMansionBtn, toAngeloBtn, toSGMBtn, toPrisonBtn,
     * toLibeccioBtn, toVineyardBtn, toDIOsMansionBtn,
     * toSavageGardenBtn, toPassioneBtn;
     */

    public InGameController() {
    }

    public static void startScene(Stage stage) {
        InGameController n = new InGameController();
        try {
            n.start(stage);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage arg0) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("InGame_Scene.fxml"));
            Scene scene = new Scene(root);
            arg0.setScene(scene);
            System.out.println(Defaultmap.currentLocation.getName());
            arg0.show();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void defaultAction(ActionEvent e) {
        Defaultmap.selectMap(Defaultmap.defaultMap);
    }

    public void parallelAction(ActionEvent e) {
        Defaultmap.selectMap(Defaultmap.parallelMap);
    }

    public void alternateAction(ActionEvent e) {
        Defaultmap.selectMap(Defaultmap.alternateMap);
    }

    public void backToMenu(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Main_Scene.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public void firstLoad() {
        locationTxt.setText(Defaultmap.currentLocation.getName());
        dayTxt.setText("Day: "+Defaultmap.currentDay);
        TownHallPane.setVisible(true);
        TownHallPane.setDisable(false);
    }

    public void changeLocation(String LocationName) {
        locationTxt.setText(Defaultmap.currentLocation.getName());
        int adjCount = Defaultmap.currentLocation.getAdjacentLocations().size();
    }

    /*
     * public void changePane(String locationName){
     * switch (locationName) {
     * case value:
     * 
     * break;
     * 
     * default:
     * break;
     * }
     * }
     */

    public void gotoPR(ActionEvent e) {
        System.out.println("hello");
    }

    public void gotoSG(ActionEvent e) {
        System.out.println("hello");
    }

    public void gotoDIOsMansion(ActionEvent e) {
        System.out.println("hello");
    }

    public void gotoVineyard(ActionEvent e) {
        System.out.println("hello");
    }

    public void gotoLibeccio(ActionEvent e) {
        System.out.println("hello");
    }

    public void gotoGDSP(ActionEvent e) {
        System.out.println("hello");
    }

    public void gotoSGM(ActionEvent e) {
        System.out.println("hello");
    }

    public void gotoAR(ActionEvent e) {
        System.out.println("hello");
    }

    public void gotoJM(ActionEvent e) {
        System.out.println("hello");
    }

    public void gotoPL(ActionEvent e) {
        System.out.println("hello");
    }

    public void gotoTT(ActionEvent e) {
        System.out.println("hello");
    }

    public void gotoHotel(ActionEvent e) {
        System.out.println("hello");
    }

    public void gotoJadeGarden(ActionEvent e) {
        System.out.println("hello");
    }

    public void gotoCafe(ActionEvent e) {
        System.out.println("hello");
    }

    public void gotoTownHall(ActionEvent e) {
        System.out.println("hello");
    }

    public void toNextDay(ActionEvent e) {
        System.out.println("next day");
        Defaultmap.handleAdvanceToNextDay();
        dayTxt.setText("Day: "+Defaultmap.currentDay);
        gotoTownHall(e);
    }

    public void saveGame(ActionEvent e) {
        System.out.println("save");
        Defaultmap.handleSave();
    }

    public void exitGame(ActionEvent e) {
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
        System.exit(0);
    }

    public void gotoBacktrack(ActionEvent e) {
        System.out.println("backtrack");
    }
    public void gotoForward(ActionEvent e) {
        System.out.println("forward");
    }

    public void openMenu(ActionEvent e) {
        Restaurant resTemp = Restaurant.getResByName(Defaultmap.currentLocation.getName());
        resTemp.viewMenubyResName(resTemp.getRestaurantName());
    }

    public void gotoOrderList(ActionEvent e) {
        System.out.println("order");
    }

    public void gotoMB(ActionEvent e) {
        System.out.println("Moody Blues");
    }

    public void gotoMM(ActionEvent e) {
        System.out.println("Milagro Man");
    }
}
