package com.example.iptnews.view.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.iptnews.view.model.Noticias
import com.example.iptnews.view.model.NoticiasAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class LatestModel() : ViewModel(){

    private val noticiasService = NoticiasAPIService()
    private val disposable = CompositeDisposable()

    val news = MutableLiveData<List<Noticias>>()
    val NewsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh ()
    { fetchFromRemote()
    }

    private fun fetchFromRemote () {
        loading.value = true
        disposable.add (
            noticiasService.getUltimas()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<List<Noticias>>() {

                    override fun onSuccess(newsList: List<Noticias>) {
                        news.value = newsList
                        NewsLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        NewsLoadError.value = true
                        loading.value = false
                        e.printStackTrace()
                    }

                })
        )

    }

}