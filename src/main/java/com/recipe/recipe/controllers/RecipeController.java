package com.recipe.recipe.controllers;

import com.recipe.recipe.model.Recipe;
import com.recipe.recipe.service.RecipeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
@PostMapping
    public Recipe add(@RequestBody Recipe recipe) {
    return recipeService.add(recipe);
    }
    @GetMapping("/{id}")
    public Recipe get(@PathVariable long id) {
        return recipeService.get(id);
    }
}
