package com.android.fastfood.macfood.data.entity

data class MealsResponse(
    val meals : List<Meals>
)

data class Meals(
    val id : Int,
    val name : String,
    val description : String,
    val image : String,
    val price : Int,
    val quantity : Int
)