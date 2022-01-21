package com.example.iptnews.view

import java.util.*

data class Noticias(
    val title: String,
    val pubDate: String,
    val link: String,
    val guid: String,
    val author: String,
    val description: String,
    val content: String,
    var enclosure: Image,
    val categories: Array<String>,

    ) {
}

data class Image(
    val link : String,
    val type : String
){}
