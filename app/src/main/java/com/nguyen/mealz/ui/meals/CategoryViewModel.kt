package com.nguyen.mealz.ui.meals

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nguyen.mealz.model.MealRepository
import com.nguyen.mealz.model.network.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryViewModel(private val repository: MealRepository = MealRepository()) : ViewModel() {
    val meals = mutableStateOf(listOf<Category>())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val data = getMeals()
            meals.value = data
        }
    }

    private suspend fun getMeals(): List<Category> {
        return repository.getMeals().categories
    }
}