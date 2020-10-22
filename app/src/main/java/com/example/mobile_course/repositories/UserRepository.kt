package com.example.mobile_course.repositories

import com.example.mobile_course.R
import com.example.mobile_course.data.UserData
import com.example.mobile_course.models.User

class UserRepository{
    public fun getUserById(id: Int?): User? {
        UserData.objects.forEach { u -> if (u.id == id) return u }
        return User(7, R.mipmap.ic_fat,"SSSS", "deadinside")
    }
}