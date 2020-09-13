package com.example.mobile_course

class Wizard(override var name: String = "Merlin"): Player(){
    var mana: Int = 100
    override fun attack(enemy: Player) {
        if(mana >= 20) {
            enemy.hp -= 35
            mana -= 50
        } else enemy.hp -= 20
    }
}