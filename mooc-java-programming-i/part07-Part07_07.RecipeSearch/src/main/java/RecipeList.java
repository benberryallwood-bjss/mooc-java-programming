import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecipeList {
    private List<Recipe> recipes;

    public RecipeList(String fileName) {
        try (Scanner recipeFile = new Scanner(Paths.get(fileName))) {
            loadRecipeFromFile(recipeFile);
        } catch (Exception e) {
            throw new RecipeNotFoundException();
        }
    }

    private void loadRecipeFromFile(Scanner scanner) {
        recipes = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            int cookingTime = Integer.parseInt(scanner.nextLine());
            Recipe recipe = new Recipe(name, cookingTime);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) { break; }

                recipe.addIngredient(line);
            }

            recipes.add(recipe);
        }
    }

    public RecipeList() {
        recipes = new ArrayList<>();
    }

    public void add(Recipe recipe) {
        recipes.add(recipe);
    }

    public RecipeList search(String searchedWord) {
        RecipeList results = new RecipeList();
        for (Recipe recipe : recipes) {
            if (recipe.getName().contains(searchedWord)) {
                results.add(recipe);
            }
        }
        return results;
    }

    public RecipeList search(int maxCookingTime) {
        RecipeList results = new RecipeList();
        for (Recipe recipe : recipes) {
            if (recipe.getCookingTime() <= maxCookingTime) {
                results.add(recipe);
            }
        }
        return results;
    }

    public RecipeList searchIngredients(String ingredient) {
        RecipeList results = new RecipeList();
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
