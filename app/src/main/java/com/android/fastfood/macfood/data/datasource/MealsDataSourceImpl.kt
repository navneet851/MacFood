package com.android.fastfood.macfood.data.datasource

import com.android.fastfood.macfood.data.api.ApiService
import com.android.fastfood.macfood.data.entity.MealsResponse
import retrofit2.Response
import javax.inject.Inject

class MealsDataSourceImpl @Inject constructor(
    private val apiService: ApiService
): MealsDataSource {
    override suspend fun getMeals(): Response<MealsResponse> {
        return apiService.getMeals()
    }
}