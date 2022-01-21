package com.example.iptnews.view.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.iptnews.view.model.Noticias

class ListViewModel : ViewModel(){

    val news = MutableLiveData<List<Noticias>>()
    val NewsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh ()
    {

        val news1 = Noticias(titulo = "Noticia", autor = "chow chow", descr = "bla bla bla", DataP = "09/09/2022", url = "")
        val news2 = Noticias(titulo = "Noticia2", autor = "chow 2", descr = "bla bla bla", DataP = "04/09/2022", url = "")
        val news3 = Noticias(titulo = "Noticia3", autor = "chow 3", descr = "bla bla bla", DataP = "08/09/2022", url = "")

        val newsList = arrayListOf<Noticias>(news1, news2, news3)

        news.value = newsList
        NewsLoadError.value = false
        loading.value = false
    }
}