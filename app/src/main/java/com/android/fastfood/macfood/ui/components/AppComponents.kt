package com.android.fastfood.macfood.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.android.fastfood.macfood.data.entity.MealsResponse
import com.android.fastfood.macfood.data.entity.MealsResponseItem

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
        items(response.size) { meal ->
            MenuItem(meal = response[meal])
        }
    }
}

@Composable
fun MealItem(meal: MealsResponseItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Replace this with actual image loading logic
            AsyncImage(
                model = meal.image,
                contentDescription = "Meal Image",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = meal.name,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = meal.description,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Price: ${meal.price}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Quantity: ${meal.quantity}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun MenuItem(meal: MealsResponseItem) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xfffdcb00))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Box(modifier = Modifier
                    .weight(2f),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = meal.image,
                        contentDescription = "Meal Image",
                        modifier = Modifier
                            .size(150.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)

                    )
                }
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .weight(2f)
                ) {
                    Text(
                        text = meal.name.uppercase(),
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.White,
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp, 0.dp, 0.dp, 10.dp))
                            .background(Color.White)
                            .padding(7.dp),
                        text = "Quantity: ${meal.quantity}",
                        style = MaterialTheme.typography.bodyMedium
                    )

                }
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Column() {
                Text(
                    text = meal.description,                 //LoremIpsum(10).values.first()
                    style = MaterialTheme.typography.titleLarge,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "Just @${meal.price} Rs/-",
                    style = MaterialTheme.typography.headlineMedium,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

            }
        }
    }
}