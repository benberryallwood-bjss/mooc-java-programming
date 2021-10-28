
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        while (true) {
            int input = Integer.parseInt(scanner.nextLine());
            if (input == 0) {
                break;
            }

            if (input > 0) {
                numbers.add(input);
            }
        }

        if (numbers.isEmpty()) {
            System.out.println("Cannot calculate the average");
        } else {
            int sum = 0;
            for (int number : numbers) {
                sum += number;
            }
            System.out.println(1.0 * sum / numbers.size());
        }
    }
}
