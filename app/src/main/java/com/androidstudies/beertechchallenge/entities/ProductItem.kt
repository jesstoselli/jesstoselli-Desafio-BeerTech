package com.androidstudies.beertechchallenge.entities

import com.squareup.moshi.Json

data class ProductItem (

    @Json(name = "produto")
    val product: String,

    @Json(name = "descricao")
    val quantity: String,

    @Json(name = "preco")
    val price: Float,

    @Json(name = "desconto")
    val discount: Boolean,

    @Json(name = "imagem")
    val imageUrl: String
)