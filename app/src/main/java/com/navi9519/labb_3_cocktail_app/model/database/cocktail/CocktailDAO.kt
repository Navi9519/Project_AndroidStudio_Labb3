package com.navi9519.labb_3_cocktail_app.model.database.cocktail

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface CocktailDAO {

    // Define Queries and Abstract-methods
    @Upsert
    fun insertOrUpdateCocktail(cocktail: Cocktail)

    @Delete
    fun deleteCocktails(cocktail: Cocktail)

   @Query("SELECT * FROM cocktails")
    fun findAllCocktails(): Flow<List<Cocktail>>

}