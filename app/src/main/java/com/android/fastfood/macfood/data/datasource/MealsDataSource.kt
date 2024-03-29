package com.android.fastfood.macfood.data.datasource

import com.android.fastfood.macfood.data.entity.MealsResponse
import retrofit2.Response

interface MealsDataSource {
    fun getMeals(): Response<MealsResponse>
}