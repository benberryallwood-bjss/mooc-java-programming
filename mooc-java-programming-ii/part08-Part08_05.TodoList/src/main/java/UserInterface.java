import java.util.Scanner;

public class UserInterface {
    private TodoList todoList;
    private Scanner scanner;

    public UserInterface(TodoList todoList, Scanner scanner) {
        this.todoList = todoList;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.print("Command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "add":
                    add();
                    break;
                case "list":
                    list();
                    break;
                case "remove":
                    remove();
                    break;
                case "stop":
                    return;
            }
        }
    }

    private void add() {
        System.out.print("To add: ");
        String newTask = scanner.nextLine();
        todoList.add(newTask);
    }

    private void list() {
        todoList.print();
    }

    private void remove() {
        System.out.print("Which one is removed? ");
        int numToRemove = Integer.parseInt(scanner.nextLine());
        todoList.remove(numToRemove);
    }
}
