package com.example.mobile_course

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_course.models.User



class UserAdapter(
    private val list: Array<User>,
    private val clickLambda:(Int) -> Unit
): RecyclerView.Adapter<UserHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder =
        UserHolder.create(parent, clickLambda)

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(list[position])
    }

}