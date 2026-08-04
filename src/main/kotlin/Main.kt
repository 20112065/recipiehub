package ie.setu.recipiehub.main

import java.lang.System.exit
import ie.setu.recipiehub.main.utils.readIntNotNull
import ie.setu.recipiehub.main.utils.readNextInt
import ie.setu.recipiehub.main.utils.readNextDouble
import ie.setu.recipiehub.main.utils.readNextFloat
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
        logger.info { "addRecipe() function invoked" }

    }

    fun viewRecipe(){
        logger.info { "viewRecipe() function invoked" }
    }

    fun delRecipe(){
        logger.info { "delRecipe() function invoked" }
    }

    fun scaleRecipe(){
        logger.info { " scaleRecipe() function invoked" }
    }

    fun exitApp(){
        println("you are now exiting the app, goodbye!")
        exit(0)
    }


private val logger = KotlinLogging.logger {}
    fun main() {
        runMenu()
    }

