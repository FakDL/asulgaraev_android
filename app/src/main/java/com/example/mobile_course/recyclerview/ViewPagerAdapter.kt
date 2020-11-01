package com.example.mobile_course.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_course.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_page.*

class ViewPagerAdapter(
    private var list: ArrayList<Int>
) : RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(
        override val containerView: View
    ): RecyclerView.ViewHolder(containerView), LayoutContainer {
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).
        inflate(R.layout.item_page, parent, false))
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.Pager2ViewHolder, position: Int) {
        holder.image.setImageResource(list[position])
    }

    override fun getItemCount(): Int = list.size

}