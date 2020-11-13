package com.androidstudies.beertechchallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.androidstudies.beertechchallenge.entities.ProductItem
import com.androidstudies.beertechchallenge.network.ProductsResponse
import com.androidstudies.beertechchallenge.repositories.ProductsListRepository

class ProductsListViewModel(private val repository: ProductsListRepository): ViewModel() {

    val productsList: LiveData<List<ProductItem>>
        get() = repository.productsResponse
}