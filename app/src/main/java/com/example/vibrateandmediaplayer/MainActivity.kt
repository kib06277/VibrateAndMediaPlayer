package com.example.vibrateandmediaplayer

import android.content.Context
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.os.VibratorManager
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

class MainActivity : AppCompatActivity() {

    private var time = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val vibratorManager = getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                vibratorManager.defaultVibrator
            } else {
                @Suppress("DEPRECATION")
                getSystemService(VIBRATOR_SERVICE) as Vibrator
            }
            val mediaPlayer = MediaPlayer.create(this, R.raw.msg)//msg是滴的MP3文件，很小

            vibrator.vibrate(1000)
            mediaPlayer.start()

            /*
            //計時器
            time.scheduleAtFixedRate( object : TimerTask() {
                override fun run() {
                    try {

                    } catch (e : Exception) {
                        Log.i("Error" , "e = $e")
                    }
                }
            }, 0, 100)
             */

        } catch ( e : Exception) {
            Log.i("EE" , "e = $e")
        }
    }
}