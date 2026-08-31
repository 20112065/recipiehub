package ie.setu.recipiehub.main.models

data class Recipe(
    var recipeTitle: String,
    var recipeIngredient: String,
    var recipeCategory: String,
    var recipeServingSize: String,
    var recipeSpiceLevel: String,
    var isRecipeArchived: Boolean = true,
    var isRecipeActive: Boolean = false,
    var recipePriority: Int = 1,
)
