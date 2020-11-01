package com.example.mobile_course.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_course.R
import com.example.mobile_course.models.PostS
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_sm_post.*


class PostSHolder(
    override val containerView: View,
    private val clickLambda: (Int) -> Unit,
    private val deleteLambda: (Int) -> Unit
): RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(postS: PostS, position: Int) {
        with(postS) {
            tv_sm_title.text = title
            tv_sm_desc.text = desc
        }
        iv_sm_delete.setOnClickListener { deleteLambda(position) }
    }


    companion object {
        fun create(parent: ViewGroup, clickLambda: (Int) -> Unit, deleteLambda: (Int) -> Unit):
                PostSHolder = PostSHolder(
            LayoutInflater.from(parent.context).
            inflate(R.layout.item_sm_post, parent, false), clickLambda, deleteLambda)
    }
}
