package com.recipe.recipe.controllers;

import com.recipe.recipe.model.Ingredient;
import com.recipe.recipe.model.Recipe;
import com.recipe.recipe.service.IngredientService;
import com.recipe.recipe.service.ValidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;
    private final ValidateService validateService;



    public IngredientController(IngredientService ingredientService, ValidateService validateService) {

        this.ingredientService = ingredientService;
        this.validateService = validateService;
    }
    @PostMapping
    public ResponseEntity<Ingredient > add(@RequestBody Ingredient ingredient) {
      if(!validateService.isNotValidate(ingredient))
          return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(ingredientService.add(ingredient));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> get(@PathVariable long id) {
        return ResponseEntity.of(ingredientService.get(id));
    }

    @PutMapping("/id")
    public ResponseEntity<Ingredient> update(@PathVariable long id, @RequestBody Ingredient ingredient) {
        if(!validateService.isNotValidate(ingredient))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(ingredientService.add(ingredient));
    }

    @DeleteMapping("/id ")
    public ResponseEntity<Ingredient> delete(@PathVariable long id, @RequestBody Ingredient ingredient) {
        return ResponseEntity.of(ingredientService.delete(id));
    }

    @GetMapping
    public Map<Long, Ingredient> getAll() {
        return ingredientService.getAll();
    }

}
