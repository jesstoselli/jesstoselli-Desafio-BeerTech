package com.androidstudies.beertechchallenge.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.androidstudies.beertechchallenge.entities.ProductItem
import com.androidstudies.beertechchallenge.network.ProductsAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

}