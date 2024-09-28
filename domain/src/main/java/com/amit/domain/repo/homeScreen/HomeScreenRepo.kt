package com.amit.domain.repo.homeScreen

import com.amit.domain.entity.homeScreen.MealModelResponse

interface HomeScreenRepo {
    suspend fun getMealsFromRemote(): MealModelResponse
}