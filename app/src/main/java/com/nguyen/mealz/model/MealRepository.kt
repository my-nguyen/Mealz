package com.nguyen.mealz.model

import com.nguyen.mealz.model.api.MealService
import com.nguyen.mealz.model.network.Categories

class MealRepository(private val service: MealService = MealService()) {
    suspend fun getMeals(): Categories {
        return service.getMeals()
    }
}