package com.example.iptnews.view.model


data class Noticias(
    @SerializedName("title")
    val title : String?,
    @SerializedName("pubDate")
    val pubDate : String?,
    @SerializedName("link")
    val link : String?,
    @SerializedName("guid")
    val guid : String?,
    @SerializedName("author")
    val author : String?
    @SerializedName("description")
    val description : String?
    @SerializedName("content")
    val content : String?
    @SerializedName("enclosure")
    val enclosure : String?
    @SerializedName("categories")
    val categories : String?
)
