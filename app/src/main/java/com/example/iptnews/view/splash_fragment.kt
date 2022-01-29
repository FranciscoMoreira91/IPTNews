package com.example.iptnews.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.iptnews.R


class splash_fragment : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_list_news)


        supportActionBar?.hide()

        Handler().postDelayed({
            startActivity(Intent(this, fragmentListNews::class.java))
            finish()
        }, 3000)


    }


}