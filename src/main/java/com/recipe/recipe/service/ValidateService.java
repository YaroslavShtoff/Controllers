package com.recipe.recipe.service;

import com.recipe.recipe.model.Ingredient;
import com.recipe.recipe.model.Recipe;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class ValidateService {

    public boolean isNotValidate(Recipe recipe) {
        boolean result = org.apache.commons.lang3.StringUtils.isBlank(recipe.getTitle()) ||
                CollectionUtils.isEmpty(recipe.getIngredients()) ||
                CollectionUtils.isEmpty(recipe.getSteps()) ||
                recipe.getCookingTime() <= 0;
        if (!result) {
            for (Ingredient ingredient : recipe.getIngredients()) {
                result = result || isNotValidate(ingredient);
            }
        }
        return result;
    }

    public boolean isNotValidate(Ingredient ingredient) {
        return !org.apache.commons.lang3.StringUtils.isBlank(ingredient.getTitle()) ||
                !org.apache.commons.lang3.StringUtils.isBlank(ingredient.getMeasureUnit()) ||
                ingredient.getAmount() <= 0;

    }

}

