package com.android.fastfood.macfood.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.fastfood.macfood.ResourceState
import com.android.fastfood.macfood.ui.components.Loader
import com.android.fastfood.macfood.ui.viewmodel.MealsViewModel

@Composable
fun HomeScreen(
    mealsViewModel : MealsViewModel = hiltViewModel()
) {

    val mealsRes by mealsViewModel.meals.collectAsState()

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        when(mealsRes){
            is ResourceState.Loading -> {
                Log.d("homeMain", "loading...")
                Loader()
            }

            is ResourceState.Success -> {
                Log.d("homeMain", "Success.")

            }

            is ResourceState.Error -> {
                Log.d("homeMain", "Error!!")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}