package com.android.fastfood.macfood.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.android.fastfood.macfood.data.entity.MealsResponse

@Composable
fun Loader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(45.dp),
            color = Color.Green
        )
    }

}

@Composable
fun MealsList(response : MealsResponse) {
    LazyColumn {
        items(response.size){ meal ->
            Text(
                modifier = Modifier.padding(16.dp),
                text = response[meal].name
            )

        }
    }
}