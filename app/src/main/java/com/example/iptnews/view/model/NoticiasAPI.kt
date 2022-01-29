package com.example.iptnews.view.model

import io.reactivex.Single
import retrofit2.http.GET

interface NoticiasAPI {
    @GET("/b/PRDH")
    fun getUltimas(): Single<List<Noticias>>

    @GET("desporto")
    fun getDesporto(): Single<List<Noticias>>

    @GET("economia")
    fun getEconomia(): Single<List<Noticias>>

    @GET("politica")
    fun getPolitica(): Single<List<Noticias>>

    @GET("mundo")
    fun getMundo(): Single<List<Noticias>>
}