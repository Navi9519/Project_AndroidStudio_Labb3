package com.navi9519.labb_3_cocktail_app.model.database.cocktail

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "cocktails")
data class Cocktail(
    val cocktailImg: String,
    val cocktailName: String,
    val cocktailCategory: String,
    val cocktailInstructions: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}

