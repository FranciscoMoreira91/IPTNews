package com.example.iptnews.view.model
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
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
    val categories : String?
): Parcelable

@Parcelize
data class Enclosure(
    @SerializedName("link")
    val link : String?,
    @SerializedName("type")
    val type : String?,
): Parcelable
