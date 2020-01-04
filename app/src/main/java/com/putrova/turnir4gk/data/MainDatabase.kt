package com.putrova.turnir4gk.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Tournament::class], version = 1)
abstract class MainDatabase : RoomDatabase() {
    abstract fun tournaments(): TournamentDao
}
