import java.util.Scanner;

public class UserInterface {
    private TodoList list;
    private Scanner scanner;

    public UserInterface(TodoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.print("Command: ");
            String command = this.scanner.nextLine();

            if (command.equals("stop")) {
                return;
            }

            if (command.equals("add")) {
                System.out.print("To add: ");
                String toAdd = this.scanner.nextLine();

                this.list.add(toAdd);
            }

            if (command.equals("list")) {
                this.list.print();
            }

            if (command.equals("remove")) {
                System.out.print("Which one is removed? ");
                int toRemove = Integer.parseInt(this.scanner.nextLine());

                this.list.remove(toRemove);
            }
        }
    }
}
