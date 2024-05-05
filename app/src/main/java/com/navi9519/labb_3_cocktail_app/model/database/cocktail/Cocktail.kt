            package com.navi9519.labb_3_cocktail_app.model.database.cocktail


            import androidx.room.Entity
            import androidx.room.ForeignKey
            import androidx.room.PrimaryKey
            import com.google.gson.annotations.SerializedName

            @Entity(tableName = "cocktails")
            data class Cocktail(
                val cocktailImg: String? = null,
                val cocktailName: String? = null,
                val cocktailCategory: String? = null,
                val cocktailInstructions: String? = null,

                @PrimaryKey
                val cocktailId: Long,
                // Foreign Key
                val userId: Long,
            )
            {

            }

