package com.amit.data.remote.homeScreen

import com.amit.domain.entity.homeScreen.MealModelResponse
import retrofit2.http.GET

interface MealsApi {
    @GET("api/json/v1/1/categories.php")
    suspend fun getMeals(): MealModelResponse

    @GET("api/json/v1/1/lookup.php?i=52772")
    suspend fun getMealDetails(): MealModelResponse

    @GET("api/json/v1/1/search.php?s=Arrabiata")
    suspend fun getMealsByName(): MealModelResponse

    @GET("/api/json/v1/1/search.php?f=a")
    suspend fun getMealsByFirstLetter(): MealModelResponse
}