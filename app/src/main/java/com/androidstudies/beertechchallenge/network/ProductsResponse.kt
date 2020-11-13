package com.androidstudies.beertechchallenge.network

import com.androidstudies.beertechchallenge.entities.ProductItem
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductsResponse (
    @Json(name = "produtos")
    val productsList: List<ProductItem>
)