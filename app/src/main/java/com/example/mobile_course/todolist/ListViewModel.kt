package com.example.mobile_course.todolist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mobile_course.database.Goal
import com.example.mobile_course.database.GoalDatabase
import com.example.mobile_course.repository.GoalRepository
import kotlinx.coroutines.launch

class ListViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val goalRepository: GoalRepository = GoalRepository(application)

    private val _navigateToCreate = MutableLiveData<Goal?>()
    val navigateToCreate: LiveData<Goal?>
        get() = _navigateToCreate

    fun getAllGoals(): LiveData<List<Goal>> = goalRepository.getAll()

    fun insert(goal: Goal) {
        viewModelScope.launch {
            goalRepository.insert(goal)
        }
    }
    fun update(goal: Goal) {
        viewModelScope.launch {
            goalRepository.update(goal)
        }
    }
    fun delete(goal: Goal) {
        viewModelScope.launch {
            goalRepository.delete(goal)
        }
    }
    fun clear() {
        viewModelScope.launch {
            goalRepository.clear()
        }
    }

    fun doneNavigating() {
        _navigateToCreate.value = null
    }

}