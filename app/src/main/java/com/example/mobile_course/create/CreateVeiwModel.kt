package com.example.mobile_course.create

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_course.database.Goal
import com.example.mobile_course.repository.GoalRepository
import kotlinx.coroutines.launch

class CreateViewModel(
    var goalKey: Long = 0L,
    val goalRepository: GoalRepository
) : ViewModel() {

    private val _navigateToList = MutableLiveData<Boolean?>()
    val navigateToList: LiveData<Boolean?>
        get() = _navigateToList

    fun doneNavigating() {
        _navigateToList.value = null
    }

    fun onSetGoal(goal: Goal) {
        if (goalKey == -1L) {
            viewModelScope.launch {
                goalRepository.insert(goal)
            }
        }else{
            viewModelScope.launch {
                goalRepository.update(goal)
            }
        }
        _navigateToList.value = true
    }
}
