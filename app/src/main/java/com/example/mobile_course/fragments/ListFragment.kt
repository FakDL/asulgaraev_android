package com.example.mobile_course.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobile_course.R
import com.example.mobile_course.data.PostLList
import com.example.mobile_course.models.PostL
import com.example.mobile_course.recyclerview.PostLAdapter
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment: Fragment() {

    private var adapter: PostLAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        adapter = PostLAdapter(PostLList.list)
        rv_l_post.adapter = adapter
        super.onViewCreated(view, savedInstanceState)

    }
}