package com.navi9519.labb_3_cocktail_app.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.navi9519.labb_3_cocktail_app.model.database.cocktail.Cocktail
import com.navi9519.labb_3_cocktail_app.model.database.cocktail.CocktailDAO
import com.navi9519.labb_3_cocktail_app.model.database.user.User
import com.navi9519.labb_3_cocktail_app.model.database.user.UserDAO

@Database(entities = [User::class, Cocktail::class], version = 1)
 abstract class MyDatabase: RoomDatabase() {

    // Our queries
    abstract fun userDao(): UserDAO
    abstract fun cocktailDao(): CocktailDAO

    companion object {
        @Volatile // TODO -> WHY Volatile?
        private var INSTANCE: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    "my-app-db"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }
}