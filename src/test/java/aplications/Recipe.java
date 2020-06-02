package aplications;

import java.util.List;

public class Recipe {
    public String recipeName;
    public Ingredient [] ingredient;
    public int prepTime;

    public Recipe(String recipeName, Ingredient[] ingredient, int prepTime) {
        this.recipeName = recipeName;
        this.ingredient = ingredient;
        this.prepTime = prepTime;
    }


    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setIngredient(Ingredient[] ingredient) {
        this.ingredient = ingredient;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public Ingredient[] getIngredient() {
        return ingredient;
    }

    public int getPrepTime() {
        return prepTime;
    }
}

