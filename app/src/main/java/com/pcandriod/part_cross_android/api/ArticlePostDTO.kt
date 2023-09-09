package com.pcandriod.part_cross_android.api


import com.squareup.moshi.Json

data class ArticlePostDTO(
    @Json(name = "body")
    val body: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "tagList")
    val tagList: List<String>,
    @Json(name = "title")
    val title: String
)