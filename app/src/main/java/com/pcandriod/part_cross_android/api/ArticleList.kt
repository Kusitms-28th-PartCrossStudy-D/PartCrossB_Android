package com.pcandriod.part_cross_android.api

import com.squareup.moshi.Json

data class ArticleList(
    @Json(name = "data")
    val `data`: List<Data>,
    @Json(name = "isSuccess")
    val isSuccess: Boolean,
    @Json(name = "message")
    val message: String
) {
    data class Data(
        @Json(name = "articleId")
        val articleId: Int,
        @Json(name = "body")
        val body: String,
        @Json(name = "createdAt")
        val createdAt: String,
        @Json(name = "description")
        val description: String,
        @Json(name = "tagList")
        val tagList: List<String>,
        @Json(name = "title")
        val title: String,
        @Json(name = "updatedAt")
        val updatedAt: String
    )
}