package com.example.iptnews.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.iptnews.view.model.Noticias

class DetailViewModel : ViewModel() {

    val newsLiveData =  MutableLiveData<Noticias>()

    fun fetch () {

        newsLiveData.value
    }
}