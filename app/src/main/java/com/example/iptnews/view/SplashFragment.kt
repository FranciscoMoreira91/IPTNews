package com.example.iptnews.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Spacer
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.iptnews.R
import kotlinx.android.synthetic.main.fragment_splash.*


class SplashFragment: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        ButtonHome.setOnClickListener {
            val action: NavDirections = SplashFragmentDirections.actionListNews()
            Navigation.findNavController(it).navigate(action)

        }


    }


}