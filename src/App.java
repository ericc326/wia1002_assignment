import javafx.application.Application;
import javafx.stage.Stage;
import ui.MainController;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        /*System.out.println("Hello, World!");
        //MoodyBlues.callMenu();
        Restaurant.InitializeRestaurant();
        System.out.println("\nEnter restaurant name:");
        Scanner scanner = new Scanner(System.in);
        String restaurantName = scanner.nextLine();
        MilagroMan mg = new MilagroMan(restaurantName);
        mg.Menu();
        scanner.close();*/
        launch(args);
        //Defaultmap.start();
    }

    @Override
    public void start(Stage arg0) throws Exception {
        MainController ui = new MainController();
        ui.start(arg0);
    }
}