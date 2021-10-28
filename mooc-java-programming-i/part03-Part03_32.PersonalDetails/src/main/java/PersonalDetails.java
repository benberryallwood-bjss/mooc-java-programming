
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sumOfYears = 0;
        int numOfYears = 0;
        int lengthOfLongestName = -1;
        String longestName = "";

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }

            String[] parts = input.split(",");
            sumOfYears += Integer.valueOf(parts[0]);
            numOfYears++;

            if (parts[0].length() > lengthOfLongestName) {
                lengthOfLongestName = parts[0].length();
                longestName = parts[0];
            }
        }

        System.out.println("Longest name: " + longestName);
        System.out.println("Average of the birth years: " + (1.0 * sumOfYears / numOfYears));

    }
}
