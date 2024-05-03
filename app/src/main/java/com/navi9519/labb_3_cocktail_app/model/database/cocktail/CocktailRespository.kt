package com.navi9519.labb_3_cocktail_app.model.database.cocktail


import com.navi9519.labb_3_cocktail_app.model.database.MyDatabase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CocktailRepository(
    private val myDatabase: MyDatabase,
    private val coroutineScope: CoroutineScope
) {




    fun performDatabaseOperation(dispatcher: CoroutineDispatcher, databaseOperation: suspend () -> Unit) {
        coroutineScope.launch(dispatcher) {
            databaseOperation()
        }
    }
}


