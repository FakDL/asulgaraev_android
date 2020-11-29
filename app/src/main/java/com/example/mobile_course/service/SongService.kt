package com.example.mobile_course.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import com.example.mobile_course.Song
import com.example.mobile_course.ISongAidlInterface
import com.example.mobile_course.R
import com.example.mobile_course.repository.SongRepository

class SongService: Service() {
    private var mediaPlayer: MediaPlayer = MediaPlayer()
    private var isPlayerReleased = true

    private lateinit var serviceSong: Song

    private val mBinder: ISongAidlInterface.Stub = object : ISongAidlInterface.Stub() {

        override fun play() {
            mediaPlayer.start()
        }

        override fun pause() {
            mediaPlayer.pause()
        }

        override fun isPlaying() = mediaPlayer.isPlaying

        override fun isMPReleased(): Boolean = isPlayerReleased

        override fun getSong(): Song? {
            return serviceSong
        }

        override fun getDuration(): Int {
            return mediaPlayer.duration
        }

        override fun getCurrentPosition(): Int {
            return mediaPlayer.currentPosition
        }

        override fun changeTime(time: Int) {
            mediaPlayer.seekTo(time)
        }

        override fun playNext() {
            var position = SongRepository.songsList.indexOf(song)
            position = if (position + 1 == SongRepository.songsList.size) 0 else position + 1
            setCurrentSong(position)
        }

        override fun playPrev() {
            var position = SongRepository.songsList.indexOf(song)
            position = if (position == 0) SongRepository.songsList.size-1 else position - 1
            setCurrentSong(position)
        }

        override fun setCurrentSong(position: Int) {
            serviceSong = SongRepository.songsList[position]
            playSong(serviceSong)
        }

        override fun setCurrentSongFromBundle(bundle: Bundle) {
            with(bundle) {
                classLoader = this@SongService.classLoader
                getParcelable<Song>("key_song").also {
                }
            }
        }
    }



    override fun onBind(intent: Intent): IBinder = mBinder

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

    /**
     * When you call create, file is already prepared and don't need call prepare() method
     */
    private fun playSong(song: Song) {
        if (mediaPlayer.isPlaying) mediaPlayer.stop()
        mediaPlayer = MediaPlayer.create(applicationContext, song.songId)
        isPlayerReleased = false
        mediaPlayer.run {
            start()
            setOnCompletionListener {
                stop() // or call next() for change track
            }
        }
    }

}