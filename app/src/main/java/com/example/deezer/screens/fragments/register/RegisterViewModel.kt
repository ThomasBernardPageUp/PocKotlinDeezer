package com.example.deezer.screens.fragments.register

import androidx.annotation.WorkerThread
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deezer.data.local.entities.UserEntity
import com.example.deezer.di.DeezerApplication
import com.example.deezer.repositories.UserRepository
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class RegisterViewModel() : ViewModel() {
    // TODO: Implement the ViewModel

    val userRepository : UserRepository by inject(UserRepository::class.java)


    fun register(username : String, firstname : String, lastname : String, password : String){

        val user = UserEntity(null, username, firstname, lastname, password)
        viewModelScope.launch {
            userRepository.register(user)
        }
    }
}