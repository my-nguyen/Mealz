package com.nguyen.mealz.model

import com.nguyen.mealz.model.network.Categories

class MealRepository {
    fun getMeals(): Categories = Categories(listOf())
}