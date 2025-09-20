package com.nguyen.mealz.ui.meals

import androidx.lifecycle.ViewModel
import com.nguyen.mealz.model.MealRepository
import com.nguyen.mealz.model.network.Category

class CategoryViewModel(private val repository: MealRepository = MealRepository()) : ViewModel() {
    fun getMeals(): List<Category> {
        return repository.getMeals()?.categories.orEmpty()
    }
}