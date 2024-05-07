        package com.navi9519.labb_3_cocktail_app.model.database.relation

        import androidx.room.Embedded
        import androidx.room.Relation
        import com.navi9519.labb_3_cocktail_app.model.database.cocktail.Cocktail
        import com.navi9519.labb_3_cocktail_app.model.database.user.User

        data class UserWithCocktails(

            @Embedded
            val user: User,

            @Relation(parentColumn = "userId", entityColumn = "userId")
            val cocktails: List<Cocktail>
        )

