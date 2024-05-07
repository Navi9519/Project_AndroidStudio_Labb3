    package com.navi9519.labb_3_cocktail_app.model.database.relation

    import androidx.room.TypeConverter
    import com.google.gson.Gson
    import com.google.gson.reflect.TypeToken
    import com.navi9519.labb_3_cocktail_app.model.database.cocktail.Cocktail

    class Converters {

        private val gson = Gson()

        @TypeConverter
        fun fromCocktailList(cocktailList: MutableList<Cocktail>?): String? {
            return gson.toJson(cocktailList)
        }

        @TypeConverter
        fun toCocktailList(cocktailListString: String?): MutableList<Cocktail>? {
            if (cocktailListString == null) {
                return null
            }
            val type = object : TypeToken<MutableList<Cocktail>>() {}.type
            return gson.fromJson(cocktailListString, type)
        }
    }
