package com.nguyen.mealz.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.nguyen.mealz.model.MealRepository
import com.nguyen.mealz.model.network.Category

class DetailViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    val mealState = mutableStateOf<Category?>(null)

    init {
        val mealId = savedStateHandle.get<String>("meal_id") ?: ""
        mealState.value = MealRepository.getMeal(mealId)
    }
}