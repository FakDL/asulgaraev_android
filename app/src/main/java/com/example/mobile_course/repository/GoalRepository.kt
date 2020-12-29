package com.example.mobile_course.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.Query
import androidx.room.Update
import com.example.mobile_course.database.Goal
import com.example.mobile_course.database.GoalDatabase
import com.example.mobile_course.database.GoalDatabaseDao
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class GoalRepository(application: Application) {

    private lateinit var goals: LiveData<List<Goal>>

    private val database = GoalDatabase.getInstance(application)
    private val databaseDao = database.goalDatabaseDao

    suspend fun insert(goal: Goal) = databaseDao.insert(goal)

    suspend fun update(goal: Goal) = databaseDao.update(goal)

    suspend fun get(key: Long): Goal? = databaseDao.get(key)

    suspend fun delete(goal: Goal) = databaseDao.delete(goal)

    suspend fun clear() = databaseDao.clear()

    fun getAll() = databaseDao.getAll()

}