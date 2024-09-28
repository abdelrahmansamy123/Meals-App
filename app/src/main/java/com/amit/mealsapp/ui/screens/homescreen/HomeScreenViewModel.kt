package com.amit.mealsapp.ui.screens.homescreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.amit.domain.entity.homeScreen.MealModelResponse
import com.amit.domain.usecase.GetMealsFromRemote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "HomeScreenViewModel"

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val getMealsFromRemote: GetMealsFromRemote) :
    ViewModel() {
    private val _meals = MutableStateFlow(MealModelResponse(emptyList()))
    val meals = _meals.asStateFlow()

    init {
        getMeals()
    }

    private fun getMeals() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _meals.value = getMealsFromRemote()
                Log.d(TAG, "getMeals: ${Thread.currentThread().name}")
            } catch (e: Exception) {
                if (e is HttpException) {
                    Log.d(TAG, "HttpException getMeals: ${e.message}")
                } else {
                    Log.d(TAG, "Exception getMeals: ${e.message}")
                }
            }
        }
    }
}