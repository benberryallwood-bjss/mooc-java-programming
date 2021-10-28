import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private BirdList birdList;

    public UserInterface(Scanner scanner, BirdList birdList) {
        this.scanner = scanner;
        this.birdList = birdList;
    }

    public void start() {
        while (true) {
            System.out.print("? ");
            String command = this.scanner.nextLine();

            switch (command) {
                case "Add":
                    add();
                    break;
                case "Observation":
                    observation();
                    break;
                case "All":
                    all();
                    break;
                case "One":
                    one();
                    break;
                case "Quit":
                    return;
            }
        }
    }

    private void add() {
        System.out.print("Name: ");
        String name = this.scanner.nextLine();

        System.out.print("Name in Latin: ");
        String latinName = this.scanner.nextLine();

        this.birdList.add(new Bird(name, latinName));
    }

    private void observation() {
        System.out.print("Bird? ");
        String birdName = this.scanner.nextLine();

        boolean isSuccessful = this.birdList.addObservation(birdName);
        if (!isSuccessful) {
            System.out.println("Not a bird!");
        }
    }

    private void all() {
        System.out.println(this.birdList);
    }

    private void one() {
        System.out.print("Bird? ");
        String birdName = this.scanner.nextLine();

        Bird bird = this.birdList.search(birdName);
        if (bird == null) {
            System.out.println("Not a bird!");
        } else {
            System.out.println(bird);
        }
    }
}
