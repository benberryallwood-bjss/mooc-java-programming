import java.util.Scanner;

public class UserInterface {
    private Points points;
    private Scanner scanner;

    public UserInterface(Points points, Scanner scanner) {
        this.points = points;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Enter point totals, -1 stops:");

        while (true) {
            int input = Integer.parseInt(scanner.nextLine());
            if (input == -1) { break; }

            points.add(input);
        }

        System.out.println("Point average (all): " + points.average());
        System.out.println("Point average (passing): " +
                (points.averagePassing() == -1 ? "-" : points.averagePassing()));
        System.out.println("Pass percentage: " + points.passPercentage());

        System.out.println("Grade distribution:");
        System.out.print(points.gradeDistribution());
    }
}
