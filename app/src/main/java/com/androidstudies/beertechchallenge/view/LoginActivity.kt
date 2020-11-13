package com.androidstudies.beertechchallenge.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidstudies.beertechchallenge.databinding.ActivityMainBinding
import com.androidstudies.beertechchallenge.entities.LoginPost
import com.androidstudies.beertechchallenge.repositories.ProductsListRepository
import com.androidstudies.beertechchallenge.viewmodel.LoginPageViewModel


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = ProductsListRepository()
        val viewModel = LoginPageViewModel(repository)

        val inputLogin = binding.etLogin.text
        val inputPassword = binding.etPassword.text

        val warningLogin = binding.tvLoginWarning
        val warningPassword = binding.tvPasswordWarning

        binding.btnLogin.setOnClickListener {
            warningLogin.text = viewModel.isLoginValid(inputLogin.toString())
            warningPassword.text = viewModel.isPasswordValid(inputPassword.toString())

            if(warningLogin.text.isEmpty() && warningPassword.text.isEmpty()) {

                val login = LoginPost(inputLogin.toString(), inputPassword.toString())
                viewModel.postLogin(login)

                val intent = Intent(this, ProductsListActivity::class.java)
                startActivity(intent)

            }
        }

    }
}