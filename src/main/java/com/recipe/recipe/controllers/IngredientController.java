package com.recipe.recipe.controllers;

import com.recipe.recipe.model.Ingredient;
import com.recipe.recipe.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;


    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public Ingredient add(@RequestBody Ingredient ingredient) {
        return ingredientService.add(ingredient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> get(@PathVariable long id) {
        return ResponseEntity.of(ingredientService.get(id));
    }


    @DeleteMapping("/{id}")
    public Ingredient delete(@PathVariable long id) {
        return ingredientService.delete(id);
    }



}
