package ui;

import java.io.IOException;

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

public class InGameController extends Application{
    private Stage stage;
    private Scene scene;

    @FXML
    Label locationTxt;
    AnchorPane TownHallPane, CafePane, JadeGardenPane, HotelPane, TTPane, PolLandPane, JoestarMansionPane, AngeloPane, SGMPane, PrisonPane, 
        LibeccioPane, VineyardPane, DIOsMansionPane, SavageGardenPane, PassionePane;
    Button nextDayBtn, backBtn, saveBtn, exitBtn, forwardBtn, toTownHallBtn, toCafeBtn, toTTBtn, toJadeGardenBtn, toHotelBtn, 
        toPolLandBtn, toJoestarMansionBtn, toAngeloBtn, toSGMBtn, toPrisonBtn, toLibeccioBtn, toVineyardBtn, toDIOsMansionBtn,
        toSavageGardenBtn, toPassioneBtn;

    public InGameController(){}

    public static void startScene(Stage stage){
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
            stage = (Stage)((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public void setLocationName(){
        locationTxt.setText(Defaultmap.currentLocation.getName()+" Day:"+Defaultmap.currentDay);
    }

    public void changeLocation(String LocationName){
        locationTxt.setText(Defaultmap.currentLocation.getName());
        int adjCount = Defaultmap.currentLocation.getAdjacentLocations().size();
    }

    /*public void changePane(String locationName){
        switch (locationName) {
            case value:
                
                break;
        
            default:
                break;
        }
    }*/

    private static void gotoPR() {
    }

    private static void gotoSG() {
    }

    private static void gotoDIOsMansion() {
    }

    private static void gotoVineyard() {
    }

    private static void gotoLibeccio() {
    }

    private static void gotoGDSP() {
    }

    private static void gotoSGM() {
    }

    private static void gotoAR() {
    }

    private static void gotoJM() {
    }

    private static void gotoPL() {
    }

    private static void gotoTT() {
    }

    private static void gotoHotel() {
    }

    private static void gotoJadeGarden() {
    }

    private static void gotoCafe() {
    }

    private static void displayTownHall() {
    }
}
