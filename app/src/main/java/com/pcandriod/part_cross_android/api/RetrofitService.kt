package com.pcandriod.part_cross_android.api

import android.telecom.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("/api/vl/articles")
    fun getPostList(): retrofit2.Call<ArticleList>

}