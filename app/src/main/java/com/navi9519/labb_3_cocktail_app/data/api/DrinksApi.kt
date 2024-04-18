package com.navi9519.labb_3_cocktail_app.data.api

import retrofit2.Call
import retrofit2.http.GET

interface DrinksApi {
    @GET("api/json/v1/1/random.php")
    fun getDrinks(): Call<Drinks>
}