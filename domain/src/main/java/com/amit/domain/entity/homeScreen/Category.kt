package com.amit.domain.entity.homeScreen

import java.io.Serializable

data class Category(
    val idCategory: String? = null,
    val strCategory: String? = null,
    val strCategoryDescription: String? = null,
    val strCategoryThumb: String? = null
) : Serializable