package com.example.mobile_course

class Berserk(override var name : String = "Berserk"): Player(){
    override fun attack(enemy: Player) {
        var damage: Int
        if(hp <= 35) {
            damage = 35
        } else damage = 20
        enemy.hp -= damage
        hp += damage / 20
    }
}