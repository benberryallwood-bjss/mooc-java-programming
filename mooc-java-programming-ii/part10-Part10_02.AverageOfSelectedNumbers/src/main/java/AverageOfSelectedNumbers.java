
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();

        System.out.println("Input numbers, type \"end\" to stop.");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }

            inputs.add(input);
        }

        System.out.println("\nPrint the average of the negative numbers or the positive numbers? (n/p)");
        String userChoice = scanner.nextLine();

        switch (userChoice) {
            case "p":
                double averageOfPositives = inputs.stream()
                        .mapToInt(num -> Integer.parseInt(num))
                        .filter(num -> num > 0)
                        .average()
                        .getAsDouble();
                System.out.println("Average of the positive numbers: " + averageOfPositives);
                break;
            case "n":
                double averageOfNegatives = inputs.stream()
                        .mapToInt(num -> Integer.parseInt(num))
                        .filter(num -> num < 0)
                        .average()
                        .getAsDouble();
                System.out.println("Average of the negative numbers: " + averageOfNegatives);
                break;
        }
    }

}
