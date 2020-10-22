package com.example.mobile_course

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_course.models.User
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_user.*


class UserHolder(
    override val containerView: View,
    private val clickLambda: (Int) -> Unit
): RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(user: User) {
        iv_user.setImageResource(user.iv_id)
        tv_name.text = user.name
        tv_desc.text = user.desc
        itemView.setOnClickListener {
            clickLambda(user.id)
        }
    }

    companion object {
        fun create(parent: ViewGroup, clickLambda: (Int) -> Unit): UserHolder = UserHolder(
            LayoutInflater.from(parent.context).
        inflate(R.layout.item_user, parent, false), clickLambda)
    }
}