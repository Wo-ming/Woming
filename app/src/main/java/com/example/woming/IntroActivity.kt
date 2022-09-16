package com.example.woming

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.view.WindowInsets
import android.view.WindowManager

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        var handler = Handler()
        handler.postDelayed( {
            var intent = Intent( this, MainActivity::class.java)
            startActivity(intent)
        }, 1000)

        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }


//    override fun onPause() {
//        super.onPause()
//        finish()

//        SystemClock.sleep(3000)
//        val intent=Intent(this,IntroActivity::class.java)
//        startActivity(intent)
//        finish()
//    }
}