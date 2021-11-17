package application;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }

            // implement the functionality here
            switch (command) {
                case "1":
                    list();
                    break;
                case "2":
                    add();
                    break;
                case "3":
                    markAsDone();
                    break;
                case "4":
                    remove();
                    break;
            }
        }

        System.out.println("Thank you!");
    }

    private void list() {
        System.out.println("Listing the database contents");
        try {
            database.list().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void add() {
        System.out.println("Adding a new todo");
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter description");
        String description = scanner.nextLine();
        try {
            database.add(new Todo(name, description, false));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void markAsDone() {
        System.out.println("Which todo should be marked as done (give the id)?");
        int idToMarkAsDone = Integer.parseInt(scanner.nextLine());
        try {
            database.markAsDone(idToMarkAsDone);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void remove() {
        System.out.println("Which todo should be removed (give the id)?");
        int idToRemove = Integer.parseInt(scanner.nextLine());
        try {
            database.remove(idToRemove);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
