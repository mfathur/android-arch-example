package com.mfathurz.androidarchexample.core.data.source

import com.mfathurz.androidarchexample.core.data.source.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): Response<List<UserResponse>>

}