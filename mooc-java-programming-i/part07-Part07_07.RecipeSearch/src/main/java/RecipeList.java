import java.util.ArrayList;
import java.util.Scanner;

public class RecipeList {
    private ArrayList<Recipe> recipes;

    public RecipeList(Scanner scanner) {
        this.recipes = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            int cookingTime = Integer.parseInt(scanner.nextLine());
            Recipe recipe = new Recipe(name, cookingTime);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) { break; }

                recipe.addIngredient(line);
            }

            this.recipes.add(recipe);
        }
    }

    public RecipeList() {
        this.recipes = new ArrayList<>();
    }

    public void add(Recipe recipe) {
        this.recipes.add(recipe);
    }

    public RecipeList search(String searchedWord) {
        RecipeList results = new RecipeList();
        for (Recipe recipe : this.recipes) {
            if (recipe.getName().contains(searchedWord)) {
                results.add(recipe);
            }
        }
        return results;
    }

    public RecipeList search(int maxCookingTime) {
        RecipeList results = new RecipeList();
        for (Recipe recipe : this.recipes) {
            if (recipe.getCookingTime() <= maxCookingTime) {
                results.add(recipe);
            }
        }
        return results;
    }

    public RecipeList searchIngredients(String ingredient) {
        RecipeList results = new RecipeList();
        for (Recipe recipe : this.recipes) {
            if (recipe.getIngredients().contains(ingredient)) {
                results.add(recipe);
            }
        }
        return results;
    }

    public String toString() {
        String output = "\n";
        for (Recipe recipe : recipes) {
            output += recipe + "\n";
        }
        return output;
    }

}
