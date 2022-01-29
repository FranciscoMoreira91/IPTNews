package com.example.iptnews.view.model
import com.google.gson.annotations.SerializedName

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
    val author : String?,
    @SerializedName("description")
    val description : String?,
    @SerializedName("content")
    val content : String?,
    @SerializedName("enclosure")
    val enclosure : Enclosure?,
    @SerializedName("categories")
    val categories : List<String>?
)

data class Enclosure(
    @SerializedName("link")
    val link : String?,
    @SerializedName("type")
    val type : String?,
)
