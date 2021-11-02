
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(line -> line.split(","))
                    .sorted((line1, line2) -> Double.compare(Double.parseDouble(line1[5].trim()), Double.parseDouble(line2[5].trim())))
                    .map(parts -> parts[3] + " (" + parts[4] + "), " + parts[2].trim().split(" ")[0] + ", " + parts[5])
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
    }
}
