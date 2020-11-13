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

        Log.w("DBG","Init ProductsListRepository");
        getProducts()
    }


    private fun getProducts() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
             Log.w("DBG","getProducts call");
              val response = ProductsAPI.retrofitService.getBeers().body()
                Log.w("DBG","getProducts returned $response");
                productsListResponse.postValue(response)

            } catch (e: Exception) {
                Log.w("DBG","${e.message} getProducts ERROR");
                withContext(Dispatchers.Main) {
                    productsListResponse.postValue(null)
                } //todo: improve remote access error

            }
        }
    }

}

//class BeersListRepository {
//    private val beersListResponse = MutableLiveData<List<Beers>>()
//
//    val  beersList: LiveData<List<Beers>>
//        get() = beersListResponse
//
//    init {
//        getBeersList()
//    }
//
//    private fun getBeersList() {
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val listResult = BeersApi.retrofitService.getBeers().body()
//                beersListResponse.postValue(listResult)
//
//            } catch (e: Exception) {
//                w