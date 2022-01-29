package com.example.iptnews.view.model

import android.util.Log
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NoticiasAPIService {
    private val BASE_URL = "https://jsonkeeper.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(NoticiasAPI::class.java)

    fun getUltimas(): Single<List<Noticias>>{
        return api.getUltimas()
    }

    fun getDesporto(): Single<List<Noticias>>{
        return api.getDesporto()
    }

    fun getEconomia(): Single<List<Noticias>>{
        return api.getEconomia()
    }

    fun getPolitica(): Single<List<Noticias>>{
        return api.getPolitica()
    }

    fun getMundo(): Single<List<Noticias>>{
        return api.getMundo()
    }
}