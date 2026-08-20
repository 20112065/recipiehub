package ie.setu.recipiehub.main.models


data class Recipe(
    val recipeTitle: String,
    val recipeIngredient: String,
    val recipeCategory: String,
    val recipeServingSize: String,
    val recipeSpiceLevel: String,
    val isRecipeArchived: Boolean= true,
    val isRecipeActive: Boolean = false,
)

