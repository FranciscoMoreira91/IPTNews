package com.example.iptnews.view.model

import io.reactivex.Single
import retrofit2.http.GET

interface NoticiasAPI {
    @GET("/b/XIU5")
    fun getUltimas(): Single<List<Noticias>>

    @GET("/b/34AA")
    fun getDesporto(): Single<List<Noticias>>

    @GET("/b/FIC9")
    fun getEconomia(): Single<List<Noticias>>

    @GET("/b/XWNW")
    fun getPolitica(): Single<List<Noticias>>

    @GET("/b/NAF4")
    fun getMundo(): Single<List<Noticias>>
}