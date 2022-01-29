package com.example.iptnews.view

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.iptnews.R
import com.example.iptnews.view.viewmodel.DetailViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_details_news.*


class fragmentDetailsNews : Fragment() {

    private lateinit var viewModel: DetailViewModel
    private var detalhes = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details_news, container, false)


    }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)


            arguments?.let {
                detalhes = fragmentDetailsNewsArgs.fromBundle(it).detalhes
            }
            observeViewModel()
        }

    private fun observeViewModel () {

        viewModel.newsLiveData.observe(viewLifecycleOwner, Observer { news ->
            news?.let {

            }
        })

    }
    }
