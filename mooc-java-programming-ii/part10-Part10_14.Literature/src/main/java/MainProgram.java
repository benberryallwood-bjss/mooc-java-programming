import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<AgeRatedBook> books = new ArrayList<>();
        Comparator<AgeRatedBook> ageRatedBookComparator = Comparator
                .comparing(AgeRatedBook::getAgeRecommendation)
                .thenComparing(AgeRatedBook::getName);

        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String name = scanner.nextLine();

            if (name.isEmpty()) {
                break;
            }

            System.out.print("Input the age recommendation: ");
            int ageRecomendation = Integer.parseInt(scanner.nextLine());

            books.add(new AgeRatedBook(name, ageRecomendation));
        }

        System.out.println(books.size() + " books in total.\n");
        System.out.println("Books:");
        books.stream()
                .sorted(ageRatedBookComparator)
                .forEach(System.out::println);
    }

}
