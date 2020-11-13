package com.androidstudies.beertechchallenge.viewmodel

import androidx.lifecycle.ViewModel

class LoginPageViewModel: ViewModel() {

    fun isLoginValid(login: String): String {
        if (login.length === 0) {
            return "Campo precisa estar preenchido."
        }
        else if (login.length in 1..5) {
            return "Login precisa ter ao menos 6 caracteres."
        }
        else {
            return ""
        }
    }

    fun isPasswordValid(password: String): String {
        if (password.length === 0) {
            return "Campo precisa estar preenchido."
        }
        else if (password.length in 1..7) {
            return "Senha precisa ter ao menos 8 caracteres."
        }
        else {
            return ""
        }
    }

}