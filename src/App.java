import java.util.Scanner;

import defaultmap.Defaultmap;
import javafx.application.Application;
import javafx.stage.Stage;
import ui.MainController;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!\nENTER 1 FOR GUI, 2 FOR CLI:");
        // MoodyBlues.callMenu();
        // Restaurant.InitializeRestaurant();
        // System.out.println("\nEnter restaurant name:");
        Scanner scanner = new Scanner(System.in);
        String string = "1";//scanner.nextLine();
        switch (string) {
            case "1":
                launch(args);
                break;
            case "2":
                Defaultmap.start();
                break;
            default:
                System.out.println("wtf?");
                System.exit(0);
                break;
        }
        // MilagroMan mg = new MilagroMan(string);
        // mg.Menu();
        // scanner.close();*/
    }

    @Override
    public void start(Stage arg0) throws Exception {
        MainController ui = new MainController();
        ui.start(arg0);
    }
}