package com.example.mobile_course.screens.songsList

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mobile_course.ISongAidlInterface
import com.example.mobile_course.MainActivity
import com.example.mobile_course.R
import com.example.mobile_course.Song
import com.example.mobile_course.adapters.SongAdapter
import com.example.mobile_course.repository.SongRepository
import com.example.mobile_course.screens.song.SongFragment
import kotlinx.android.synthetic.main.fragment_song.*
import kotlinx.android.synthetic.main.fragment_songs_list.*
import kotlinx.android.synthetic.main.item_song.*
import kotlinx.android.synthetic.main.item_song.view.*

class SongsListFragment : Fragment() {

    private var adapter: SongAdapter? = null
    var service: ISongAidlInterface? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_songs_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity =(activity as MainActivity?)
        service = activity?.songService
        adapter = SongAdapter(SongRepository.songsList as ArrayList<Song>) { item, position ->
            val transaction = activity?.supportFragmentManager?.beginTransaction()

            transaction?.addToBackStack(null)
            item.setOnClickListener {
                 if(service?.isMPReleased == true ||
                    service?.song != SongRepository.songsList[position]){
                     service?.setCurrentSong(position)
                }

                transaction?.replace(R.id.frameLayout,
                    SongFragment())?.commit()

            }

//            iv_play.setOnClickListener {
//                when {
//                    service?.isMPReleased == true -> {
//                        service?.setCurrentSong(position)
//                    }
//                    service?.isPlaying == true -> {
//                        iv_play.setImageResource(R.drawable.ic_play)
//                        service?.pause()
//                    }
//                    service?.isPlaying == false -> {
//                        iv_play.setImageResource(R.drawable.ic_pause)
//                        service?.play()
//                    }
//                }
//                adapter?.notifyDataSetChanged()
//            }
//
//            if (service?.isPlaying == true) {
//                    iv_play.setImageResource(R.drawable.ic_play)
//                    adapter?.notifyDataSetChanged()
//            }
//            else if (service?.isPlaying == false){
//                    iv_play.setImageResource(R.drawable.ic_pause)
////                    adapter?.notifyDataSetChanged()
//                }
//            }
        }
        rv_song.adapter = adapter
    }
}