package com.androidstudies.beertechchallenge.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidstudies.beertechchallenge.entities.LoginPost
import com.androidstudies.beertechchallenge.repositories.ProductsListRepository
import kotlinx.coroutines.*

class LoginPageViewModel(private val repository: ProductsListRepository): ViewModel() {


     fun successfulLogin(loginItem: LoginPost, myCallback: (result: String?) -> Unit)  {
            var response: String

        CoroutineScope(Dispatchers.IO).launch {
            repository.postLogin(loginItem)
            val response =  repository.postLogin(loginItem).body()?.reposta

            var message = when(response) {
                "Sucesso" -> "Bem-vindo(a), ${loginItem.login}"
                else -> "Erro ao realizar o login."
            }

            myCallback(message)
        }
    }

    fun isValid(item: String): String {
        return when (item.length) {
            0 -> "Campo precisa estar preenchido."
            in 1..5 -> "Campo precisa ter ao menos 6 caracteres."
            else -> ""
        }
    }

}