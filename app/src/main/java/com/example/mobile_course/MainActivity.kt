package com.example.mobile_course

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobile_course.fragments.EditFragment
import com.example.mobile_course.fragments.HomeFragment
import com.example.mobile_course.fragments.ListFragment
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragments = arrayOf(HomeFragment(), EditFragment(), ListFragment())
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragments[0]).commit()


        bottomNavigationView.setOnNavigationItemSelectedListener {
            val transaction = supportFragmentManager.beginTransaction()
            when (it.itemId) {
                R.id.homeFragment -> {
                    transaction.replace(R.id.frameLayout, fragments[0]).commit()
                    true
                }
                R.id.editFragment -> {
                    transaction.replace(R.id.frameLayout, fragments[1]).commit()
                    true
                }
                R.id.listFragment -> {
                    transaction.replace(R.id.frameLayout, fragments[2]).commit()
                    true
                }

                else -> false
            }
        }
        bottomNavigationView.setOnNavigationItemReselectedListener {}

    }
}