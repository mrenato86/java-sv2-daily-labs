package day02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class RecipeTest {

    @Test
    void testCreateOneParameter() {
        Recipe recipe = new Recipe("A recipe");
        assertEquals("A recipe", recipe.getName());
        assertEquals(0, recipe.getIngredients().size());
        assertNull(recipe.getDescription());
    }

    @Test
    void testCreateTwoParameter() {
        Recipe recipe = new Recipe("A recipe", "A long description for this recipe");
        assertEquals("A recipe", recipe.getName());
        assertEquals(0, recipe.getIngredients().size());
        assertEquals("A long description for this recipe", recipe.getDescription());
    }

    @Test
    void testAddIngredientOneAdded() {
        Recipe recipe = new Recipe("A recipe", "A long description for this recipe");
        recipe.addIngredient("First Ingredient");
        assertEquals(1, recipe.getIngredients().size());
        assertEquals("First Ingredient", recipe.getIngredients().get(0));
    }

    @Test
    void testAddIngredientMoreAdded() {
        Recipe recipe = new Recipe("A recipe", "A long description for this recipe");
        recipe.addIngredient("First Ingredient", "Second", "Third");
        List<String> expected = List.of("First Ingredient", "Second", "Third");

        assertEquals(expected, recipe.getIngredients());
    }

}