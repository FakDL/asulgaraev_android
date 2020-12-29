package com.example.mobile_course.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "goal_table")
data class Goal (
    @PrimaryKey(autoGenerate = true)
    var goalId: Long = 0L,

    @ColumnInfo(name = "start_time_milli")
    var title: String = "",

    @ColumnInfo(name = "end_time_milli")
    var description: String = ""
)