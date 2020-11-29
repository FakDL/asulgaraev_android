package com.example.mobile_course.adapters


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_course.MainActivity
import com.example.mobile_course.R
import com.example.mobile_course.Song
import com.example.mobile_course.screens.song.SongFragment
import com.example.mobile_course.screens.songsList.SongsListFragment
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_song.*


class SongAdapter (
    private var list: ArrayList<Song>,
    private val fragmentLambda: (View, Int) -> Unit
) : RecyclerView.Adapter<SongAdapter.PostLHolder>() {

    inner class PostLHolder(
        override val containerView: View
    ): RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(song: Song, position: Int) {
            with(song) {
                tv_sm_title.text = name
                tv_sm_author.text = author
                iv_sm_album.setImageResource(song.photoId)
            }

            itemView.setOnClickListener{fragmentLambda(itemView,position)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostLHolder {
        return PostLHolder(LayoutInflater.from(parent.context).
        inflate(R.layout.item_song, parent, false))
    }

    override fun onBindViewHolder(holder: PostLHolder, position: Int) {
        holder.bind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}