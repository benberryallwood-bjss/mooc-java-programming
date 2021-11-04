package FlightControl;

import FlightControl.logic.FlightManager;
import FlightControl.userInterface.UserInterface;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        FlightManager flightManager = new FlightManager();

        UserInterface userInterface = new UserInterface(userInput, flightManager);
        userInterface.start();
    }
}
