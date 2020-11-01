package com.example.mobile_course.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.mobile_course.R
import com.example.mobile_course.data.PostSList
import com.example.mobile_course.models.PostS
import kotlinx.android.synthetic.main.fragment_add_dialog.*


class AddDialogFragment: DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(
            R.layout.fragment_add_dialog, container, false
        )

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        cancel_button.setOnClickListener { dismiss() }
        ok_button.setOnClickListener {
            val position: Int = et_position.text.toString().toInt()
            val title = et_title.text.toString()
            val desc = et_desc.text.toString()

            if (position > PostSList.list.size)
                PostSList.list.add(PostS(PostSList.list.size + 1, title, desc))
            else{
                PostSList.list.add(PostSList.list[PostSList.list.size - 1])
                for (i in PostSList.list.size-1 downTo position+1) {
                    PostSList.list.set(i - 1, PostSList.list[i - 2])
                }
                PostSList.list[position - 1] = PostS(position, title, desc)
            }
            val intent = Intent()
            targetFragment!!.onActivityResult(targetRequestCode, Activity.RESULT_OK, intent)
            dismiss()
        }
        super.onViewCreated(view, savedInstanceState)
    }

}