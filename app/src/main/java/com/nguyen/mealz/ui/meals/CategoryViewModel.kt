package com.nguyen.mealz.ui.meals

import android.util.Log
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
        Log.d("TAG_COROUTINES", "1. about to launch a coroutine") // 1
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("TAG_COROUTINES", "3. coroutine launched") // 3
            val data = getMeals()
            Log.d("TAG_COROUTINES", "4. async data received") // 4
            meals.value = data
        }
        Log.d("TAG_COROUTINES", "2. outside coroutine; other work") // 2
    }

    private suspend fun getMeals(): List<Category> {
        return repository.getMeals().categories
    }
}