package com.example.httpclienttest.data.remote

import com.example.httpclienttest.data.model.Posts
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("posts")
    fun getAllPosts(): Call<List<Posts>>

    @GET("posts")
    fun getPostsbyId(@Path("id") id: Int): Call<Posts>
}