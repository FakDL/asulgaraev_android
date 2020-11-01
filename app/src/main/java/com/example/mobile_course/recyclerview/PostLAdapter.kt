package com.example.mobile_course.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_course.R
import com.example.mobile_course.models.PostL
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_l_post.*

class PostLAdapter (
    private var list: ArrayList<PostL>
) : RecyclerView.Adapter<PostLAdapter.PostLHolder>() {

    inner class PostLHolder(
        override val containerView: View
    ): RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(postL: PostL, position: Int) {
            with(postL) {
                tv_l_title.text = title
                tv_l_desc.text = desc
            }
            viewpager.adapter = ViewPagerAdapter(list[position].imgs)
            indicator.setViewPager(viewpager)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostLHolder {
        return PostLHolder(LayoutInflater.from(parent.context).
        inflate(R.layout.item_l_post, parent, false))
    }

    override fun onBindViewHolder(holder: PostLHolder, position: Int) {
        holder.bind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}