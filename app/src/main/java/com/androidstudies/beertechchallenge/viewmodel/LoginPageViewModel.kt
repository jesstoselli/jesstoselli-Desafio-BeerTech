package com.androidstudies.beertechchallenge.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidstudies.beertechchallenge.entities.LoginPost
import com.androidstudies.beertechchallenge.repositories.ProductsListRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class LoginPageViewModel(private val repository: ProductsListRepository): ViewModel() {

    private fun postLogin  (loginItem: LoginPost) {
        viewModelScope.launch {
            repository.postLogin(loginItem)
        }
    }

     fun successfulLogin(loginItem: LoginPost): String {
         runBlocking { postLogin(loginItem) }
        val message = repository.loginPostResponseMessage

        Log.i("Inside ViewModel", "${message.value}")

//        val response = repository.loginPostResponseMessage
//        Log.i("Inside successfulLogin", response)

//        return if(response !== "200") {
//            "Erro ao realizar o login."
//        }
//        else {
//            "Bem-vindo(a), ${loginItem.login}"
//        }

        return  "Bem-vindo(a), ${loginItem.login}"

    }

    fun isValid(item: String): String {
        return when (item.length) {
            0 -> "Campo precisa estar preenchido."
            in 1..5 -> "Campo precisa ter ao menos 6 caracteres."
            else -> ""
        }
    }

}