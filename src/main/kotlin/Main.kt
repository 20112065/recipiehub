package ie.setu.recipiehub.main

import ie.setu.recipiehub.main.controllers.RecipeAPI
import java.lang.System.exit
import ie.setu.recipiehub.main.utils.readNextInt
import ie.setu.recipiehub.main.utils.readNextLine
import ie.setu.recipiehub.main.models.Recipe
import io.github.oshai.kotlinlogging.KotlinLogging

fun mainMenu() : Int {
    println(
        """___________________________________________________________________
           |                                                                 |
           |                     Welcome to RecipieHub                       |
           |                                                                 |
           ___________________________________________________________________
           |                                                                 |
           | Hi! Im your cooking app.                                        |
           |                                                                 |
           | If you'd like help with your delicous recipies..                |
           |                                                                 |
           | Choose from the following options:                              |
           |   |-------------------------------------------------            |
           |   |1. Add a recipie                                             |
           |   |2. View recipies                                             |
           |   |3. Delete a recipie                                          |
           |   |4. Scale your recipie for more or less quantity              |
           |   |5. Update a recipie                                          |
           |                                                                 |
           |-----------------------------------------------------------------|
           |   |0. Exit                                                      |
           ___________________________________________________________________
           """.trimMargin(">"))
    return readNextInt(" > ==>>")
}
//run menu
fun runMenu(){
    do{
        val option = mainMenu()

        when (option){
            1 -> addRecipe()
            2 -> viewRecipe()
            3 -> delRecipe()
            4 -> scaleRecipe()
            5 -> updateRecipe()
            else -> println("Oops! You chose an invalid option: ${option}")
        }
    } while(true)
}

fun addRecipe(){
    val recipeTitle = readNextLine("Enter the name of the new recipe you would like to create")
    val recipeIngredient = readNextLine("Enter the Ingredients and the size in grams or ml")
    val recipeCategory = readNextLine("Enter the Type of Cuisine yoyr recipe is from, eg. 'Italian', 'Chinese'")
    val recipeServingSize: String = readNextLine("Please enter the Serving size of your recipe in persons, eg. 4 = persons")
    val recipeSpiceLevel = readNextLine("Please enter the Spice level of your recipe from a sclae of 1-5, 5 being the spiciest")
    val isAdded = RecipeAPI.add(Recipe(recipeTitle, recipeIngredient, recipeCategory, recipeServingSize, recipeSpiceLevel, false, isRecipeActive = true ))

    if (isAdded) {
        println("Successfully added a new recipe called ${recipeTitle}")
    } else {
        println("The adding of your recipe has failed, please try again")
    }
}

fun viewRecipe(){
    println(RecipeAPI.listAllRecipes())
    println(RecipeAPI.listActiveRecipes())
    println(RecipeAPI.listArchivedRecipes())
}

fun delRecipe(){
    //logger.info { "delRecipe() function invoked" }
    viewRecipe()
    if (RecipeAPI.numberOfRecipes()>0){
        //only asking the user to choose a recipie they can delete if the recipe exists
        val indextToDelete = readNextInt("Please enter the index of the recipe you would like to delete: ")
        val recipeToDelete = RecipeAPI.deleteRecipe(indextToDelete)
        if (recipeToDelete != null) {
            println("Your Delete Successful! Deleted Recipe: ${recipeToDelete.recipeTitle}")
        } else {
            println("The Delete was NOT Successful, please try again")
        }
    }
}

fun scaleRecipe(){
    logger.info { " scaleRecipe() function invoked" }
}

fun updateRecipe() {
    //logger.info { "updateRecipes() function invoked" }
    viewRecipe()
    if (RecipeAPI.numberOfRecipes() > 0) {
        val indexToUpdate = readNextInt("Enter the index of the recipe to update: ")
        if (RecipeAPI.isValidIndex(indexToUpdate)) {
            val recipeTitle = readNextLine("Enter a title for the recipe: ")
            val recipePriority = readNextInt("Enter a priority (1-low, 2, 3, 4, 5-high): ")
            val recipeCategory = readNextLine("Enter a category for the recipe: ")

            if (RecipeAPI.updateRecipe(indexToUpdate, Recipe(recipeTitle, "", recipeCategory, "", "", recipePriority = recipePriority))){
                println("Update Successful")
            } else {
                println("Update Failed")
            }
        } else {
            println("There are no recipes for this index number")
        }
    }
}

fun exitApp(){
    println("you are now exiting the app, goodbye!")
    exit(0)
}

private val logger = KotlinLogging.logger {}
private val RecipeAPI = RecipeAPI()

fun main() {
    runMenu()
}