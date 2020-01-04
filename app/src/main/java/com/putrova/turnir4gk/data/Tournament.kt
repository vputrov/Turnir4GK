package com.putrova.turnir4gk.data

import androidx.room.*
import java.util.*

@Entity
data class Tournament(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "date") val date: Long,
    @ColumnInfo(name = "question_count") val questionCount: Int
)

@Dao
interface TournamentDao {
    @Query("SELECT * FROM tournament")
    fun getAll(): List<Tournament>

    @Query("SELECT * FROM tournament WHERE uid IN (:ids)")
    fun loadAllByIds(ids: IntArray): List<Tournament>

    @Query("SELECT * FROM tournament WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Tournament

    @Insert
    fun insertAll(vararg tournaments: Tournament)

    @Delete
    fun delete(tournament: Tournament)
}
