package com.nguyen.mealz.model.network

import com.google.gson.annotations.SerializedName

data class Categories(val categories: List<Category>)

data class Category(
    @SerializedName("idCategory")
    val id: String,
    @SerializedName("strCategory")
    val name: String,
    @SerializedName("strCategoryThumb")
    val imageUrl: String,
    @SerializedName("strCategoryDescription")
    val description: String
)