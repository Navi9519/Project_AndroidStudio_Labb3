        package com.navi9519.labb_3_cocktail_app.model.database.relation

        import androidx.room.Embedded
        import androidx.room.Relation
        import com.navi9519.labb_3_cocktail_app.model.database.cocktail.Cocktail
        import com.navi9519.labb_3_cocktail_app.model.database.user.User

        // TODO - ChatGPT generated answer might have provided something FAULTY, connection has NOT been made
        data class UserWithCocktails(

            @Embedded
            val user: User,

            // TODO - hover over RELATION, and check WHY parentColumn = "userId"
            @Relation(parentColumn = "userId", entityColumn = "userId")
            val cocktails: List<Cocktail>
        )

