package ui;

import java.io.IOException;

import defaultmap.Defaultmap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InGameController extends Application{
    private Stage stage;
    private Scene scene;

    Label locationLabel;
    Button defaultButton, alternateButton, parallelButton, back;

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
            //locationLabel.setText(Defaultmap.currentLocation.getName());
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
}
