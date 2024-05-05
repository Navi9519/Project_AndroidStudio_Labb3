package com.navi9519.labb_3_cocktail_app.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.navi9519.labb_3_cocktail_app.model.database.cocktail.Cocktail
import com.navi9519.labb_3_cocktail_app.model.database.relation.Converters
import com.navi9519.labb_3_cocktail_app.model.database.user.User
import com.navi9519.labb_3_cocktail_app.model.database.user.UserDAO

@Database(entities = [User::class, Cocktail::class], version = 6) // Incremented version to 6
@TypeConverters(Converters::class)
abstract class MyDatabase : RoomDatabase() {

    abstract fun userDao(): UserDAO

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

                    // Handle migration from version 1 to 2, 2 to 3, 3 to 4, 4 to 5, 5 to 6
                    .addMigrations(MIGRATION_2_3, MIGRATION_3_4, MIGRATION_4_5, MIGRATION_5_6)
                    .build()
                INSTANCE = instance
                instance
            }
        }

        // Migration from version 1 to 2, 2 to 3, 3 to 4, 4 to 5
        private val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE users ADD COLUMN favoriteCocktail TEXT")
            }
        }

        private val MIGRATION_3_4 = object : Migration(3, 4) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // Rename the 'id' column to 'userId' in the 'users' table
                db.execSQL("ALTER TABLE users RENAME COLUMN id TO userId")
            }
        }

        // Migration from version 4 to 5
        private val MIGRATION_4_5 = object : Migration(4, 5) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // Rename the 'id' column to 'cocktailId' in the 'cocktails' table
                db.execSQL("ALTER TABLE cocktails RENAME COLUMN id TO cocktailId")
            }
        }

        // New migration from version 5 to 6
        private val MIGRATION_5_6 = object : Migration(5, 6) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // Add the 'userId' column to the 'Cocktail' table with a default value of 0 and set notNull to true
                db.execSQL("ALTER TABLE cocktails ADD COLUMN userId INTEGER NOT NULL DEFAULT 0")

                // Update the existing rows to set the default value for userId
                db.execSQL("UPDATE cocktails SET userId = 0 WHERE userId IS NULL")

                // Change the notNull constraint for all existing columns
                db.execSQL("PRAGMA foreign_keys=off")
                db.execSQL("CREATE TABLE cocktails_temp (" +
                        "cocktailImg TEXT, " +
                        "cocktailName TEXT, " +
                        "cocktailCategory TEXT, " +
                        "cocktailInstructions TEXT, " +
                        "cocktailId INTEGER PRIMARY KEY NOT NULL, " +
                        "userId INTEGER NOT NULL DEFAULT 0" +
                        ")")
                db.execSQL("INSERT INTO cocktails_temp (cocktailImg, cocktailName, cocktailCategory, cocktailInstructions, cocktailId, userId) SELECT cocktailImg, cocktailName, cocktailCategory, cocktailInstructions, cocktailId, userId FROM cocktails")
                db.execSQL("DROP TABLE cocktails")
                db.execSQL("ALTER TABLE cocktails_temp RENAME TO cocktails")
                db.execSQL("PRAGMA foreign_keys=on")
            }
        }





    }


}
