package aplications;

import java.util.List;

public class Recipe {
    public String recipename;
    public Ingredient [] ingredient;
    public int preptime;

    public Recipe(String recipename, Ingredient[] ingredient, int preptime) {
        this.recipename = recipename;
        this.ingredient = ingredient;
        this.preptime = preptime;
    }


    public void setRecipename(String recipename) {
        this.recipename = recipename;
    }

    public void setIngredient(Ingredient[] ingredient) {
        this.ingredient = ingredient;
    }

    public void setPreptime(int preptime) {
        this.preptime = preptime;
    }

    public String getRecipename() {
        return recipename;
    }

    public Ingredient[] getIngredient() {
        return ingredient;
    }

    public int getPreptime() {
        return preptime;
    }
}

