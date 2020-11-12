package com.androidstudies.beertechchallenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.androidstudies.beertechchallenge.R
import com.androidstudies.beertechchallenge.databinding.ActivityProductsListBinding
import com.androidstudies.beertechchallenge.network.ProductsAPI
import com.androidstudies.beertechchallenge.repositories.ProductsListRepository
import com.androidstudies.beertechchallenge.viewmodel.ProductsListViewModel
import com.androidstudies.beertechchallenge.viewmodel.ProductsListViewModelFactory

class ProductsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProductsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val remoteService = ProductsAPI.retrofitService
        val repository = ProductsListRepository(remoteService)

        val viewModelFactory = ProductsListViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(ProductsListViewModel::class.java)
        val list = viewModel.productsList

        val recyclerView = binding.recyclerViewProducts
        val adapter = ProductItemsAdapter()
        recyclerView.adapter = adapter

        list.observe(this, Observer {
            adapter.data = it
            recyclerView.visibility = View.VISIBLE
            binding.loadingProductsIndicator.visibility = View.GONE
        })
    }
}