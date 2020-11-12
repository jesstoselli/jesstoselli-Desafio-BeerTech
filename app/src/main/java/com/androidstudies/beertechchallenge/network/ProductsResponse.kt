package com.androidstudies.beertechchallenge.network

import com.androidstudies.beertechchallenge.entities.ProductItem
import com.squareup.moshi.Json

data class ProductsResponse (
    @Json(name = "")
    val productsList: List<ProductItem>
)