package com.navi9519.labb_3_cocktail_app.data.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.lang.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object DrinksRetrofit {

    private const val BASE_URL = "https://www.thecocktaildb.com/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val getDrinksApi by lazy {
        retrofit.create<DrinksApi>().getDrinks()
    }

    suspend fun fetchDrinks(): Drinks {

        return suspendCoroutine { continuation ->
            getDrinksApi.enqueue(object : Callback<Drinks> {

                override fun onResponse(call: Call<Drinks>, response: Response<Drinks>) {
                    if (response.isSuccessful) {
                        val drinks = response.body()


                        if (drinks != null) {
                            continuation.resume(drinks)
                        } else {
                            continuation.resumeWithException(Exception("Unsuccessful response: ${response.code()}"))
                        }
                    }
                }

                override fun onFailure(call: Call<Drinks>, t: Throwable) {
                    println(t.message)
                }

            })
        }
    }


}