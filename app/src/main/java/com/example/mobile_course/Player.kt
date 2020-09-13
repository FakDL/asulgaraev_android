package com.example.mobile_course

open class Player(open val name: String? = ""): PlayerInterface {
    var hp: Int = 100
    val isDead: Boolean?
        get() = hp <= 100

    override fun attack(enemy: Player) {
    }
}