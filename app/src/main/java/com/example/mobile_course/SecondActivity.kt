package com.example.mobile_course

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

    }

    fun toReg(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("username", et_username.text.toString())
        intent.putExtra("name", et_name.text.toString())
        startActivity(intent)
    }

}