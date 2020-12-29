package com.example.mobile_course.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_course.R
import com.example.mobile_course.database.Goal
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_goal.*

class ListAdapter(
    val clickLambda: (goal: Goal) -> Unit,
    val deleteLambda: (goal: Goal) -> Unit,
    private var list: LiveData<List<Goal>>
) : RecyclerView.Adapter<ListAdapter.PostLHolder>() {
    private lateinit var goals: List<Goal>

    inner class PostLHolder(
        override val containerView: View
    ): RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(goal: Goal, position: Int) {
            with(goal) {
                tv_title.text = title
                tv_description.text = description
            }
            itemView.setOnClickListener{clickLambda(goal)}
            btn_delete.setOnClickListener{deleteLambda(goal)}
        }
    }

    fun setGoals(goals: List<Goal>) {
        this.goals = goals
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostLHolder {
        return PostLHolder(
            LayoutInflater.from(parent.context).
        inflate(R.layout.item_goal, parent, false))
    }

    override fun onBindViewHolder(holder: PostLHolder, position: Int) {
        holder.bind(goals.get(position), position)
    }

    override fun getItemCount(): Int = goals.size
}