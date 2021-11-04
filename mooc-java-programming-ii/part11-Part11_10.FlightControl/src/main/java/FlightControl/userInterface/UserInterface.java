package FlightControl.userInterface;

import FlightControl.domain.Airplane;
import FlightControl.logic.FlightManager;

import java.util.Scanner;

public class UserInterface {
    private Scanner userInput;
    private FlightManager flightManager;

    public UserInterface(Scanner userInput, FlightManager flightManager) {
        this.userInput = userInput;
        this.flightManager = flightManager;
    }

    public void start() {
        startAssetControl();
        System.out.println();
        startFlightControl();
    }

    private void startAssetControl() {
        System.out.println("Airport Asset Control");
        System.out.println("--------------------");
        System.out.println();

        printAssetControlOptions();
        String currentInput = userInput.nextLine();

        while (!currentInput.equals("x")) {
            switch (currentInput) {
                case "1":
                    createAirplane();
                    break;
                case "2":
                    createFlight();
                    break;
            }

            printAssetControlOptions();
            currentInput = userInput.nextLine();
        }
    }

    private void printAssetControlOptions() {
        System.out.println("Choose an action:");
        System.out.println("[1] Add an airplane");
        System.out.println("[2] Add a flight");
        System.out.println("[x] Exit Airport Asset Control");
        System.out.print("> ");
    }

    private void createAirplane() {
        System.out.print("Give the airplane id: ");
        String airplaneID = userInput.nextLine();

        System.out.print("Give the airplane capacity: ");
        String airplaneCapacity = userInput.nextLine();

        flightManager.createAirplane(airplaneID, airplaneCapacity);
    }

    private void createFlight() {
        System.out.print("Give the airplane id: ");
        String airplaneID = userInput.nextLine();

        System.out.print("Give the departure airport id: ");
        String departureAirportID = userInput.nextLine();

        System.out.print("Give the target airport id: ");
        String destinationAirportID = userInput.nextLine();

        flightManager.createFlight(airplaneID, departureAirportID, destinationAirportID);
    }

    private void startFlightControl() {
        System.out.println("Flight Control");
        System.out.println("------------");
        System.out.println();

        printFlightControlOptions();
        String currentInput = userInput.nextLine();

        while (!currentInput.equals("x")) {
            switch (currentInput) {
                case "1":
                    printAirplanes();
                    break;
                case "2":
                    printFlights();
                    break;
                case "3":
                    printAirplaneDetails();
                    break;
            }

            printFlightControlOptions();
            currentInput = userInput.nextLine();
        }
    }

    private void printFlightControlOptions() {
        System.out.println("Choose an action:");
        System.out.println("[1] Print airplanes");
        System.out.println("[2] Print flights");
        System.out.println("[3] Print airplane details");
        System.out.println("[x] Quit");
        System.out.print("> ");
    }

    private void printAirplanes() {
        flightManager.getAirplanes()
                .values().forEach(System.out::println);
    }

    private void printFlights() {
        flightManager.getFlights()
                .forEach(System.out::println);
    }

    private void printAirplaneDetails() {
        System.out.print("Give the airplane id: ");
        String airplaneID = userInput.nextLine();

        Airplane airplane = flightManager.getAirplanes().get(airplaneID);
        System.out.println(airplane);
    }
}
