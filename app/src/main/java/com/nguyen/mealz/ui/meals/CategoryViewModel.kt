package com.nguyen.mealz.ui.meals

import androidx.lifecycle.ViewModel
import com.nguyen.mealz.model.MealRepository
import com.nguyen.mealz.model.network.Categories

class CategoryViewModel(private val repository: MealRepository = MealRepository()) : ViewModel() {
    fun getMeals(callback: (categories: Categories?) -> Unit) {
        repository.getMeals {
            callback(it)
        }
    }
}