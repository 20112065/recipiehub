package controllers


import ie.setu.recipiehub.main.controllers.RecipeAPI
import ie.setu.recipiehub.main.models.Recipe
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test


class RecipeAPITest {

    private var spaghettiBolegneise: Recipe? = null
    private var chips: Recipe? = null
    private var pizza: Recipe? = null
    private var cheeseToastie: Recipe? = null
    private var steak: Recipe? = null

    private var populatedRecipes: RecipeAPI? = RecipeAPI()
    private var emptyRecipes: RecipeAPI? = RecipeAPI()

    @BeforeEach
    fun setup() {
        spaghettiBolegneise = Recipe(
            "Speghetti Bolegneise",
            "Speggethi 400g, meat 500g, tomatoes 100g",
            "Italian",
            "2 people",
            "1",
            isRecipeArchived = false,
            isRecipeActive = true
        )
        chips = Recipe("chips ", "potatoes 100g, oil 500g", "irish", "2 people", "1", isRecipeArchived = true,  isRecipeActive = false)
        pizza = Recipe("pizza", "dough 700g, meat 500g, tomatoes 100g", "Italian", "5 people", "1", isRecipeArchived = true,
            isRecipeActive = false)
        cheeseToastie = Recipe("cheeseToastie", "cheese 70g, bread 100g", "french", "1 people", "1", isRecipeArchived = false,
            isRecipeActive = true)
        steak = Recipe("steak", "butter 100g, rosemary 5g, steak 400g", "american", "2 people", "1", isRecipeArchived = false,
            isRecipeActive = true)

        //add the 5 recipes to recipeapi
        populatedRecipes!!.add(spaghettiBolegneise!!)
        populatedRecipes!!.add(chips!!)
        populatedRecipes!!.add(pizza!!)
        populatedRecipes!!.add(cheeseToastie!!)
        populatedRecipes!!.add(steak!!)
    }

    @AfterEach
    fun tearDown() {
        spaghettiBolegneise = null
        chips = null
        pizza = null
        cheeseToastie = null
        steak = null
    }

    @Nested
    inner class AddRecipes {
        @Test
        fun `adding a recipe to populated  list adds to ArrayList`() {
            val newRecipe = Recipe("doughnut recipe", "dough", "baking", "2 people", "1", false, true)
            assertEquals(5, populatedRecipes!!.numberOfRecipes())
            assertTrue(populatedRecipes!!.add(newRecipe))
            assertEquals(6, populatedRecipes!!.numberOfRecipes())
            assertEquals(newRecipe, populatedRecipes!!.findRecipe(populatedRecipes!!.numberOfRecipes() - 1))

        }

        @Test
        fun `adding a recipe to an empty list adds to ArrayList`() {
            val newRecipe = Recipe("doughnut recipe", "dough", "baking", "2 people", "1", false, true)
            assertEquals(0, emptyRecipes!!.numberOfRecipes())
            assertTrue(emptyRecipes!!.add(newRecipe))
            assertEquals(1, emptyRecipes!!.numberOfRecipes())
            assertEquals(newRecipe, emptyRecipes!!.findRecipe(emptyRecipes!!.numberOfRecipes() - 1))

        }
    }


    @Nested
    inner class ListRecipes {

        @Test
        fun `listAllRecipes returns No Recipes Stored message when ArrayList is empty`() {
            assertEquals(0, emptyRecipes!!.numberOfRecipes())
            assertTrue(emptyRecipes!!.listAllRecipes().lowercase().contains("no recipes"))
        }

        @Test
        fun `listAllRecipes returns Recipes  when ArrayList has Recipes stored`() {
            assertEquals(5, populatedRecipes!!.numberOfRecipes())
            val recipesString = populatedRecipes!!.listAllRecipes().lowercase()
            assertTrue(recipesString.contains("speghetti bolegneise"))
            assertTrue(recipesString.contains("chips"))
            assertTrue(recipesString.contains("pizza"))
            assertTrue(recipesString.contains("steak"))
        }
    }


    @Nested
    inner class listActiveRecipes() {
        //empty?
        @Test
        fun `listActiveRecipes returns No Recipes Stored message when ArrayList is empty`() {
            assertEquals(0, emptyRecipes!!.numberOfActiveRecipes())
            assertTrue(emptyRecipes!!.listActiveRecipes().lowercase().contains( "no active recipes stored"))
        }

        @Test
        fun `listActiveRecipes returns Recipes  when ArrayList has  active Recipes stored`() {
            assertEquals(3, populatedRecipes!!.numberOfActiveRecipes())
            val recipesString = populatedRecipes!!.listActiveRecipes().lowercase()
            assertTrue(recipesString.contains("speghetti bolegneise"))
            assertTrue(recipesString.contains("steak"))
            assertTrue(recipesString.contains("cheesetoastie"))
            assertTrue(!recipesString.contains("chips"))
            assertTrue(!recipesString.contains("pizza"))
        }
    }


    @Nested
    inner class listArchivedRecipes(){
        //empty?
        @Test
        fun `listArchivedRecipes returns No archived Recipes Stored message when ArrayList is empty`() {
            assertEquals(0, emptyRecipes!!.numberOfRecipes())
            assertTrue(emptyRecipes!!.listArchivedRecipes().lowercase().contains("no archived recipes stored"))
        }

        @Test
        fun `listArchivedRecipes returns Recipes  when ArrayList has  active Recipes stored`() {
            assertEquals(2, populatedRecipes!!.numberOfArchivedRecipes())
            val recipesString = populatedRecipes!!.listArchivedRecipes().lowercase()

            assertTrue(recipesString.contains("chips"))
            assertTrue(recipesString.contains("pizza"))
            assertTrue(!recipesString.contains("speghetti bolegneise"))
            assertTrue(!recipesString.contains("steak"))
            assertTrue(!recipesString.contains("cheesetoastie"))

        }
    }
}

