package com.nguyen.mealz.model

import com.nguyen.mealz.model.api.MealService
import com.nguyen.mealz.model.network.Categories

class MealRepository(private val service: MealService = MealService()) {
    fun getMeals(): Categories? {
        // MealRepository.getMeals() runs on the Main thread
        // execute() will block the Main thread until we get a response
        // this is bad practice; app will crash with android.os.NetworkOnMainThreadException
        return service.getMeals().execute().body()
    }
}