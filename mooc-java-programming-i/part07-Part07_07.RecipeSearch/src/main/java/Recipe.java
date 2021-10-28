import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String name;
    private int cookingTime;
    private List<String> ingredients;

    public Recipe(String name, int cookingTime) {
        this.name = name;
        this.cookingTime = cookingTime;
        ingredients = new ArrayList<>();
    }

    public void addIngredient(String ingredient) {
        ingredients.add(ingredient);
    }

    public String getName() {
        return name;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return name + ", cooking time: " + cookingTime;
    }
}
