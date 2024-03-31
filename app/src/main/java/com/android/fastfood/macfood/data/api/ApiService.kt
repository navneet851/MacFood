package com.android.fastfood.macfood.data.api

import com.android.fastfood.macfood.data.entity.MealsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("chickens")
    suspend fun getMeals(): Response<MealsResponse> // Change 'Any' to your expected response type
}