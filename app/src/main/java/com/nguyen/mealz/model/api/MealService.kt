package com.nguyen.mealz.model.api

import com.nguyen.mealz.model.network.Categories
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object MealService {
    private lateinit var api: API

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(API::class.java)
    }

    suspend fun getMeals(): Categories {
        return api.getMeals()
    }

    interface API {
        @GET("categories.php")
        suspend fun getMeals(): Categories
    }
}