package com.example.mobile_course.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.example.mobile_course.models.PostS

class PostDiffCallback(
    private val oldList: ArrayList<PostS>,
    private val newList: ArrayList<PostS>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]

}