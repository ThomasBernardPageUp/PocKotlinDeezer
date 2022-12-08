package com.example.deezer.screens.fragments.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deezer.data.local.entities.UserEntity
import com.example.deezer.repositories.UserRepository
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent

class LoginViewModel : ViewModel() {

    val userRepository : UserRepository by KoinJavaComponent.inject(UserRepository::class.java)

    fun login(username:String, password:String, callback:(UserEntity?)->Unit){
        viewModelScope.launch {
            val user = userRepository.login(username, password)
            callback(user)
        }
    }
}