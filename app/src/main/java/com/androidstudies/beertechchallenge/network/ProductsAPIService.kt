package com.androidstudies.beertechchallenge.network

import com.androidstudies.beertechchallenge.entities.LoginPost
import com.androidstudies.beertechchallenge.entities.ProductItem
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

private const val BASE_URL = "https://private-8f4dda-testeabi.apiary-mock.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit : Retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ProductsAPIService {
    @GET("/produtos")
    suspend fun getBeers(): Response<List<ProductItem>>

    @POST("/Login")
    suspend fun postLogin(@Body posts: LoginPost): Response<LoginPostResponse>
}

object ProductsAPI {
    val retrofitService: ProductsAPIService by lazy {
        retrofit.create(ProductsAPIService::class.java)
    }
}

