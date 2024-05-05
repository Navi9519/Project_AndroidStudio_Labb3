package com.navi9519.labb_3_cocktail_app.model.database.relation

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.navi9519.labb_3_cocktail_app.model.database.cocktail.Cocktail

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun fromCocktail(cocktail: Cocktail?): String? {
        return gson.toJson(cocktail)
    }

    @TypeConverter
    fun toCocktail(cocktailString: String?): Cocktail? {
        if (cocktailString == null) {
            return null
        }
        val type = object : TypeToken<Cocktail>() {}.type
        return gson.fromJson(cocktailString, type)
    }
}
