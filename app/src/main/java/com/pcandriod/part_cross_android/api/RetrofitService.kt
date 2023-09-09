package com.pcandriod.part_cross_android.api

import android.telecom.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("/api/vl/articles")
    fun getPostList(): retrofit2.Call<ArticleList>

    @GET("/api/v1/articles/{articleId}")
    fun getDetailContent(@Path("articleId")articleId:Int): retrofit2.Call<ArticleList.ArticleResponse>

}