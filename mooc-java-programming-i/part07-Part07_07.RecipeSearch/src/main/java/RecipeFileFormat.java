import java.util.Scanner;

public class RecipeFileFormat {
    public Recipe parse(Scanner scanner) {
        String name = scanner.nextLine();
        int cookingTime = Integer.parseInt(scanner.nextLine());
        Recipe recipe = new Recipe(name, cookingTime);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) { break; }

            recipe.addIngredient(line);
        }
        return recipe;
    }
}
