package com.pcandriod.part_cross_android.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService {
    @GET("/api/v1/articles")
    fun getPostList(): Call<ArticleList>


}