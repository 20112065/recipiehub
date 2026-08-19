package controllers

import ie.setu.recipiehub.main.models.Recipe
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


import ie.setu.recipiehub.main.controllers.RecipeAPI

import org.junit.jupiter.api.Assertions.assertEquals



class RecipeAPITest {

    private var spaghettiBolegneise: Recipe? = null
    private var chips: Recipe? = null
    private var pizza: Recipe? = null
    private var cheeseToastie: Recipe? = null
    private var steak: Recipe? = null

    private var populatedRecipes: RecipeAPI? = RecipeAPI()
    private var emptyRecipes: RecipeAPI? = RecipeAPI()

@BeforeEach
fun setup(){
    spaghettiBolegneise = Recipe("Speghetti Bolegneise", "Speggethi 400g, meat 500g, tomatoes 100g", "Italian", "2 people", "1",false)
    chips= Recipe("chips ", "potatoes 100g, oil 500g", "irish", "2 people", "1", false)
    pizza= Recipe("pizza", "dough 700g, meat 500g, tomatoes 100g", "Italian", "5 people", "1", false)
    cheeseToastie= Recipe("cheeseToastie", "cheese 70g, bread 100g", "french", "1 people", "1", false)
    steak= Recipe("steak", "butter 100g, rosemary 5g, steak 400g", "american", "2 people", "1", false)

    //add the 5 recipes to recipeapi
    populatedRecipes!!.add(spaghettiBolegneise!!)
    populatedRecipes!!.add(chips!!)
    populatedRecipes!!.add(pizza!!)
    populatedRecipes!!.add(cheeseToastie!!)
    populatedRecipes!!.add(steak!!)
}
    @AfterEach
    fun tearDown(){
        spaghettiBolegneise = null
        chips = null
        pizza = null
        cheeseToastie = null
        steak = null
    }

    @Test
    fun `adding a recipe to populated  list adds to ArrayList`(){
        val newRecipe = Recipe("doughnut recipe", "dough", "baking", "2 people", "1", false)
         assertEquals(5, populatedRecipes!!.numberOfRecipes())
          assertTrue(populatedRecipes!!.add(newRecipe))
        assertEquals(6, populatedRecipes!!.numberOfRecipes())
        assertEquals(newRecipe, populatedRecipes!!.findRecipe(populatedRecipes!!.numberOfRecipes() - 1))

    }

    @Test
    fun `adding a recipe to an empty list adds to ArrayList`(){
        val newRecipe = Recipe("doughnut recipe", "dough", "baking", "2 people", "1", false)
        assertEquals(0, emptyRecipes!!.numberOfRecipes())
        assertTrue(emptyRecipes!!.add(newRecipe))
        assertEquals(1, emptyRecipes!!.numberOfRecipes())
        assertEquals(newRecipe, emptyRecipes!!.findRecipe(emptyRecipes!!.numberOfRecipes() - 1))

    }
}
