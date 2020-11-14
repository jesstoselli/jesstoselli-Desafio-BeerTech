package com.androidstudies.beertechchallenge.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.androidstudies.beertechchallenge.entities.LoginPost
import com.androidstudies.beertechchallenge.entities.ProductItem
import com.androidstudies.beertechchallenge.network.ProductsAPI
import kotlinx.coroutines.*
import java.lang.Exception

class ProductsListRepository {

    private val productsListResponse = MutableLiveData<List<ProductItem>>()
    val productsResponse: LiveData<List<ProductItem>>
        get() = productsListResponse

    init {
        getProducts()
    }


    private fun getProducts() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
              val response = ProductsAPI.retrofitService.getBeers().body()
                productsListResponse.postValue(response)

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    productsListResponse.postValue(null)
                }

            }
        }
    }

    suspend fun postLogin(loginItem: LoginPost) = ProductsAPI.retrofitService.postLogin(loginItem)

}