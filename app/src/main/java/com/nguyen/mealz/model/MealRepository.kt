package com.nguyen.mealz.model

import com.nguyen.mealz.model.api.MealService
import com.nguyen.mealz.model.network.Categories
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealRepository(private val service: MealService = MealService()) {
    fun getMeals(callback: (categories: Categories?) -> Unit) {
        // MealRepository.getMeals() runs on the Main thread
        // execute() will block the Main thread until we get a response
        // this is bad practice; app will crash with android.os.NetworkOnMainThreadException
        return service.getMeals().enqueue(object: Callback<Categories> {
            override fun onResponse(call: Call<Categories?>, response: Response<Categories>) {
                if (response.isSuccessful) {
                    callback(response.body())
                }
            }

            override fun onFailure(call: Call<Categories?>, t: Throwable) {
                // TODO
            }
        })
    }
}