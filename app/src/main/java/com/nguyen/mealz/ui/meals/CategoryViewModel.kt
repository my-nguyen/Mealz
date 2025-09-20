package com.nguyen.mealz.ui.meals

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nguyen.mealz.model.MealRepository
import com.nguyen.mealz.model.network.Category
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CategoryViewModel(private val repository: MealRepository = MealRepository()) : ViewModel() {
    val meals = mutableStateOf(listOf<Category>())
    private val job = Job()

    init {
        // define a custom scope
        val scope = CoroutineScope(job + Dispatchers.IO)
        scope.launch {
            val data = getMeals()
            meals.value = data
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    private suspend fun getMeals(): List<Category> {
        return repository.getMeals().categories
    }
}