package com.navi9519.labb_3_cocktail_app.model.api

import com.google.gson.annotations.SerializedName

class Cocktail(
    @SerializedName("strDrinkThumb") val cocktailImg: String,
    @SerializedName("strDrink") val cocktailName: String,
    @SerializedName("strCategory") val cocktailCategory: String,
    @SerializedName("strInstructions") val cocktailInstructions: String
    )