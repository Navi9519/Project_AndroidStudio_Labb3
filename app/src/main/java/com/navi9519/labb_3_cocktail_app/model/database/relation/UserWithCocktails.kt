    package com.navi9519.labb_3_cocktail_app.model.database.relation

    import androidx.room.Embedded
    import androidx.room.Relation
    import com.navi9519.labb_3_cocktail_app.model.database.cocktail.Cocktail
    import com.navi9519.labb_3_cocktail_app.model.database.user.User

    data class UserWithCocktails(
        @Embedded
        val user: User,
        @Relation(parentColumn = "userId", entityColumn = "userId")
        // TODO -> Could be null but can also crash -> lets see
        // TODO -> How to convert this object -> chatgpt, You want this as a type converter
        val cocktails: List<Cocktail>
    )
