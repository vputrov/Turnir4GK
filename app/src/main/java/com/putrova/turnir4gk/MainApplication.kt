package com.putrova.turnir4gk

import android.app.Application
import androidx.room.Room.databaseBuilder
import com.putrova.turnir4gk.data.MainDatabase

class MainApplication : Application() {

    var database : MainDatabase? = null

    override fun onCreate() {
        super.onCreate()
        database = databaseBuilder(this, MainDatabase::class.java, "turnir-database").build()
    }
}