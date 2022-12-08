package com.example.deezer.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.deezer.data.local.entities.UserEntity

@Dao
interface UserDao {
    @Insert
    fun insert(user: UserEntity)

    @Update
    fun update(user: UserEntity)

    @Delete
    fun delete(user: UserEntity)

    // @Query("SELECT user.id, user.username, user.firstname, user.lastname FROM user WHERE user.username = :username AND user.password = :password ")
    @Query("SELECT user.* FROM user WHERE user.username = :username AND user.password = :password ")
    fun login(username : String, password : String) : UserEntity?
}