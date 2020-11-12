package com.androidstudies.beertechchallenge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androidstudies.beertechchallenge.repositories.ProductsListRepository

class ProductsListViewModelFactory(private val repository: ProductsListRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductsListViewModel::class.java)) {
            return ProductsListViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}