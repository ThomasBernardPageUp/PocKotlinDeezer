package com.example.deezer.di

import android.app.Application
import com.example.deezer.data.local.database.LocalDatabase
import com.example.deezer.repositories.UserRepository
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module


class DeezerApplication : Application() {

    val database by lazy { LocalDatabase.getDatabase(this) }

    override fun onCreate() {

        val repositoriesModules = module {
            single {
                UserRepository(database.userDao())
            }
        }

        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@DeezerApplication)
            // Load modules
            modules(repositoriesModules)
        }
    }
}