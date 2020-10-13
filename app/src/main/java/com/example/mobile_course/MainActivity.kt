package com.example.mobile_course

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobile_course.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager

        val homeFragment = HomeFragment()
        val searchFragment = SearchFragment()
        val profileFragment = ProfileFragment()
        val settingsFragment = SettingsFragment()
        val infoFragment = InfoFragment()
        var active: Fragment = homeFragment

        fm.beginTransaction().add(R.id.container, homeFragment).commit()
        fm.beginTransaction().add(R.id.container,searchFragment).hide(searchFragment).commit()
        fm.beginTransaction().add(R.id.container,profileFragment).hide(profileFragment).commit()
        fm.beginTransaction().add(R.id.container,settingsFragment).hide(settingsFragment).commit()
        fm.beginTransaction().add(R.id.container,infoFragment).hide(infoFragment).commit()

        val iv_array: Array<ImageView> =
            arrayOf(iv_home, iv_search, iv_profile, iv_settings, iv_info)

        iv_home.setOnClickListener {
            setIVSelected(iv_home, iv_array)
            fm.beginTransaction().hide(active).show(homeFragment).commit()
            active = homeFragment
        }
        iv_search.setOnClickListener {
            setIVSelected(iv_search, iv_array)
            fm.beginTransaction().hide(active).show(searchFragment).commit()
            active = searchFragment
        }
        iv_profile.setOnClickListener {
            setIVSelected(iv_profile, iv_array)
            fm.beginTransaction().hide(active).show(profileFragment).commit()
            active = profileFragment
        }
        iv_settings.setOnClickListener {
            setIVSelected(iv_settings, iv_array)
            fm.beginTransaction().hide(active).show(settingsFragment).commit()
            active = settingsFragment
        }
        iv_info.setOnClickListener {
            setIVSelected(iv_info, iv_array)
            fm.beginTransaction().hide(active).show(infoFragment).commit()
            active = infoFragment
        }
    }
    fun setIVSelected(iv: ImageView, array: Array<ImageView>) {
        iv.isSelected = true
        for (imageView in array) {
            if (imageView == iv) continue
            imageView.isSelected = false
        }

    }
}