package com.example.httpclienttest.data.repositories

import android.util.Log
import com.example.httpclienttest.data.model.Posts
import com.example.httpclienttest.data.remote.RetrofiInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostsRepository {
    suspend fun fetchPosts(): List<Posts>? {
        return withContext(Dispatchers.IO) {
            try {
                val response = RetrofiInstance.api.getAllPosts().execute()

                if (response.isSuccessful) {
                    response.body()
                } else {
                    Log.e("API_ERROR", "Error: ${response.code()}")
                    null
                }
            } catch (e: Exception) {
                Log.e("API_ERROR", "Exception: ${e.message}")
                null
            }
        }
    }

    suspend fun getPostbyId(id: Int): Posts? {
        return withContext(Dispatchers.IO) {
            val response =
                RetrofiInstance.api.getPostsbyId(id).execute()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
    }
}
