package com.android.fastfood.macfood.data.api

import com.android.fastfood.macfood.data.entity.MealsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("chickens")
    fun getMeals(): Response<MealsResponse>
}