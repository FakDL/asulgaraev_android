package com.example.mobile_course

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.mobile_course.R
import com.example.mobile_course.repository.SongRepository
import com.example.mobile_course.screens.songsList.SongsListFragment
import com.example.mobile_course.service.SongService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_song.*

class MainActivity : AppCompatActivity() {

    var songService: ISongAidlInterface? = null
    lateinit var builder: NotificationCompat.Builder
    val CHANNEL_ID = "playerChannel"

    private val aidlConnection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            Log.e("LOG_TAG", "MainActivity onServiceConnected")
            songService = ISongAidlInterface.Stub.asInterface(service)
            supportFragmentManager.beginTransaction().
            replace(R.id.frameLayout, SongsListFragment()).commit()
        }

        override fun onServiceDisconnected(className: ComponentName) {
            Log.e("LOG_TAG", "MainActivity onServiceDisconnected")
            songService = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val intent =
            Intent(this, SongService::class.java)
        bindService(intent, aidlConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("LOG_TAG", "MainActivity onServiceDisconnected")
        songService?.let {
            unbindService(aidlConnection)
            songService = null
        }

    }

//    private fun createChannel(){
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            val serviceChannel =
//                NotificationChannel(CHANNEL_ID, "Player channel",
//                NotificationManager.IMPORTANCE_DEFAULT)
//            val manager: NotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
//            manager.createNotificationChannel(serviceChannel)
//        }
//    }
//    fun createNotification(song: Song){
//         builder = NotificationCompat.Builder(this, CHANNEL_ID).
//
//    }

}
