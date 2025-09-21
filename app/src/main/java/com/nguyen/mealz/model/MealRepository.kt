package com.nguyen.mealz.model

import com.nguyen.mealz.model.api.MealService
import com.nguyen.mealz.model.network.Categories
import com.nguyen.mealz.model.network.Category

object MealRepository {
    private var cachedMeals = listOf<Category>()

    suspend fun getMeals(): Categories {
        val meals = MealService.getMeals()
        cachedMeals = meals.categories
        return meals
    }

    fun getMeal(id: String): Category? {
        return cachedMeals.firstOrNull { it.id == id }
    }
}