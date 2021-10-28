
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("File:");
        String fileName = scan.nextLine();

        System.out.println("Team:");
        String teamName = scan.nextLine();

        int gamesPlayed = 0;
        int gamesWon = 0;
        int gamesLost = 0;

        try (Scanner fileScanner = new Scanner(Paths.get(fileName))) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                String team1 = parts[0];
                String team2 = parts[1];
                int score1 = Integer.parseInt(parts[2]);
                int score2 = Integer.parseInt(parts[3]);

                if (team1.equals(teamName)) {
                    gamesPlayed++;
                    if (score1 > score2) {
                        gamesWon++;
                    } else {
                        gamesLost++;
                    }
                }
                if (team2.equals(teamName)) {
                    gamesPlayed++;
                    if (score2 > score1) {
                        gamesWon++;
                    } else {
                        gamesLost++;
                    }
                }
            }

            System.out.println("Games: " + gamesPlayed);
            System.out.println("Wins: " + gamesWon);
            System.out.println("Losses: " + gamesLost);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



}
