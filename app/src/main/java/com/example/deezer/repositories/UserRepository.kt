package com.example.deezer.repositories

import com.example.deezer.data.local.dao.UserDao
import com.example.deezer.data.local.entities.UserEntity

class UserRepository(private val userDao: UserDao) {

    suspend fun register(user:UserEntity){
        userDao.insert(user)
    }

    suspend fun login(username: String, password:String) : UserEntity? {
        val user = userDao.login(username, password)
        return user
    }
}