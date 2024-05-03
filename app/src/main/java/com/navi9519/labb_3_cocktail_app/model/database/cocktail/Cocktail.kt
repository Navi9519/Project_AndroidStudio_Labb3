package com.navi9519.labb_3_cocktail_app.model.database.cocktail


import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "cocktails")
data class Cocktail(
    @PrimaryKey
    val cocktailId: Long,
    // Foreign Key
    val userId: Long,
)
{

}

