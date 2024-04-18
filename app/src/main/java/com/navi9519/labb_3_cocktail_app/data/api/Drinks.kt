package com.navi9519.labb_3_cocktail_app.data.api

import com.google.gson.annotations.SerializedName

data class Drinks(
    @SerializedName("drinks")
    val cocktail: Cocktail
)