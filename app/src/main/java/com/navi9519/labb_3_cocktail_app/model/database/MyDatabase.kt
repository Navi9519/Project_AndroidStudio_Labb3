package com.navi9519.labb_3_cocktail_app.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.navi9519.labb_3_cocktail_app.model.database.user.User
import com.navi9519.labb_3_cocktail_app.model.database.user.UserDAO
@Database(entities = [User::class], version = 2) // Remove Cocktail::class
abstract class MyDatabase : RoomDatabase() {

    abstract fun userDao(): UserDAO // Remove cocktailDao()

    companion object {
        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    "my-app-db"
                )
                    // Handle migration from version 1 to 2
                    .addMigrations(MIGRATION_1_2)
                    .build()
                INSTANCE = instance
                instance
            }
        }

        // Migration from version 1 to 2
        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // No actual migration needed, as we're just removing the Cocktail table
                // You can leave this empty
            }
        }
    }
}

