package com.mfathurz.androidarchexample.core.data

import com.mfathurz.androidarchexample.core.data.source.ApiConfig
import com.mfathurz.androidarchexample.core.data.source.model.UserResponse

class Repository {

    suspend fun getAllPosts(): List<UserResponse> {
        return try {
            val response = ApiConfig.provideApiService().getPosts()
            response.body()!!
        } catch (e: Exception) {
            emptyList()
        }
    }

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(): Repository = instance ?: synchronized(this) {
            instance ?: Repository()
        }
    }


}