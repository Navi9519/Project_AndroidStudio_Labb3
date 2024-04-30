    package com.navi9519.labb_3_cocktail_app.model.api

    import retrofit2.Call
    import retrofit2.http.GET
    import retrofit2.http.Query

    interface FetchDrinksAPI {
        @GET("api/json/v1/1/random.php")
        fun getRandomCocktails(@Query("num") num: Int): Call<DrinksAPI>
    }