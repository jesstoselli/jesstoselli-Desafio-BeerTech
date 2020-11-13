package com.androidstudies.beertechchallenge.network

import com.androidstudies.beertechchallenge.entities.ProductItem


data class ProductsResponse (
    val productsList: List<ProductItem>
)
