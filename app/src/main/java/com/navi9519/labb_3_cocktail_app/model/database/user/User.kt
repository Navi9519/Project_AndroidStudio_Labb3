package com.navi9519.labb_3_cocktail_app.model.database.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    val email: String,
    val name: String,
    val password: String
)   {

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}
