package com.recipe.recipe.controllers;

import com.recipe.recipe.model.Ingredient;
import com.recipe.recipe.service.IngredientService;
import com.recipe.recipe.service.ValidateService;
import com.sun.beans.introspect.PropertyInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Tag(name = "IngredientController", description = "API для рецептов")
@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;
    private final ValidateService validateService;
    @Operation(summary = "добавление рецепта", description = "добавление рецепта")
    @ApiResponses({
              @ApiResponse(responseCode = "200", description = "Добавление прошло успешно"),
              @ApiResponse(responseCode = "400", description = "Некорректные параметры рецепта"),
    })

    @PostMapping
    public ResponseEntity<Ingredient > add(@RequestBody Ingredient ingredient) {
        if(validateService.isNotValidate(ingredient))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(ingredientService.add(ingredient));
    }


    public IngredientController(IngredientService ingredientService, ValidateService validateService) {

        this.ingredientService = ingredientService;
        this.validateService = validateService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> get(@PathVariable long id) {
        return ResponseEntity.of(ingredientService.get(id));
    }

    @PutMapping("/id")
    public ResponseEntity<Ingredient> update(@PathVariable long id, @RequestBody Ingredient ingredient) {
        if(validateService.isNotValidate(ingredient))
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
