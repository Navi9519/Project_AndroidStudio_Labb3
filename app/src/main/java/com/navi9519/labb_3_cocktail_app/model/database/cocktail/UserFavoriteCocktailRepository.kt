package com.navi9519.labb_3_cocktail_app.model.database.cocktail

/*
import com.navi9519.labb_3_cocktail_app.model.database.MyDatabase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class UserFavoriteCocktailRepository(
    private val myDatabase: MyDatabase,
    private val coroutineScope: CoroutineScope
) {


    fun insertFavoriteCocktail(favorite: UserFavoriteCocktail) {
        myDatabase.userFavoriteCocktailDao().insertFavoriteCocktail(favorite)
    }


    fun deleteFavoriteCocktail(favorite: UserFavoriteCocktail) {
        myDatabase.userFavoriteCocktailDao().deleteFavoriteCocktail(favorite)
    }


    fun getFavoritesForUser(userId: Long): Flow<List<UserFavoriteCocktail>> {
        return myDatabase.userFavoriteCocktailDao().getFavoritesForUser(userId)
    }


    fun performDatabaseOperation(dispatcher: CoroutineDispatcher, databaseOperation: suspend () -> Unit) {
        coroutineScope.launch(dispatcher) {
            databaseOperation()
        }
    }
}


 */