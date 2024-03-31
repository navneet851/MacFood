package com.android.fastfood.macfood.data.datasource

import com.android.fastfood.macfood.data.entity.MealsResponse
import retrofit2.Response


//blue print of meals data source just like abstract class
interface MealsDataSource {
    suspend fun getMeals(): Response<MealsResponse>
}