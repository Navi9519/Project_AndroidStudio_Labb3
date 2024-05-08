package com.navi9519.labb_3_cocktail_app.model.database.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.navi9519.labb_3_cocktail_app.model.database.cocktail.Cocktail
import com.navi9519.labb_3_cocktail_app.model.database.relation.UserWithCocktails
import kotlinx.coroutines.flow.Flow
import retrofit2.http.POST

@Dao
interface UserDAO {

    // Define Queries and Abstract-methods
    @Upsert
    fun insertOrUpdateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM users")
    fun findAllUsers(): Flow<List<User>>

    @Query("SELECT * FROM users WHERE name = :username AND password = :password LIMIT 1")
    fun findUserByUsernameAndPassword(username: String, password: String): Flow<User?>

    @Query("SELECT * FROM users WHERE name = :username")
    fun findExistingUser(username: String): Flow<User?>


    @Transaction
    @Query("SELECT * FROM users WHERE name  = :username")
    fun findUserByUsername(username: String): User?

    @Transaction
    @Query("SELECT * FROM users WHERE name = :username")
    fun findCocktails(username: String): Flow<UserWithCocktails>

    @Transaction
    @Query("SELECT * FROM cocktails WHERE cocktailName = :cocktail")
    fun findCocktail(cocktail: String): Flow<Cocktail>

    @Insert
    fun saveCocktail(cocktail: Cocktail)

    @Delete
    fun deleteCocktailById(cocktail: Cocktail)

}

