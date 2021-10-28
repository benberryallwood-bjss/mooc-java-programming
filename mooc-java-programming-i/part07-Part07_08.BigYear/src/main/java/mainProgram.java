
import java.util.Scanner;

public class mainProgram {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BirdList birdList = new BirdList();

        UserInterface ui = new UserInterface(scan, birdList);
        ui.start();
    }

}
