package ie.setu.recipiehub.main.controllers

import ie.setu.recipiehub.main.models.Recipe

/**
 * This class manages a list of recipes and provides functionality for adding, updating, deleting,
 * and filtering recipes.
 *
 * @property recipes An ArrayList of [Recipe] objects, used to store all the recipes in memory.
 */
class RecipeAPI {
    private var recipes = ArrayList<Recipe>()

    /**
     * Adds a new [Recipe] to the list.
     *
     * @param recipe The [Recipe] to be added.
     * @return `true` if the recipe was successfully added, `false` otherwise.
     */
    fun add(recipe: Recipe): Boolean {
        return recipes.add(recipe)
    }

    fun listAllRecipes(): String {
        return if (recipes.isEmpty()) {
            "No Recipes Stored"
        } else {
            var listOfRecipes = ""
            for (i in recipes.indices) {
                listOfRecipes += "$i: ${recipes[i]} \n"
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
        } else {
            null
        }
    }

    fun isValidListIndex(
        index: Int,
        list: List<Any>,
    ): Boolean {
        return (index >= 0) && (index < list.size)
    }

    fun listActiveRecipes(): String {
        return if (numberOfActiveRecipes() == 0) {
            "no active recipes stored"
        } else {
            var listOfActiveRecipes = ""
            for (i in recipes.indices) {
                if (recipes[i].isRecipeActive) {
                    listOfActiveRecipes += "$i: ${recipes[i]} \n"
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
                    listOfArchivedRecipes += "$i: ${recipes[i]} \n"
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
        if (priority !in 1..5) {
            return "Invalid priority level $priority. Priority must be between 1 and 5."
        }
        return if (numberOfRecipesByPriority(priority) == 0) {
            "no recipes stored with prority $priority"
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

    fun deleteRecipe(indexToDelete: Int): Recipe? {
        return if (isValidListIndex(indexToDelete, recipes)) {
            recipes.removeAt(indexToDelete)
        } else {
            null
        }
    }

    fun isValidIndex(index: Int): Boolean {
        return isValidListIndex(index, recipes)
    }

    fun updateRecipe(
        indexToUpdate: Int,
        recipe: Recipe?,
    ): Boolean {
        // find the recipe object by the index number
        val foundRecipe = findRecipe(indexToUpdate)

        // IF THE RECIPE EXISTS USE THE RECIPE DETAILS AS A PARAMETER TO UPDATE THE RECIPE YOU FOUND IN THE ARRAYLIST
        if ((foundRecipe != null) && (recipe != null)) {
            foundRecipe.recipeTitle = recipe.recipeTitle
            foundRecipe.recipePriority = recipe.recipePriority
            foundRecipe.recipeCategory = recipe.recipeCategory
            return true
        }

        // if the recipe was not found, return false, indicating that the update was not successful
        return false
    }

    fun scaleRecipe(
        indexToScale: Int,
        scaleFactor: Double,
    ): Recipe? {
        // find the recipe object by the index number
        val foundRecipe = findRecipe(indexToScale)

        // if the recipe exists, work out the new serving size by scaling the current one
        if (foundRecipe != null) {
            val currentServings = foundRecipe.recipeServingSize.split(" ")[0].toIntOrNull()
            if (currentServings != null) {
                val newServings = (currentServings * scaleFactor).toInt()
                foundRecipe.recipeServingSize = "$newServings people"
                return foundRecipe
            }
        }

        // if the recipe was not found, or its serving size couldn't be read as a number, return null
        return null
    }
}
