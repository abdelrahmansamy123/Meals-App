package com.amit.domain.usecase

import com.amit.domain.entity.homeScreen.MealModelResponse
import com.amit.domain.repo.homeScreen.HomeScreenRepo

class GetMealsFromRemote(private val homeScreenRepo: HomeScreenRepo) {
    suspend operator fun invoke() = homeScreenRepo.getMealsFromRemote()
}