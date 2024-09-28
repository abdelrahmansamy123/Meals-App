package com.amit.mealsapp.di

import com.amit.domain.repo.homeScreen.HomeScreenRepo
import com.amit.domain.usecase.GetMealsFromRemote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetMealsFromRemoteUseCase(homeScreenRepo: HomeScreenRepo): GetMealsFromRemote {
        return GetMealsFromRemote(homeScreenRepo)

    }
}