package com.androidstudies.beertechchallenge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidstudies.beertechchallenge.entities.LoginPost
import com.androidstudies.beertechchallenge.repositories.ProductsListRepository
import kotlinx.coroutines.launch

class LoginPageViewModel(private val repository: ProductsListRepository): ViewModel() {

    fun postLogin(loginItem: LoginPost) {
        viewModelScope.launch {
            repository.postLogin(loginItem)
        }
    }

    fun isLoginValid(login: String): String {
        return when (login.length) {
            0 -> "Campo precisa estar preenchido."
            in 1..5 -> "Login precisa ter ao menos 6 caracteres."
            else -> ""
        }
    }

    fun isPasswordValid(password: String): String {
        return when(password.length) {
            0 -> "Campo precisa estar preenchido."
            in 1..5 -> "Senha precisa ter ao menos 6 caracteres."
            else -> ""
        }

    }

}