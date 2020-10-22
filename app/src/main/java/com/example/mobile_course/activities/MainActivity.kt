package com.example.mobile_course.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile_course.R
import com.example.mobile_course.UserAdapter
import com.example.mobile_course.data.UserData
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_user.adapter = UserAdapter(UserData.objects) { id -> navigateToDescription(id) }

    }
    private fun navigateToDescription(id: Int) {
        startActivity(SecondActivity.createIntent(this, id))
    }
}