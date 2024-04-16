package com.example.kotlincomposefirstapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kotlincomposefirstapp.models.User

class UserViewModel : ViewModel() {
    var user by mutableStateOf<User?>(null)
        private set

    fun addUser(newUser: User){
        user = newUser
    }
}