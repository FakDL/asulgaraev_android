package com.example.mobile_course

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentExtras = intent.extras
        supportActionBar?.title = intentExtras?.getString("username")
        tv_name.text = intentExtras?.getString("name")

    }

    fun toEdit(view: View){
        my_switcher.showNext()
        var name = et_name.text
        tv_name.text = name
    }
}