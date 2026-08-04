package ie.setu.recipiehub.main

import java.lang.System.exit
import ie.setu.recipiehub.main.utils.readIntNotNull
import ie.setu.recipiehub.main.utils.readNextInt
import ie.setu.recipiehub.main.utils.readNextDouble
import ie.setu.recipiehub.main.utils.readNextFloat



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
               |   |4. Scale your recipie for more or less quantity              |           
               |                                                                 |            
               |-----------------------------------------------------------------|           
               |   |0. Exit                                                      |       
               ___________________________________________________________________
               """.trimMargin(">"))
        return readNextInt(" > ==>>")
    }

    fun runMenu(){
        do{
            val option = mainMenu()
             when (option){
                 1 -> addRecipe()
                 2 -> viewRecipe()
                 3 -> delRecipe()
                 4 -> scaleRecipe()
                 else -> println("Oops! You chose an invalid option: ${option}")
             }
        } while(true)
    }


    fun addRecipe(){
        println("you chose add a recipe!")
    }

    fun viewRecipe(){
        println("you chose view a recipe")
    }

    fun delRecipe(){
        println("you chose delete a recipe")
    }

    fun scaleRecipe(){
        println("you chose scale a recipe")
    }

    fun exitApp(){
        println("you are now exiting the app, goodbye!")
        exit(0)
    }

    fun main() {
        runMenu()
    }

