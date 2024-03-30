package com.android.fastfood.macfood.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.fastfood.macfood.ResourceState
import com.android.fastfood.macfood.data.entity.MealsResponse
import com.android.fastfood.macfood.ui.repository.MealsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val mealsRepository: MealsRepository
) : ViewModel() {

    private val _meals : MutableStateFlow<ResourceState<MealsResponse>> = MutableStateFlow(ResourceState.Loading())
    val meals : StateFlow<ResourceState<MealsResponse>> = _meals
    private fun getAllMeals(){
        viewModelScope.launch(Dispatchers.IO) {
            mealsRepository.getMeals()
                .collectLatest { mealsResponse ->
                    _meals.value = mealsResponse

                }
        }
    }
    init {
//        Log.d("checking", "hello guys")
        getAllMeals()
    }
}