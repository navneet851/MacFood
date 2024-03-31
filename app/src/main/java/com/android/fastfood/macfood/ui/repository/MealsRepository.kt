package com.android.fastfood.macfood.ui.repository

import android.util.Log
import com.android.fastfood.macfood.ResourceState
import com.android.fastfood.macfood.data.datasource.MealsDataSource
import com.android.fastfood.macfood.data.entity.MealsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MealsRepository @Inject constructor(
    private val mealsDataSource: MealsDataSource
){
//    suspend fun getMeals(): Response<MealsResponse>{
//        return mealsDataSource.getMeals()
//    }

    suspend fun getMeals(): Flow<ResourceState<MealsResponse>> {
        return flow {
            emit(ResourceState.Loading())

            val response = mealsDataSource.getMeals()
             Log.d("reponse", response.body()?.meals?.size.toString())
            if (response.isSuccessful && response.body() != null){
                emit(ResourceState.Success(response.body()!!))
            }
            else{
                emit(ResourceState.Error("An fetching api error occurred"))
            }
        }.catch {e ->
            emit(ResourceState.Error( e.localizedMessage ?: "Some arror in flow"))
        }
    }
}