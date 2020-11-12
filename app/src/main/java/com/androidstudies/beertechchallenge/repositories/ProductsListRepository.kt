package com.androidstudies.beertechchallenge.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.androidstudies.beertechchallenge.entities.ProductItem
import com.androidstudies.beertechchallenge.network.ProductsAPIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ProductsListRepository(private val productAPI: ProductsAPIService) {
    private val productsListResponse = MutableLiveData<List<ProductItem>>()

    val productsList: LiveData<List<ProductItem>>
        get() = productsListResponse


    private fun getProducts() {
        CoroutineScope(Dispatchers.IO).launch {
            try {

                val response = productAPI.getProducts().productsList
                productsListResponse.postValue(response)

            } catch (e: Exception) {

                withContext(Dispatchers.Main) {
                    productsListResponse.postValue(listOf())
                } //todo: improve remote access error

            }
        }
    }

}