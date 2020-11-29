package com.example.mobile_course.repository

import android.os.Parcel
import com.example.mobile_course.R
import com.example.mobile_course.Song

object SongRepository {
    val songsList: List<Song> = arrayListOf(
        Song("Славка","Он все видит по глазам!!", R.drawable.ic_sad, R.raw.eyes),
        Song("MGMT","Little dark age", R.drawable.maxresdefault, R.raw.mgmt)
    )
}