import java.util.Scanner;

public class MilagroMan /*extends MoodyBlues and/or PearlJam*/{
    private String restaurantName;
    public MilagroMan(String restaurantName){
        this.restaurantName=restaurantName;
    }

    public void CreateFood(String foodName, Double price){
        System.out.println(restaurantName);
    }

    public void  ModifyFood(String foodName, Double price, int dayStart, int dayEnd){
    }

    public void RemoveFood(){
    }

    public void Menu(String restaurantName){
    }

    public void Menu(){
        System.out.println("Restaurant: "+restaurantName+" (Milagro Man Mode)");
        System.out.println("[1] Add A New Food");
        System.out.println("[2] Modify Food Prices");
        System.out.println("[3] View Sales Information");
        System.out.println("[4] Exit Milagro Man");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        
    }
}