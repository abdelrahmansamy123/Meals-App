package com.amit.data.remote.homeScreen

import com.amit.domain.entity.homeScreen.MealModelResponse
import retrofit2.http.GET

interface MealsApi {
    @GET("api/json/v1/1/categories.php")
    suspend fun getMeals(): MealModelResponse


}