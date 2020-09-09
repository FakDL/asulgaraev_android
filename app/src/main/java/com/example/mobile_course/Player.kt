package com.example.mobile_course

class Player(val name: String? = "Alesha") {
    val isEmpty: Boolean?
        get() = name.length == 0
}