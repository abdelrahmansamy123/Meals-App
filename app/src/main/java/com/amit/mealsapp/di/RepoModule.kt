package com.amit.mealsapp.di

import com.amit.data.remote.homeScreen.MealsApi
import com.amit.data.repo.homeScreen.HomeScreenRepoImpl
import com.amit.domain.repo.homeScreen.HomeScreenRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun provideHomeScreenRepo(api: MealsApi): HomeScreenRepo {
        return HomeScreenRepoImpl(api)
    }
}