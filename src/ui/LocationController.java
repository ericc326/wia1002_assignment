package ui;

import java.io.IOException;

import defaultmap.Defaultmap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * LocationController
 */
public class LocationController {
    private Stage stage;
    private Scene scene;

    @FXML
    Label locationLabel;
    Button defaultButton, alternateButton, parallelButton, back;

    public void defaultAction(ActionEvent e) {
        Defaultmap.selectMap(Defaultmap.defaultMap);
        enterGame(e);
    }

    public void parallelAction(ActionEvent e) {
        Defaultmap.selectMap(Defaultmap.parallelMap);
        enterGame(e);
    }

    public void alternateAction(ActionEvent e) {
        Defaultmap.selectMap(Defaultmap.alternateMap);
        enterGame(e);
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
    public void enterGame(ActionEvent e){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InGame_Scene.fxml"));
            Parent root = loader.load();

            InGameController igc = loader.getController();
            igc.setLocationName();
            
            //Parent root = FXMLLoader.load(getClass().getResource("InGame_Scene.fxml"));
            stage = (Stage)((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        //InGameController.startScene(stage);
    }
}