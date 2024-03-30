package com.android.fastfood.macfood.ui.repository

import android.util.Log
import com.android.fastfood.macfood.ResourceState
import com.android.fastfood.macfood.data.datasource.MealsDataSource
import com.android.fastfood.macfood.data.entity.MealsResponse
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.net.SocketTimeoutException
import javax.inject.Inject

class MealsRepository @Inject constructor(
    private val mealsDataSource: MealsDataSource
) {
//    suspend fun getMeals() : Response<MealsResponse>{
//        return mealsDataSource.getMeals()
//    }

    suspend fun getMeals() : Flow<ResourceState<MealsResponse>> {
        return flow {
            try {
                emit(ResourceState.Loading())
                val response = mealsDataSource.getMeals()

                Log.d("MealsRepository", "Response status: ${response.isSuccessful}")
                Log.d("MealsRepository", "Response body: ${response.body()}")

                if (response.isSuccessful && response.body() != null) {
                    emit(ResourceState.Success(response.body()!!))
                } else {
                    emit(ResourceState.Error("error fetching"))
                }
            } catch (e: SocketTimeoutException) {
                Log.d("Meals", "Timeout error: ${e.localizedMessage}")
                emit(ResourceState.Error("Timeout error: ${e.localizedMessage ?: "some error"}"))
            } catch (e: Exception) {
                Log.d("Meals", "Error occurred: ${e.localizedMessage}")
                emit(ResourceState.Error(e.localizedMessage ?: "some error"))
            }
        }
    }
}