package com.pcandriod.part_cross_android.api

import com.google.gson.annotations.SerializedName

data class ArticleList(
    @SerializedName("isSuccess")
    val isSuccess: Boolean,

    @SerializedName("message")
    val message: String,

    @SerializedName("data")
    val data: List<Data>,
)

data class Data(
    @SerializedName("articleId")
    val articleId: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("body")
    val body: String,
)