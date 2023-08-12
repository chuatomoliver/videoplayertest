package com.example.videoplayer.feature.movieplayer

import android.content.DialogInterface
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.videoplayer.databinding.ActivityMoviePlayerBinding
import com.example.videoplayer.util.AppConstant
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MoviePlayerActivity : AppCompatActivity() {

    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
       finish()
    }

    val negativeButtonClick = { dialog: DialogInterface, which: Int ->
        with(binding.vdVw) {
            setVideoPath(sampleURL)
            start()
        }
    }

    private val sampleURL =
        "https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1"
    var URL = ""
    private lateinit var binding: ActivityMoviePlayerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviePlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(binding.vdVw)
        URL = sampleURL
        if (intent.hasExtra(AppConstant.INTENT_URL)) {
            URL = intent.getStringExtra(AppConstant.INTENT_URL)!!
            Log.d("URL", URL)
        }

        //Starting VideView By Setting MediaController and URL
        with(binding.vdVw) {
            setMediaController(mediaController)
            setVideoPath(URL)
            setOnErrorListener { mediaPlayer, i, i1 ->
                basicAlert(this,URL)
                true
            }
            start()
        }

    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        println("IN onConfigurationChanged()")
    }

    override fun onBackPressed() {
        finish()
    }

    fun basicAlert(view: View,url: String){

        val builder = AlertDialog.Builder(this)

        with(builder)
        {
            setTitle("Cannot Play Video URL")
            setMessage("URL: $url")
            setPositiveButton("OK", positiveButtonClick)
            setNegativeButton("Play Sample URL", negativeButtonClick)
            show()
        }


    }
}

