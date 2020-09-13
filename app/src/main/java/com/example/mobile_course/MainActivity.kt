package com.example.mobile_course

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var warior1: Berserk = Berserk("Guts");
        var warior2: Wizard = Wizard()
        with(warior2) {
            attack(warior1);
            Log.d("GAME", warior1.name + " hp = " + warior1.hp)
            attack(warior1);
            Log.d("GAME", warior1.name + " hp = " + warior1.hp)
            attack(warior1);
            Log.d("GAME", warior1.name + " hp = " + warior1.hp)
        }
        with(warior1) {
            attack(warior2);
            Log.d("GAME", warior2.name + " hp = " + warior2.hp)
            Log.d("GAME", warior1.name + " hp = " + warior1.hp)
        }
    }
}