import java.util.Scanner;

public class TextUI {
    private Scanner scanner;
    private SimpleDictionary dictionary;

    public TextUI(Scanner scanner, SimpleDictionary dictionary) {
        this.scanner = scanner;
        this.dictionary = dictionary;
    }

    public void start() {
        while (true) {
            System.out.print("Command: ");
            String command = this.scanner.nextLine();

            if (command.equals("end")) {
                System.out.println("Bye bye!");
                return;
            }

            if (command.equals("add")) {
                System.out.print("Word: ");
                String word = this.scanner.nextLine();
                System.out.print("Translation: ");
                String translation = this.scanner.nextLine();

                this.dictionary.add(word, translation);
                continue;
            }

            if (command.equals("search")) {
                System.out.print("To be translated: ");
                String word = this.scanner.nextLine();
                String translation = this.dictionary.translate(word);

                if (translation == null) {
                    System.out.println("Word " + word + " was not found");
                    continue;
                }

                System.out.println("Translation: " + translation);
                continue;
            }

            System.out.println("Unknown command");
        }
    }
}
