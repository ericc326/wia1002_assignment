package ui;

import java.io.IOException;

import defaultmap.Defaultmap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainController extends Application {
    public MainController() {
    }

    private Stage stage;
    private Scene scene;

    @FXML
    Label locationLabel;
    Button startGameButton, loadGameButton, exiButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Main_Scene.fxml"));
            Scene scene = new Scene(root);
            arg0.setScene(scene);
            // locationLabel.setText("Welcome, JOJO!!!");
            arg0.show();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void startGame(ActionEvent e) {
        Defaultmap.initializeGamePublic();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Location_Scene.fxml"));    
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
    }

    public void loadGame(ActionEvent e) {
        Defaultmap.loadGame();
    }

    public void exitGame(ActionEvent e) {
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.close();
    }
}
