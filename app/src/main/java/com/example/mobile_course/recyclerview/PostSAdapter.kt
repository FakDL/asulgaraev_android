package com.example.mobile_course.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_course.models.PostS

class PostSAdapter(
    private var list: ArrayList<PostS>,
    private val clickLambda:(Int) -> Unit,
    private val deleteLambda:(Int) -> Unit
): RecyclerView.Adapter<PostSHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostSHolder =
        PostSHolder.create(parent, clickLambda, deleteLambda)

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PostSHolder, position: Int) {
        holder.bind(list.get(position), position)
    }

    fun delete(position: Int){
        list.removeAt(position)
        notifyDataSetChanged()
    }


    fun updateDataSource(postS: PostS, position: Int) {
        val newList = list

        val callback = PostDiffCallback(list, newList)
        val result = DiffUtil.calculateDiff(callback, true)
        result.dispatchUpdatesTo(this)
        list = newList
    }

}