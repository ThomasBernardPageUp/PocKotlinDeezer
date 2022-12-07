package com.example.deezer.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.deezer.data.local.entities.UserEntity

interface UserDao {
    @Insert
    fun insert(user: UserEntity)

    @Update
    fun update(user: UserEntity)

    @Delete
    fun delete(user: UserEntity)

    @Query("select * from user")
    fun getAllNotes(username : String, password : String): LiveData<List<UserEntity>>
}