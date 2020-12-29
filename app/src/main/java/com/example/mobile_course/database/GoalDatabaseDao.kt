package com.example.mobile_course.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GoalDatabaseDao {

    @Insert
    suspend fun insert(goal: Goal)

    @Update
    suspend fun update(goal: Goal)

    @Delete
    suspend fun delete(goal: Goal)

    @Query("SELECT * from goal_table WHERE goalId = :key")
    suspend fun get(key: Long): Goal?

    @Query("DELETE FROM goal_table")
    suspend fun clear()

    @Query("SELECT * FROM goal_table ORDER BY goalId DESC")
    fun getAll(): LiveData<List<Goal>>

}
