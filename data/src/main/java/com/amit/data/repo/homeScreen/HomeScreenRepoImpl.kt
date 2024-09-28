package com.amit.data.repo.homeScreen

import com.amit.data.remote.homeScreen.MealsApi
import com.amit.domain.entity.homeScreen.MealModelResponse
import com.amit.domain.repo.homeScreen.HomeScreenRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeScreenRepoImpl constructor(private val mealsApi: MealsApi) : HomeScreenRepo {
    override suspend fun getMealsFromRemote(): MealModelResponse = withContext(Dispatchers.IO) {
        return@withContext mealsApi.getMeals()
    }
}