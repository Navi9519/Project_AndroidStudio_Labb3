package com.navi9519.labb_3_cocktail_app.model.database.cocktail


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface CocktailDAO {

    @Upsert
    fun insertFavoriteCocktail(favorite: Cocktail)

    @Delete
    fun deleteFavoriteCocktail(favorite: Cocktail)

    @Query("SELECT * FROM cocktails WHERE userId = :userId")
    fun getFavoritesForUser(userId: Long): Flow<List<Cocktail>>

}

