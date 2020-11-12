package com.androidstudies.beertechchallenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidstudies.beertechchallenge.databinding.ActivityProductsListBinding

class ProductsList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProductsListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}