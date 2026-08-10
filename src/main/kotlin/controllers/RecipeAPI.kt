package ie.setu.recipiehub.main.controllers

import ie.setu.recipiehub.main.models.Recipe

class RecipeAPI {
    private var recipes = ArrayList<Recipe>()
    fun add(recipe: Recipe): Boolean {
        return recipes.add(recipe)
    }

    fun listAllRecipes(): String {
        return if (recipes.isEmpty()) {
            "No Recipes Stored"
        } else {
            var listOfRecipes = ""
            for (i in recipes.indices) {
                listOfRecipes += "${i}: ${recipes[i]} \n"
            }
            listOfRecipes
        }
    }
}