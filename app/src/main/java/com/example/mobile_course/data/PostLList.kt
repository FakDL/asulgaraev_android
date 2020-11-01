package com.example.mobile_course.data

import com.example.mobile_course.R
import com.example.mobile_course.models.PostL

object PostLList {
    var list: ArrayList<PostL> = arrayListOf(
        PostL("nasa", arrayListOf(R.drawable.ic_add,R.drawable.ic_add,R.drawable.ic_edit), "ELON MUSK sucks"),
        PostL("spacex", arrayListOf(R.drawable.ic_add,R.drawable.ic_add,R.drawable.ic_home), "nasa sucks")
    )
}