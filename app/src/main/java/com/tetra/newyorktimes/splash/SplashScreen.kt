package com.tetra.newyorktimes.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.tetra.newyorktimes.R
import com.tetra.newyorktimes.popularArticle.view.PopularArticleActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        Handler().postDelayed({
            val intent = Intent(this, PopularArticleActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }

    override fun onBackPressed() {
        /*TODO*/
    }
}