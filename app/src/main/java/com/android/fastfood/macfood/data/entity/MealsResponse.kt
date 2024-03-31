package com.android.fastfood.macfood.data.entity

data class MealsResponse(
    val meals : ArrayList<MealsResponseItem>
)

data class MealsResponseItem(
    val description: String,
    val id: Int,
    val image: String,
    val name: String,
    val price: Int,
    val quantity: Int
)