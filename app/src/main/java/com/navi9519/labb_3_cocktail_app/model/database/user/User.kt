    package com.navi9519.labb_3_cocktail_app.model.database.user

    import androidx.room.Entity
    import androidx.room.PrimaryKey
    import androidx.room.TypeConverters
    import com.navi9519.labb_3_cocktail_app.model.database.cocktail.Cocktail

    @Entity(tableName = "users")
    data class User(
        val email: String,
        val name: String,
        val password: String,
        // var favoriteCocktails: MutableList<Cocktail>? = null // Use MutableList instead of List
    ) {
        @PrimaryKey(autoGenerate = true)
        var userId: Long? = null
    }
