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

    fun numberOfRecipes(): Int {
        return recipes.size
    }

    fun findRecipe(index: Int): Recipe? {
        return if (isValidListIndex(index, recipes)) {
            recipes[index]
        } else null
    }

    // Using a utility method to see if an index is valid in a list
    fun isValidListIndex(index: Int, list: List<Any>): Boolean {
        return (index >= 0) && (index < list.size)
    }

    fun listActiveRecipes(): String {
        return if (numberOfActiveRecipes() == 0) {
            "no active recipes stored"
        } else {
            var listOfActiveRecipes = ""
            for (i in recipes.indices) {
                if (recipes[i].isRecipeActive) {
                    listOfActiveRecipes += "${i}: ${recipes[i]} \n"
                }
            }
            listOfActiveRecipes
        }
    }

    fun listArchivedRecipes(): String {
        return if (numberOfArchivedRecipes() == 0) {
            "No archived Recipes Stored"
        } else {
            var listOfArchivedRecipes = ""
            for (i in recipes.indices) {
                if (recipes[i].isRecipeArchived) {
                    listOfArchivedRecipes += "${i}: ${recipes[i]} \n"
                }
            }
            listOfArchivedRecipes
        }
    }

    fun numberOfArchivedRecipes(): Int {
        return recipes.count { it.isRecipeArchived }
    }

    fun numberOfActiveRecipes(): Int {
        return recipes.count { it.isRecipeActive }
    }





    fun listRecipesBySelectedPriority(priority: Int): String {
        if (priority !in 1..5){return "Invalid priority level $priority. Priority must be between 1 and 5."
            }
        return if (numberOfRecipesByPriority(priority) == 0) {
            "no recipes stored with prority ${priority}"
        } else {
            var listOfRecipes = ""
            for (i in recipes.indices) {
                if (recipes[i].recipePriority == priority) {
                    listOfRecipes += "$i: ${recipes[i]}\n"
                }
            }
            listOfRecipes
        }
    }

    fun numberOfRecipesByPriority(priority: Int): Int {
        return recipes.count { it.recipePriority == priority }
    }
}