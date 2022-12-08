package com.example.deezer.di

import android.app.Application
import com.example.deezer.data.local.database.LocalDatabase
import com.example.deezer.data.remote.services.ArtistService
import com.example.deezer.repositories.UserRepository
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DeezerApplication : Application() {

    private val database by lazy { LocalDatabase.getDatabase(this) }
    private val retrofit = Retrofit.Builder().baseUrl("https://api.deezer.com/").addConverterFactory(GsonConverterFactory.create()).build()

    override fun onCreate() {
        super.onCreate()

        val repositoriesModules = module {
            single {
                UserRepository(database.userDao())
            }
        }

        val servicesModules = module{
            single {
                retrofit.create(ArtistService::class.java)
            }
        }

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@DeezerApplication)
            // Load modules
            modules(repositoriesModules,servicesModules)
        }
    }
}