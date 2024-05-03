package com.navi9519.labb_3_cocktail_app.model.database.user

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.navi9519.labb_3_cocktail_app.model.database.cocktail.Cocktail

@Entity(tableName = "users")
data class User(
    val email: String,
    val name: String,
    val password: String,
    val favoriteCocktail: Cocktail
)   {

    @PrimaryKey(autoGenerate = true)
    var userId: Long? = null
}
