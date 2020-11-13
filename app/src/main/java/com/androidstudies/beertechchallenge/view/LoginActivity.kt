package com.androidstudies.beertechchallenge.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidstudies.beertechchallenge.databinding.ActivityMainBinding
import com.androidstudies.beertechchallenge.viewmodel.LoginPageViewModel


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = LoginPageViewModel()

        val inputLogin = binding.etLogin.text
        val inputPassword = binding.etPassword.text

        val warningLogin = binding.tvLoginWarning
        val warningPassword = binding.tvPasswordWarning

        binding.btnLogin.setOnClickListener {
            warningLogin.text = viewModel.isLoginValid(inputLogin.toString())
            warningPassword.text = viewModel.isPasswordValid(inputPassword.toString())


            if(warningLogin.text.length === 0 && warningPassword.text.length === 0) {
                val intent = Intent(this, ProductsListActivity::class.java)
                startActivity(intent)
            }
        }

    }
}