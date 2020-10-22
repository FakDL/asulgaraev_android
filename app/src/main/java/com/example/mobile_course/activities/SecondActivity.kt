package com.example.mobile_course.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mobile_course.R
import com.example.mobile_course.repositories.UserRepository
import kotlinx.android.synthetic.main.item_user.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val id = intent.extras?.getInt(KEY_ID)
        val user = UserRepository().getUserById(id)
        user?.iv_id?.let { iv_user.setImageResource(it) }
        tv_name.text = "Name: " + user?.name.toString()
        tv_desc.text = user?.desc.toString()

    }

    companion object {

        private const val KEY_ID = "id"

        fun createIntent(activity: Activity, id: Int) =
            Intent(activity, SecondActivity::class.java).apply {
                putExtra(KEY_ID, id)
            }
    }
}
