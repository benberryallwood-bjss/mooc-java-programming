import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private AllRecipes recipeList;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        selectRecipes();
        printCommands();

        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "list":
                    list();
                    break;
                case "find name":
                    findName();
                    break;
                case "find cooking time":
                    findCookingTime();
                    break;
                case "find ingredient":
                    findIngredient();
                    break;
                case "stop":
                    return;
            }
        }
    }

    private void selectRecipes() {
        System.out.print("File to read: ");
        String fileName = this.scanner.nextLine();

        try {
            recipeList = new AllRecipes(fileName);
        } catch(RecipeNotFoundException rnfe) {
            System.out.println("Error: File not found: " + fileName);
        }
    }

    private void printCommands() {
        System.out.println("\n"
            + "Commands:\n"
            + "list - lists the recipes\n"
            + "stop - stops the program\n"
            + "find name - searches recipes by name\n"
            + "find cooking time - searches recipes by cooking time\n"
            + "find ingredient - searches recipes by ingredient\n");
    }

    private void list() {
        System.out.println(recipeList);
    }

    private void findName() {
        System.out.print("Searched word: ");
        String searchedWord = this.scanner.nextLine();
        AllRecipes results = this.recipeList.search(searchedWord);

        System.out.println(results);
    }

    private void findCookingTime() {
        System.out.print("Max cooking time: ");
        int maxCookingTime = Integer.parseInt(this.scanner.nextLine());
        AllRecipes results = this.recipeList.search(maxCookingTime);

        System.out.println(results);
    }

    private void findIngredient() {
        System.out.print("Ingredient: ");
        String ingredient = this.scanner.nextLine();
        AllRecipes results = this.recipeList.searchIngredients(ingredient);

        System.out.println(results);
    }
}
