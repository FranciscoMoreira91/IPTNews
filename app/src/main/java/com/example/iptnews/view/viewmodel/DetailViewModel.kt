package com.example.iptnews.view.viewmodel

import android.content.Intent.getIntent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.iptnews.view.model.Noticias


class DetailViewModel : ViewModel() {

    val news =  MutableLiveData<Noticias>()

    fun fetch (detalhes:Noticias) {
        news.value = detalhes
    }
}