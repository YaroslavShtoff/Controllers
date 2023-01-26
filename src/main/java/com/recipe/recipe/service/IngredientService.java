package com.recipe.recipe.service;

import com.recipe.recipe.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientService {
    private final Map<Long, Ingredient> ingredients = new HashMap<>();
    private long idGenerator = 1;

    public Ingredient add(Ingredient ingredient) {
        ingredients.put(idGenerator++, ingredient);
        return ingredient;
    }
    public Ingredient get(long id) {
        return ingredients.get(id);
    }

}
