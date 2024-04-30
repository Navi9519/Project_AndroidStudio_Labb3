package com.navi9519.labb_3_cocktail_app.model.database.cocktail

import com.navi9519.labb_3_cocktail_app.model.database.MyDatabase
import com.navi9519.labb_3_cocktail_app.model.database.user.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CocktailRepository (
    private val myDatabase: MyDatabase,
    private val coroutineScope: CoroutineScope
) {

    // SAVE COCKTAIL
    fun insertOrUpdateCocktail(cocktail: Cocktail) {
        myDatabase.cocktailDao().insertOrUpdateCocktail(cocktail)
    }

    // Delete COCKTAIL
    fun deleteCocktail(cocktail: Cocktail) {
        myDatabase.cocktailDao().deleteCocktails(cocktail)
    }

    fun findAllCocktails(): Flow<List<Cocktail>> {
        return myDatabase.cocktailDao().findAllCocktails()
    }

    // Handle Thread Operations
    fun performDatabaseOperation(dispatcher: CoroutineDispatcher, databaseOperation: suspend () -> Unit) {
        coroutineScope.launch(dispatcher) {
            databaseOperation()
        }
    }
}