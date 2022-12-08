package com.example.deezer.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(@PrimaryKey(autoGenerate = true) val id: Int? = null,
                      val username: String,
                      val firstname: String,
                      val lastname: String,
                      val password: String)
{

}