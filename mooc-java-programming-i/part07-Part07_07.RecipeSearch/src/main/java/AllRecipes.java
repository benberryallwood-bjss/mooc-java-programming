import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllRecipes {
    private List<Recipe> recipes;

    public AllRecipes(String fileName) {
        try (Scanner recipeFile = new Scanner(Paths.get(fileName))) {
            loadRecipesFromFile(recipeFile);
        } catch (Exception e) {
            throw new RecipeNotFoundException();
        }
    }

    private void loadRecipesFromFile(Scanner scanner) {
        recipes = new ArrayList<>();
        while (scanner.hasNextLine()) {
            Recipe recipe = new RecipeFileFormat().parse(scanner);

            recipes.add(recipe);
        }
    }

    public AllRecipes() {
        recipes = new ArrayList<>();
    }

    public void add(Recipe recipe) {
        recipes.add(recipe);
    }

    public AllRecipes search(String searchedWord) {
        AllRecipes results = new AllRecipes();
        for (Recipe recipe : recipes) {
            if (recipe.getName().contains(searchedWord)) {
                results.add(recipe);
            }
        }
        return results;
    }

    public AllRecipes search(int maxCookingTime) {
        AllRecipes results = new AllRecipes();
        for (Recipe recipe : recipes) {
            if (recipe.getCookingTime() <= maxCookingTime) {
                results.add(recipe);
            }
        }
        return results;
    }

    public AllRecipes searchIngredients(String ingredient) {
        AllRecipes results = new AllRecipes();
        for (Recipe recipe : recipes) {
            if (recipe.getIngredients().contains(ingredient)) {
                results.add(recipe);
            }
        }
        return results;
    }

    @Override
    public String toString() {
        String output = "\n";
        for (Recipe recipe : recipes) {
            output += recipe + "\n";
        }
        return output;
    }

}
