
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Points points = new Points();

//        String input = "102\n-4\n33\n77\n99\n1\n-1\n";
//        Scanner testScanner = new Scanner(input);

        UserInterface ui = new UserInterface(points, scanner);
        ui.start();
    }
}
